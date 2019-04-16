package org.protogalaxy.phss.service.main.filesystem.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.protogalaxy.phss.component.consts.AudioConsts;
import org.protogalaxy.phss.component.utils.FileUtils;
import org.protogalaxy.phss.component.consts.FileConsts;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicAlbumRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicTrackRepository;
import org.protogalaxy.phss.exception.application.filesystem.real.file.FileUtilsException;
import org.protogalaxy.phss.exception.application.filesystem.real.storage.StorageServiceException;
import org.protogalaxy.phss.service.config.StorageServiceConfig;
import org.protogalaxy.phss.service.main.filesystem.logic.FileRegisteringServiceImpl;
import org.protogalaxy.phss.service.main.filesystem.multimedia.MetadataServiceImpl;
import org.protogalaxy.phss.service.interfaces.filesystem.io.CacheService;
import org.protogalaxy.phss.service.interfaces.filesystem.io.PathService;
import org.protogalaxy.phss.service.interfaces.filesystem.io.StorageService;
import org.protogalaxy.phss.service.interfaces.filesystem.logic.FileRegisteringService;
import org.protogalaxy.phss.service.interfaces.filesystem.multimedia.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class StorageServiceImpl implements StorageService {
    private StorageServiceConfig config;

    private final PathService pathService;
    private final CacheService cacheService;
    private final MetadataService metadataService;
    private final FileRegisteringService fileRegisteringService;
    private final MusicTrackRepository musicTrackRepository;
    private final MusicAlbumRepository musicAlbumRepository;


    @Autowired
    public StorageServiceImpl(StorageServiceConfig config,
                              PathServiceImpl pathService,
                              CacheServiceImpl cacheService,
                              MetadataServiceImpl metadataService,
                              FileRegisteringServiceImpl fileRegisteringService,
                              MusicTrackRepository musicTrackRepository,
                              MusicAlbumRepository musicAlbumRepository) {
        this.config = config;
        this.pathService = pathService;
        this.cacheService = cacheService;
        this.metadataService = metadataService;
        this.fileRegisteringService = fileRegisteringService;
        this.musicTrackRepository = musicTrackRepository;
        this.musicAlbumRepository = musicAlbumRepository;
    }

    /**
     * Move file to another path
     *
     * @param fromPath Path where file will move from
     * @param toPath   Path where file will move to
     */
    @Override
    public void moveFile(Path fromPath, Path toPath) throws Exception {
        Files.move(fromPath, toPath);
    }

    /**
     * Store single track
     *
     * @param musicFile uploaded track
     * @return JSON format string of the uploaded track
     */
    @Override
    public MusicTrackEntity storeTrack(MultipartFile musicFile) throws Exception {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String fileName = StringUtils.cleanPath(musicFile.getOriginalFilename());//Get File name
        Path tempFilePath = cacheService.cacheFile(musicFile);
        Map<String, Object> metadata = metadataService.musicMetadataResolver(tempFilePath);
        //Check whether file already exists
        if (musicTrackRepository.findByFileSystemOwner_AccountEntity_UsernameAndTrackInformationStatic_Md5(SecurityContextHolder.getContext().getAuthentication().getName(), metadata.get(AudioConsts.METADATA_AUDIO_MD5).toString()).isPresent()) {
            try {
                Files.delete(tempFilePath);
            } catch (IOException e) {
                throw new StorageServiceException("File delete failed", e);
            }
            throw new FileUtilsException("Track already exist");
        }
        //Move track to correct path & register in database
        try {
            Path realPath = Files.move(tempFilePath, pathService.pathCheck(config.getRootLocation()
                                                                                 .resolve(username)
                                                                                 .resolve(config.getMusicLocation())
                                                                                 .resolve(metadata.get(AudioConsts.METADATA_AUDIO_ARTIST).toString())
                                                                                 .resolve(metadata.get(AudioConsts.METADATA_AUDIO_ALBUM).toString())
                                                                                 .resolve(fileName)), StandardCopyOption.REPLACE_EXISTING);
            return fileRegisteringService.registerTrack(metadata, realPath);
        } catch (IOException e) {
            throw new StorageServiceException("Could not register file", e);
        }
    }

    /**
     * Store tracks
     *
     * @param musicFiles uploaded tracks
     * @return JSON format string of the uploaded tracks
     */
    @Override
    public List<MusicTrackEntity> storeTracks(MultipartFile[] musicFiles) throws Exception {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<MusicTrackEntity> musicTrackEntities = new ArrayList<>();
        for (MultipartFile musicFile : musicFiles) {
            String fileName = StringUtils.cleanPath(musicFile.getOriginalFilename());
            Path tempFilePath = cacheService.cacheFile(musicFile);
            Map<String, Object> metadata = metadataService.musicMetadataResolver(tempFilePath);
            try {
                Path realPath = Files.move(tempFilePath, pathService.pathCheck(config.getRootLocation()
                                                                                     .resolve(username)
                                                                                     .resolve(config.getMusicLocation())
                                                                                     .resolve(metadata.get(AudioConsts.METADATA_AUDIO_ARTIST).toString())
                                                                                     .resolve(metadata.get(AudioConsts.METADATA_AUDIO_ALBUM).toString())
                                                                                     .resolve(fileName)), StandardCopyOption.REPLACE_EXISTING);
                musicTrackEntities.add(fileRegisteringService.registerTrack(metadata, realPath));
            } catch (IOException e) {
                throw new StorageServiceException("Could not register file", e);
            }
        }
        return musicTrackEntities;
    }

    @Override
    public void deleteTrack(UUID uuid) {
        try {
            Files.delete(Paths.get(musicTrackRepository.findByUuid(uuid).getLocation()));
        } catch (IOException e) {
            throw new StorageServiceException("Could not delete file", e);
        }

    }

    @Override
    public void deleteMusicAlbum(UUID uuid) {
        try {
            Files.delete(Paths.get(musicAlbumRepository.findByUuid(uuid).getLocation()));
        } catch (IOException e) {
            throw new StorageServiceException("Could not delete files", e);
        }
    }

    @Override
    public String storeAnime(String username, MultipartFile animeFile) throws Exception {
        return null;
    }

    @Override
    public void deleteAnime(String uuid) {

    }

    @Override
    public String storeMovie(String username, MultipartFile movieFile) throws Exception {
        return null;
    }

    @Override
    public void deleteMovie(String uuid) {

    }

    @Override
    public String storeVideo(String username, MultipartFile videoFile) throws Exception {
        return null;
    }

    @Override
    public void deleteVideo(String uuid) {

    }

    @Override
    public String storePhoto(String username, MultipartFile photoFile) throws Exception {
        return null;
    }

    @Override
    public void deletePhoto(String uuid) {

    }

    @Override
    public String storeBook(String username, MultipartFile bookFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String filename = StringUtils.cleanPath(bookFile.getOriginalFilename());
        Path tempFilePath = cacheService.cacheFile(bookFile);
        Map<String, Object> metadata = metadataService.bookMetadataResolver(tempFilePath);
        try {
            Path realPath = Files.move(tempFilePath, pathService.pathCheck(config.getRootLocation().resolve(username).resolve(config.getBookLocation()).resolve(metadata.get(FileConsts.METADATA_BOOK_AUTHOR).toString()).resolve(filename)), StandardCopyOption.REPLACE_EXISTING);
            return mapper.writeValueAsString(fileRegisteringService.registerBook(metadata, realPath));
        } catch (IOException e) {
            throw new StorageServiceException("Could not move temp file", e);
        }
    }

    @Override
    public void deleteBook(String uuid) {

    }

    @Override
    public String storeDocument(String username, MultipartFile documentFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String filename = StringUtils.cleanPath(documentFile.getOriginalFilename());
        Path tempFilePath = cacheService.cacheFile(documentFile);
        String mimeType = FileUtils.getMimeType(tempFilePath);
        Map<String, Object> metadata = metadataService.documentMetadataResolver(tempFilePath);
        try {
            Path realPath = Files.move(tempFilePath, pathService.pathCheck(config.getRootLocation().resolve(username).resolve(config.getDocumentLocation()).resolve(filename)), StandardCopyOption.REPLACE_EXISTING);
            return mapper.writeValueAsString(fileRegisteringService.registerDocument(metadata, realPath, mimeType));
        } catch (IOException e) {
            throw new StorageServiceException("Could not move temp file", e);
        }
    }

    @Override
    public void deleteDocument(String uuid) {

    }

    @Override
    public String storeIllustration(String username, MultipartFile illustrationFile) {
        return null;
    }

    @Override
    public void deleteIllustration(String uuid) {

    }
}

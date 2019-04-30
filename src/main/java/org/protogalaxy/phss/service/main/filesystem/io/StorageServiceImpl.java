package org.protogalaxy.phss.service.main.filesystem.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.protogalaxy.phss.component.consts.AudioConst;
import org.protogalaxy.phss.component.utilities.FileUtilities;
import org.protogalaxy.phss.component.consts.FileConst;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicAlbumRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicTrackRepository;
import org.protogalaxy.phss.exception.application.filesystem.real.file.FileUtilsException;
import org.protogalaxy.phss.exception.application.filesystem.real.storage.StorageServiceException;
import org.protogalaxy.phss.service.config.StorageServiceConfig;
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

    private PathService pathService;
    private CacheService cacheService;
    private MetadataService metadataService;
    private FileRegisteringService fileRegisteringService;
    private MusicTrackRepository musicTrackRepository;
    private MusicAlbumRepository musicAlbumRepository;


    public StorageServiceImpl() {
    }

    /**
     * Move file to another path
     *
     * @param fromPath Path where file will move from
     * @param toPath   Path where file will move to
     */
    public void moveFile(Path fromPath, Path toPath) throws Exception {
        Files.move(fromPath, toPath);
    }

    /**
     * Store single track
     *
     * @param musicFile uploaded track
     * @return JSON format string of the uploaded track
     */
    public MusicTrackEntity storeTrack(MultipartFile musicFile) throws Exception {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String fileName = StringUtils.cleanPath(musicFile.getOriginalFilename());//Get File name
        Path tempFilePath = cacheService.cacheFile(musicFile);
        Map<String, Object> metadata = metadataService.musicMetadataResolver(tempFilePath);
        //Check whether file already exists
        if (musicTrackRepository.findByFileSystemOwner_AccountEntity_UsernameAndTrackInformationStatic_Md5(SecurityContextHolder.getContext().getAuthentication().getName(), metadata.get(AudioConst.METADATA_AUDIO_MD5).toString()).isPresent()) {
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
                    .resolve(metadata.get(AudioConst.METADATA_AUDIO_ARTIST).toString())
                    .resolve(metadata.get(AudioConst.METADATA_AUDIO_ALBUM).toString())
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
                        .resolve(metadata.get(AudioConst.METADATA_AUDIO_ARTIST).toString())
                        .resolve(metadata.get(AudioConst.METADATA_AUDIO_ALBUM).toString())
                        .resolve(fileName)), StandardCopyOption.REPLACE_EXISTING);
                musicTrackEntities.add(fileRegisteringService.registerTrack(metadata, realPath));
            } catch (IOException e) {
                throw new StorageServiceException("Could not register file", e);
            }
        }
        return musicTrackEntities;
    }

    public void deleteTrack(UUID uuid) {
        try {
            Files.delete(Paths.get(musicTrackRepository.findByUuid(uuid).getLocation()));
        } catch (IOException e) {
            throw new StorageServiceException("Could not delete file", e);
        }

    }

    public void deleteMusicAlbum(UUID uuid) {
        try {
            Files.delete(Paths.get(musicAlbumRepository.findByUuid(uuid).getLocation()));
        } catch (IOException e) {
            throw new StorageServiceException("Could not delete files", e);
        }
    }

    public String storeAnime(String username, MultipartFile animeFile) throws Exception {
        return null;
    }

    public void deleteAnime(String uuid) {

    }

    public String storeMovie(String username, MultipartFile movieFile) throws Exception {
        return null;
    }

    public void deleteMovie(String uuid) {

    }

    public String storeVideo(String username, MultipartFile videoFile) throws Exception {
        return null;
    }

    public void deleteVideo(String uuid) {

    }

    public String storePhoto(String username, MultipartFile photoFile) throws Exception {
        return null;
    }

    public void deletePhoto(String uuid) {

    }

    public String storeBook(String username, MultipartFile bookFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String filename = StringUtils.cleanPath(bookFile.getOriginalFilename());
        Path tempFilePath = cacheService.cacheFile(bookFile);
        Map<String, Object> metadata = metadataService.bookMetadataResolver(tempFilePath);
        try {
            Path realPath = Files.move(tempFilePath, pathService.pathCheck(config.getRootLocation().resolve(username).resolve(config.getBookLocation()).resolve(metadata.get(FileConst.METADATA_BOOK_AUTHOR).toString()).resolve(filename)), StandardCopyOption.REPLACE_EXISTING);
            return mapper.writeValueAsString(fileRegisteringService.registerBook(metadata, realPath));
        } catch (IOException e) {
            throw new StorageServiceException("Could not move temp file", e);
        }
    }

    public void deleteBook(String uuid) {

    }

    public String storeDocument(String username, MultipartFile documentFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String filename = StringUtils.cleanPath(documentFile.getOriginalFilename());
        Path tempFilePath = cacheService.cacheFile(documentFile);
        String mimeType = FileUtilities.getMimeType(tempFilePath);
        Map<String, Object> metadata = metadataService.documentMetadataResolver(tempFilePath);
        try {
            Path realPath = Files.move(tempFilePath, pathService.pathCheck(config.getRootLocation().resolve(username).resolve(config.getDocumentLocation()).resolve(filename)), StandardCopyOption.REPLACE_EXISTING);
            return mapper.writeValueAsString(fileRegisteringService.registerDocument(metadata, realPath, mimeType));
        } catch (IOException e) {
            throw new StorageServiceException("Could not move temp file", e);
        }
    }

    public void deleteDocument(String uuid) {

    }

    public String storeIllustration(String username, MultipartFile illustrationFile) {
        return null;
    }

    public void deleteIllustration(String uuid) {

    }

    @Autowired
    public void setConfig(StorageServiceConfig config) {
        this.config = config;
    }

    @Autowired
    public void setPathService(PathService pathService) {
        this.pathService = pathService;
    }

    @Autowired
    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Autowired
    public void setMetadataService(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    @Autowired
    public void setFileRegisteringService(FileRegisteringService fileRegisteringService) {
        this.fileRegisteringService = fileRegisteringService;
    }

    @Autowired
    public void setMusicTrackRepository(MusicTrackRepository musicTrackRepository) {
        this.musicTrackRepository = musicTrackRepository;
    }

    @Autowired
    public void setMusicAlbumRepository(MusicAlbumRepository musicAlbumRepository) {
        this.musicAlbumRepository = musicAlbumRepository;
    }
}

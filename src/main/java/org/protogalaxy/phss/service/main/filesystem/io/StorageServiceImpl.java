package org.protogalaxy.phss.service.main.filesystem.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.protogalaxy.phss.component.utils.FileUtils;
import org.protogalaxy.phss.component.consts.FileConsts;
import org.protogalaxy.phss.datasource.entity.filesystem.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicAlbumRepository;
import org.protogalaxy.phss.datasource.repository.jpa.filesystem.music.MusicTrackRepository;
import org.protogalaxy.phss.exception.storage.StorageException;
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

@Service
public class StorageServiceImpl implements StorageService {
    private StorageServiceConfig config;

    private final PathService pathService;
    private final CacheService cacheService;
    private final MetadataService metadataService;
    private final FileRegisteringService fileRegisteringService;
    private final MusicAlbumRepository musicAlbumRepository;
    private final MusicTrackRepository musicTrackRepository;


    @Autowired
    public StorageServiceImpl(StorageServiceConfig config,
                              PathServiceImpl pathService,
                              CacheServiceImpl cacheService,
                              MetadataServiceImpl metadataService,
                              FileRegisteringServiceImpl fileRegisteringService,
                              MusicAlbumRepository musicAlbumRepository,
                              MusicTrackRepository musicTrackRepository) {
        this.config = config;
        this.pathService = pathService;
        this.cacheService = cacheService;
        this.metadataService = metadataService;
        this.fileRegisteringService = fileRegisteringService;
        this.musicAlbumRepository = musicAlbumRepository;
        this.musicTrackRepository = musicTrackRepository;
    }

    @Override
    public MusicTrackEntity storeTrack(MultipartFile musicFile) throws Exception {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String fileName = StringUtils.cleanPath(musicFile.getOriginalFilename());//Get File name
        Path tempFilePath = cacheService.cacheFile(username, musicFile);
        Map<String, Object> metadata = metadataService.musicMetadataResolver(tempFilePath);
        try {
            Path realPath = Files.move(tempFilePath, pathCheck(config.getRootLocation().resolve(username).resolve(config.getMusicLocation()).resolve(metadata.get("artist").toString()).resolve(metadata.get("album").toString()).resolve(fileName)), StandardCopyOption.REPLACE_EXISTING);
            return fileRegisteringService.registerTrack(username, metadata, realPath);
        } catch (IOException e) {
            throw new StorageException("Could not move temp file", e);
        }
    }

    @Override
    public List<MusicTrackEntity> storeTracks(MultipartFile[] musicFiles) throws Exception {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<MusicTrackEntity> musicTrackEntities = new ArrayList<>();
        for (MultipartFile musicFile : musicFiles) {
            String fileName = StringUtils.cleanPath(musicFile.getOriginalFilename());
            Path tempFilePath = cacheService.cacheFile(username, musicFile);
            Map<String, Object> metadata = metadataService.musicMetadataResolver(tempFilePath);
            try {
                Path realPath = Files.move(tempFilePath, pathCheck(config.getRootLocation().resolve(username).resolve(config.getMusicLocation()).resolve(metadata.get("artist").toString()).resolve(metadata.get("album").toString()).resolve(fileName)), StandardCopyOption.REPLACE_EXISTING);
                musicTrackEntities.add(fileRegisteringService.registerTrack(username, metadata, realPath));
            } catch (IOException e) {
                throw new StorageException("Could not move temp file", e);
            }
        }
        return musicTrackEntities;
    }

    @Override
    public void deleteTrack(String uuid) {

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
        Path tempFilePath = cacheService.cacheFile(username, bookFile);
        Map<String, Object> metadata = metadataService.bookMetadataResolver(tempFilePath);
        try {
            Path realPath = Files.move(tempFilePath, pathCheck(config.getRootLocation().resolve(username).resolve(config.getBookLocation()).resolve(metadata.get(FileConsts.METADATA_BOOK_AUTHOR).toString()).resolve(filename)), StandardCopyOption.REPLACE_EXISTING);
            return mapper.writeValueAsString(fileRegisteringService.registerBook(username, metadata, realPath));
        } catch (IOException e) {
            throw new StorageException("Could not move temp file", e);
        }
    }

    @Override
    public void deleteBook(String uuid) {

    }

    @Override
    public String storeDocument(String username, MultipartFile documentFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String filename = StringUtils.cleanPath(documentFile.getOriginalFilename());
        Path tempFilePath = cacheService.cacheFile(username, documentFile);
        String mimeType = FileUtils.getMimeType(tempFilePath);
        Map<String, Object> metadata = metadataService.documentMetadataResolver(tempFilePath);
        try {
            Path realPath = Files.move(tempFilePath, pathCheck(config.getRootLocation().resolve(username).resolve(config.getDocumentLocation()).resolve(filename)), StandardCopyOption.REPLACE_EXISTING);
            return mapper.writeValueAsString(fileRegisteringService.registerDocument(username, metadata, realPath, mimeType));
        } catch (IOException e) {
            throw new StorageException("Could not move temp file", e);
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

    private Path pathCheck(Path path) {
        try {
            if (Files.notExists(path)) {
                Files.createDirectories(path);
                return path;
            } else {
                return path;
            }
        } catch (IOException e) {
            throw new StorageException("Path check " + path.toString() + " error", e);
        }
    }
}

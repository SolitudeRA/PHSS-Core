package org.protogalaxy.phss.service.impl.filesystem.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.protogalaxy.phss.component.file.FileCommonUtils;
import org.protogalaxy.phss.component.file.document.DocumentUtils;
import org.protogalaxy.phss.component.file.music.MusicMetadata;
import org.protogalaxy.phss.datasource.entity.filesystem.album.music.MusicTrackEntity;
import org.protogalaxy.phss.exception.storage.StorageException;
import org.protogalaxy.phss.service.config.PhssStorageServiceConfig;
import org.protogalaxy.phss.service.main.filesystem.io.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final Path musicLocation;
    private final Path animeLocation;
    private final Path movieLocation;
    private final Path videoLocation;
    private final Path bookLocation;
    private final Path documentLocation;
    private final Path photoLocation;
    private final Path illustrationLocation;

    private final CachingServiceImpl cachingService;
    private final MusicMetadata musicMetadataService;
    private final FileCommonUtils fileCommonUtils;
    private final DocumentUtils documentUtils;
    private final FileRegisteringServiceImpl fileRegisteringService;


    @Autowired
    public StorageServiceImpl(PhssStorageServiceConfig config,
                              CachingServiceImpl cachingService,
                              MusicMetadata musicMetadata,
                              FileCommonUtils fileCommonUtils,
                              DocumentUtils documentUtils,
                              FileRegisteringServiceImpl fileRegisteringService) {
        this.musicLocation = config.getMusicLocation();
        this.animeLocation = config.getAnimeLocation();
        this.movieLocation = config.getMovieLocation();
        this.videoLocation = config.getVideoLocation();
        this.bookLocation = config.getBookLocation();
        this.documentLocation = config.getDocumentLocation();
        this.photoLocation = config.getPhotoLocation();
        this.illustrationLocation = config.getIllustrationLocation();
        this.fileCommonUtils = fileCommonUtils;
        this.documentUtils = documentUtils;
        this.cachingService = cachingService;
        this.musicMetadataService = musicMetadata;
        this.fileRegisteringService = fileRegisteringService;
    }

    @Override
    public String storeTrack(String username, MultipartFile musicFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String fileName = StringUtils.cleanPath(musicFile.getOriginalFilename());//Get File name
        Path tempFilePath = cachingService.cachingFile(username, musicFile);
        Map<String, Object> metadata = musicMetadataService.readMetaData(tempFilePath);
        byte[] artwork = musicMetadataService.getArtwork(tempFilePath);
        try {
            Path realPath = Files.move(tempFilePath, pathCheck(musicLocation.resolve(metadata.get("artist").toString()).resolve(metadata.get("album").toString()).resolve(fileName)), StandardCopyOption.REPLACE_EXISTING);
            return mapper.writeValueAsString(fileRegisteringService.registerTrack(username, metadata, artwork, realPath));
        } catch (IOException e) {
            throw new StorageException("Could not move temp file", e);
        }
    }

    @Override
    public String storeTracks(String username, MultipartFile[] musicFiles) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<MusicTrackEntity> musicTrackEntities = new ArrayList<>();
        for (MultipartFile musicFile : musicFiles) {
            String fileName = StringUtils.cleanPath(musicFile.getOriginalFilename());
            Path tempFilePath = cachingService.cachingFile(username, musicFile);
            Map<String, Object> metadata = musicMetadataService.readMetaData(tempFilePath);
            byte[] artwork = musicMetadataService.getArtwork(tempFilePath);
            try {
                Path realPath = Files.move(tempFilePath, pathCheck(musicLocation.resolve(metadata.get("artist").toString()).resolve(metadata.get("album").toString()).resolve(fileName)), StandardCopyOption.REPLACE_EXISTING);
                musicTrackEntities.add(fileRegisteringService.registerTrack(username, metadata, artwork, realPath));
            } catch (IOException e) {
                throw new StorageException("Could not move temp file", e);
            }
        }
        return mapper.writeValueAsString(musicTrackEntities);
    }

    @Override
    public String storeAnime(String username, MultipartFile animeFile) {
        return null;
    }

    @Override
    public String storeMovie(String username, MultipartFile movieFile) {
        return null;
    }

    @Override
    public String storeVideo(String username, MultipartFile videoFile) {
        return null;
    }

    @Override
    public String storePhoto(String username, MultipartFile photoFile) {
        return null;
    }

    @Override
    public String storeBook(String username, MultipartFile bookFile) {
        ObjectMapper mapper = new ObjectMapper();
        String filename = StringUtils.cleanPath(bookFile.getOriginalFilename());
        Path tempFilePath = cachingService.cachingFile(username, bookFile);
        String mimeType = fileCommonUtils.getMimeType(tempFilePath);
        return null;
    }

    @Override
    public String storeDocument(String username, MultipartFile documentFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String filename = StringUtils.cleanPath(documentFile.getOriginalFilename());
        Path tempFilePath = cachingService.cachingFile(username, documentFile);
        String mimeType = fileCommonUtils.getMimeType(tempFilePath);
        Map<String, Object> metadata = documentUtils.getDocumentMetadata(tempFilePath, mimeType);
        try {
            Path realPath = Files.move(tempFilePath, pathCheck(documentLocation.resolve(filename)), StandardCopyOption.REPLACE_EXISTING);
            return mapper.writeValueAsString(fileRegisteringService.registerDocument(username, metadata, realPath, mimeType));
        } catch (IOException e) {
            throw new StorageException("Could not move temp file", e);
        }
    }

    @Override
    public String storeIllustration(String username, MultipartFile illustrationFile) {
        return null;
    }

    @Override
    public Path changeLocation(String username, Path currentPath, Path changedPath) {
        return null;
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

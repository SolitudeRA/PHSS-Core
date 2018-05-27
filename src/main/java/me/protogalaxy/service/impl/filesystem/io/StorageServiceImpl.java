package me.protogalaxy.service.impl.filesystem.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.protogalaxy.component.file.music.PhssMusicMetadata;
import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicTrackEntity;
import me.protogalaxy.exception.storage.StorageException;
import me.protogalaxy.service.config.PhssStorageServiceConfig;
import me.protogalaxy.service.main.filesystem.io.StorageService;
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
    private final Path rootLocation;

    private final CachingServiceImpl cachingService;
    private final PhssMusicMetadata musicMetadataService;
    private final FileRegisteringServiceImpl fileRegisteringService;

    @Autowired
    public StorageServiceImpl(PhssStorageServiceConfig config,
                              CachingServiceImpl cachingService,
                              PhssMusicMetadata phssMusicMetadata,
                              FileRegisteringServiceImpl fileRegisteringService) {
        this.rootLocation = Paths.get(config.getLocation());
        this.cachingService = cachingService;
        this.musicMetadataService = phssMusicMetadata;
        this.fileRegisteringService = fileRegisteringService;
    }

    @Override
    public String storeTrack(String username, MultipartFile musicFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String fileName = StringUtils.cleanPath(musicFile.getOriginalFilename());//Get File name
        Path root = pathCheck(rootLocation);//Storage root check
        Path userRoot = pathCheck(root.resolve(username));//User root check
        Path tempFilePath = cachingService.cachingFile(username, musicFile);
        Map<String, Object> metadata = musicMetadataService.getMetaData(tempFilePath);
        byte[] artwork = musicMetadataService.getArtwork(tempFilePath);
        Path userRootArtist = pathCheck(userRoot.resolve(metadata.get("artist").toString()));//Artist root check
        Path userRootArtistAlbum = pathCheck(userRootArtist.resolve(metadata.get("album").toString()));//Album root check
        try {
            Path realPath = Files.move(tempFilePath, userRootArtistAlbum.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            return mapper.writeValueAsString(fileRegisteringService.registerMusic(username, metadata, artwork, realPath));
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
            Path root = pathCheck(rootLocation);
            Path userRoot = pathCheck(root.resolve(username));
            Path tempFilePath = cachingService.cachingFile(username, musicFile);
            Map<String, Object> metadata = musicMetadataService.getMetaData(tempFilePath);
            byte[] artwork = musicMetadataService.getArtwork(tempFilePath);
            Path userRootArtist = pathCheck(userRoot.resolve(metadata.get("artist").toString()));
            Path userRootArtistAlbum = pathCheck(userRootArtist.resolve(metadata.get("album").toString()));
            try {
                Path realPath = Files.move(tempFilePath, userRootArtistAlbum.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
                musicTrackEntities.add(fileRegisteringService.registerMusic(username, metadata, artwork, realPath));
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
        return null;
    }

    @Override
    public String storeDocument(String username, MultipartFile documentFile) {
        return null;
    }

    @Override
    public String storeIllustration(String username, MultipartFile illustrationFile) {
        return null;
    }

    private Path pathCheck(Path path) {
        try {
            if (Files.notExists(path)) {
                Files.createDirectory(path);
                return path;
            } else {
                return path;
            }
        } catch (IOException e) {
            throw new StorageException("Path check " + path.toString() + " error", e);
        }
    }
}

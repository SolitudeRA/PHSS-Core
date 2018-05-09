package me.protogalaxy.service.impl.filesystem.io;

import me.protogalaxy.component.file.music.PhssMusicMetadata;
import me.protogalaxy.exception.storage.StorageException;
import me.protogalaxy.service.config.PhssStorageServiceConfig;
import me.protogalaxy.service.main.filesystem.io.FileRegisteringService;
import me.protogalaxy.service.main.filesystem.io.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

@Service
public class StorageServiceImpl implements StorageService {
    private final Path rootLocation;

    private final CachingServiceImpl cachingService;
    private final PhssMusicMetadata musicMetadataService;
    private final FileRegisteringService fileRegisteringService;

    //TODO:Create directory
    @Autowired
    public StorageServiceImpl(PhssStorageServiceConfig config,
                              CachingServiceImpl cachingService,
                              PhssMusicMetadata phssMusicMetadata,
                              FileRegisteringService fileRegisteringService) {
        this.rootLocation = Paths.get(config.getLocation());
        this.cachingService = cachingService;
        this.musicMetadataService = phssMusicMetadata;
        this.fileRegisteringService = fileRegisteringService;
    }

    public void init() {
        try {
            if (Files.notExists(rootLocation)) {
                Files.createDirectory(rootLocation);
            }
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public void storeMusic(String username, MultipartFile musicFile) throws Exception{
        String fileName = StringUtils.cleanPath(musicFile.getOriginalFilename());
        Path tempFilePath = cachingService.cachingFile(username, musicFile);
        Map<String, Object> metadata = musicMetadataService.getMetaData(tempFilePath);
        Path path = pathCheck(Paths.get(username)
                .resolve(metadata.get("artist").toString())
                .resolve(metadata.get("album").toString()));
        try {
            Path realPath = Files.move(tempFilePath, path.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            //fileRegisteringService.registerMusic(username, metadata, realPath);
        } catch (IOException e) {
            throw new StorageException("Could not move temp file", e);
        }
    }

    @Override
    public void storeAnime(String username, MultipartFile animeFile) {

    }

    @Override
    public void storeMovie(String username, MultipartFile movieFile) {

    }

    @Override
    public void storeVideo(String username, MultipartFile videoFile) {

    }

    @Override
    public void storePhoto(String username, MultipartFile photoFile) {

    }

    @Override
    public void storeBook(String username, MultipartFile bookFile) {

    }

    @Override
    public void storeDocument(String username, MultipartFile documentFile) {

    }

    @Override
    public void storeIllustration(String username, MultipartFile illustrationFile) {

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
            throw new StorageException("Path check error", e);
        }
    }
}

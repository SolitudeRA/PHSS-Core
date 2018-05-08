package me.protogalaxy.service.impl.filesystem;

import me.protogalaxy.exception.storage.StorageException;
import me.protogalaxy.exception.storage.StorageFileNotFoundException;
import me.protogalaxy.service.config.PhssStorageServiceConfig;
import me.protogalaxy.service.main.filesystem.PhssStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class PhssStorageServiceImpl implements PhssStorageService {
    private final Path rootLocation;

    private final CachingServiceImpl cachingService;

    @Autowired
    public PhssStorageServiceImpl(PhssStorageServiceConfig config, CachingServiceImpl cachingService) {
        this.rootLocation = Paths.get(config.getLocation());
        this.cachingService = cachingService;
        init();
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
    public void storeMusic(String username, MultipartFile musicFile) {
        Path tempFilePath = cachingService.cachingFile(username, musicFile);

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

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}

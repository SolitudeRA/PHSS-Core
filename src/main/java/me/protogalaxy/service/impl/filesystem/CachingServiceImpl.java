package me.protogalaxy.service.impl.filesystem;

import me.protogalaxy.exception.storage.StorageTempException;
import me.protogalaxy.service.config.PhssStorageServiceConfig;
import me.protogalaxy.service.main.filesystem.CachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class CachingServiceImpl implements CachingService {
    private final String phssTempPrefix;
    private final Path tempLocation;

    @Autowired
    public CachingServiceImpl(PhssStorageServiceConfig config) {
        this.phssTempPrefix = config.getPrefix();
        this.tempLocation = Paths.get(config.getTempLocation());
    }

    @Override
    public Path cachingFile(String username, MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Path tempDirectory = getUserTempDirectoryPath(username);
            return Files.write(tempDirectory.resolve(filename), file.getBytes());
        } catch (IOException e) {
            throw new StorageTempException("Fail to create temp file", e);
        }
    }

    private Path getUserTempDirectoryPath(String username) {
        try {
            return Files.createTempDirectory(tempLocation.resolve(Paths.get(username)), phssTempPrefix);
        } catch (IOException e) {
            throw new StorageTempException("Fail to create temp directory", e);
        }
    }
}

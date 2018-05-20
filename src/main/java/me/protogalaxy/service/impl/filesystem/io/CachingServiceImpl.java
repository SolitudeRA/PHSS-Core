package me.protogalaxy.service.impl.filesystem.io;

import me.protogalaxy.exception.storage.StorageException;
import me.protogalaxy.exception.storage.StorageTempException;
import me.protogalaxy.service.config.PhssStorageServiceConfig;
import me.protogalaxy.service.main.filesystem.io.CachingService;
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

    /**
     * Caching file
     *
     * @param username name of the user
     * @param file     uploaded MultipartFile
     * @return Path of the temp file
     */
    @Override
    public Path cachingFile(String username, MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            tempPathCheck(tempLocation);
            Path tempDirectory = getUserTempDirectoryPath(username);
            return Files.write(tempDirectory.resolve(filename), file.getBytes());
        } catch (IOException e) {
            throw new StorageTempException("Fail to create temp file", e);
        }
    }

    /**
     * Create temp directory
     *
     * @param username name of the user
     * @return Path of the temp directory
     */
    private Path getUserTempDirectoryPath(String username) {
        try {
            tempPathCheck(tempLocation.resolve(Paths.get(username)));
            return Files.createTempDirectory(tempLocation.resolve(Paths.get(username)), phssTempPrefix);
        } catch (IOException e) {
            throw new StorageTempException("Fail to create temp directory", e);
        }
    }

    private void tempPathCheck(Path path) {
        try {
            if (Files.notExists(path)) {
                Files.createDirectory(path);
            }
        } catch (IOException e) {
            throw new StorageException("Temp path check " + path.toString() + " error", e);
        }
    }
}

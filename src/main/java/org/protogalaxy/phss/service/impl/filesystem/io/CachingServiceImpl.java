package org.protogalaxy.phss.service.impl.filesystem.io;

import org.protogalaxy.phss.exception.storage.StorageException;
import org.protogalaxy.phss.exception.storage.StorageTempException;
import org.protogalaxy.phss.service.config.PhssStorageServiceConfig;
import org.protogalaxy.phss.service.main.filesystem.io.CachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class CachingServiceImpl implements CachingService {
    private final String phssTempPrefix;
    private final Path tempLocation;
    private final Path imagePoolLocation;

    @Autowired
    public CachingServiceImpl(PhssStorageServiceConfig config) {
        this.phssTempPrefix = config.getPrefix();
        this.tempLocation = config.getTempLocation();
        this.imagePoolLocation = config.getImagePoolLocation();
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
            Path tempDirectory = getUserTempDirectoryPath(username);
            return Files.write(tempDirectory.resolve(filename), file.getBytes());
        } catch (IOException e) {
            throw new StorageTempException("Fail to create temp file", e);
        }
    }

    /**
     * Caching image from memory
     *
     * @param username      current user name
     * @param uuid          uuid of the object
     * @param bufferedImage buffered image
     * @return Path of the cached image
     */
    @Override
    public Path cachingImage(String username, UUID uuid, BufferedImage bufferedImage) {
        String imageName = uuid.toString();
        //TODO: caching service
        return null;
    }

    /**
     * Create temp directory
     *
     * @param username name of the user
     * @return Path of the temp directory
     */
    private Path getUserTempDirectoryPath(String username) {
        try {
            return Files.createTempDirectory(tempPathCheck(tempLocation.resolve(Paths.get(username))), phssTempPrefix);
        } catch (IOException e) {
            throw new StorageTempException("Fail to create temp directory", e);
        }
    }

    private Path tempPathCheck(Path path) {
        try {
            if (Files.notExists(path)) {
                Files.createDirectories(path);
            } else {
                return path;
            }
        } catch (IOException e) {
            throw new StorageException("Temp path check " + path.toString() + " error", e);
        }
    }
}

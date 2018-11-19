package org.protogalaxy.phss.service.main.filesystem.io;

import org.protogalaxy.phss.exception.storage.StorageException;
import org.protogalaxy.phss.exception.storage.StorageTempException;
import org.protogalaxy.phss.service.config.StorageServiceConfig;
import org.protogalaxy.phss.service.interfaces.filesystem.io.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class CacheServiceImpl implements CacheService {
    private final String phssTempPrefix;
    private final Path tempLocation;
    private final Path imagePoolLocation;

    @Autowired
    public CacheServiceImpl(StorageServiceConfig config) {
        this.phssTempPrefix = config.getPrefix();
        this.tempLocation = config.getTempLocation();
        this.imagePoolLocation = config.getImagePoolLocation();
    }

    /**
     * Caching file
     *
     * @param username name of the account
     * @param file     uploaded MultipartFile
     * @return Path of the temp file
     */
    @Override
    public Path cacheFile(String username, MultipartFile file) {
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
     * @param username      current account name
     * @param bufferedImage buffered image
     * @return Path of the cached image
     */
    @Override
    public Path cacheImage(String username, BufferedImage bufferedImage) {
        String imageName = UUID.randomUUID().toString();
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", outputStream);
            return Files.write(tempPathCheck(imagePoolLocation.resolve(username).resolve(imageName)), outputStream.toByteArray());
        } catch (IOException e) {
            throw new StorageTempException("Failed to cache image", e);
        }
    }

    /**
     * Create temp directory
     *
     * @param username name of the account
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
                return Files.createDirectories(path);
            } else {
                return path;
            }
        } catch (IOException e) {
            throw new StorageException("Temp path check " + path.toString() + " error", e);
        }
    }
}

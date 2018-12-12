package org.protogalaxy.phss.service.main.filesystem.io;

import org.protogalaxy.phss.exception.storage.StorageServiceException;
import org.protogalaxy.phss.service.config.StorageServiceConfig;
import org.protogalaxy.phss.service.interfaces.filesystem.io.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class CacheServiceImpl implements CacheService {
    private final StorageServiceConfig storageServiceConfig;

    @Autowired
    public CacheServiceImpl(StorageServiceConfig storageServiceConfig) {
        this.storageServiceConfig = storageServiceConfig;
    }

    /**
     * Caching file
     *
     * @param file uploaded MultipartFile
     * @return Path of the temp file
     */
    @Override
    public Path cacheFile(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Path tempDirectory = getUserTempDirectoryPath();
            return Files.write(tempDirectory.resolve(filename), file.getBytes());
        } catch (IOException e) {
            throw new StorageTempServiceException("Fail to create temp file", e);
        }
    }

    /**
     * Caching image from memory
     *
     * @param bufferedImage buffered image
     * @return Path of the cached image
     */
    @Override
    public Path cacheImage(BufferedImage bufferedImage) {
        String imageName = UUID.randomUUID().toString() + ".png";
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            ImageIO.write(bufferedImage, "png", outputStream);
            return Files.write(tempPathCheck(storageServiceConfig.getRootLocation()
                                                                 .resolve(SecurityContextHolder.getContext().getAuthentication().getName())
                                                                 .resolve(storageServiceConfig.getImagePoolLocation()))
                                       .resolve(imageName), outputStream.toByteArray());
        } catch (IOException e) {
            throw new StorageTempServiceException("Failed to cache image", e);
        }
    }

    /**
     * Create temp directory
     *
     * @return Path of the temp directory
     */
    private Path getUserTempDirectoryPath() {
        try {
            return Files.createTempDirectory(tempPathCheck(storageServiceConfig.getTempLocation().resolve(SecurityContextHolder.getContext().getAuthentication().getName())), storageServiceConfig.getPrefix());
        } catch (IOException e) {
            throw new StorageTempServiceException("Fail to create temp directory", e);
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
            throw new StorageServiceException("Temp path check " + path.toString() + " error", e);
        }
    }
}

package org.protogalaxy.phss.service.main.filesystem.io;

import org.springframework.web.multipart.MultipartFile;


import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.util.UUID;

public interface CacheService {
    /**
     * Caching file from MultipartFile
     *
     * @param username current user name
     * @param file     uploaded MultipartFile
     * @return Path of the cached file
     */
    Path cachingFile(String username, MultipartFile file);

    /**
     * Caching image from memory
     *
     * @param username      current user name
     * @param uuid          uuid of the object
     * @param bufferedImage buffered image
     * @return Path of the cached image
     */
    Path cachingImage(String username, UUID uuid, BufferedImage bufferedImage);
}

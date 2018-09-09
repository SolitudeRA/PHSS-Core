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
    Path cacheFile(String username, MultipartFile file);

    /**
     * Caching image from memory
     *
     * @param username      current user name
     * @param bufferedImage buffered image
     * @return Path of the cached image
     */
    Path cacheImage(String username, BufferedImage bufferedImage);
}

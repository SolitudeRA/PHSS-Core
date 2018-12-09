package org.protogalaxy.phss.service.interfaces.filesystem.io;

import org.springframework.web.multipart.MultipartFile;


import java.awt.image.BufferedImage;
import java.nio.file.Path;

public interface CacheService {
    /**
     * Caching file from MultipartFile
     *
     * @param file uploaded MultipartFile
     * @return Path of the cached file
     */
    Path cacheFile(MultipartFile file);

    /**
     * Caching image from memory
     *
     * @param bufferedImage buffered image
     * @return Path of the cached image
     */
    Path cacheImage(BufferedImage bufferedImage);
}

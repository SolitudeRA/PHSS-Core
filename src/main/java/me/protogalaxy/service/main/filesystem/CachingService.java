package me.protogalaxy.service.main.filesystem;

import org.springframework.web.multipart.MultipartFile;


import java.nio.file.Path;

public interface CachingService {
    /**
     * Caching file from MultipartFile
     *
     * @param file uploaded MultipartFile
     * @return Path of the cached file
     */
    Path cachingFile(String username, MultipartFile file);
}

package me.protogalaxy.service.main.filesystem.io;

import java.nio.file.Path;
import java.util.Map;

public interface FileRegisteringService {
    /**
     * Register music in database
     *
     * @param metadata metadata of the music
     * @param path     path of the file
     */
    void registerMusic(String username, Map<String, Object> metadata, Path path) throws Exception;
}

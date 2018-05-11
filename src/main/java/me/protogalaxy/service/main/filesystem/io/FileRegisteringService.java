package me.protogalaxy.service.main.filesystem.io;

import me.protogalaxy.datasource.entity.core.filesystem.album.music.MusicTrackEntity;

import java.nio.file.Path;
import java.util.Map;

public interface FileRegisteringService {
    /**
     * Register music in database
     *
     * @param metadata metadata of the music
     * @param path     path of the file
     */
    MusicTrackEntity registerMusic(String username, Map<String, Object> metadata, Path path) throws Exception;
}

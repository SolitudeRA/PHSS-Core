package org.protogalaxy.phss.service.main.filesystem.io;

import org.protogalaxy.phss.datasource.entity.core.filesystem.album.music.MusicTrackEntity;
import org.protogalaxy.phss.datasource.entity.core.filesystem.document.DocumentEntity;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Map;

@Service
public interface FileRegisteringService {
    /**
     * Register music in database
     *
     * @param username name of the user
     * @param metadata metadata of the music
     * @param path     path of the file
     */
    MusicTrackEntity registerMusic(String username, Map<String, Object> metadata, byte[] artwork, Path path) throws Exception;

    /**
     * Register document in database
     *
     * @param username name of the user
     * @param title    title of the document
     * @param type     type of the document
     * @param path     path of the file
     */
    DocumentEntity registerDocument(String username, String title, String type, Path path) throws Exception;
}

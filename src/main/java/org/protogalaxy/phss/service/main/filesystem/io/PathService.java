package org.protogalaxy.phss.service.main.filesystem.io;

import java.nio.file.Path;
import java.util.Map;

public interface PathService {
    /**
     * Persist file in correct path
     *
     * @param username Name of current user
     * @param mimeType MIME type of the file
     * @param tempPath Temporary path of the file
     * @param metadata Metadata of the file
     * @return Persisted path of the file
     */
    Path persistFile(String username, String mimeType, Path tempPath, Map<String, Object> metadata);

    /**
     * Switch path with MIME type
     *
     * @param username name of the user
     * @param mimeType MIME type of the file
     * @return Correct path for current MIME type
     */
    Path mimePathSwitcher(String username, String mimeType);
}

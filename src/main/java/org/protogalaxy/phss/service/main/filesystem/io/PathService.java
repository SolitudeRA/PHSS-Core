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
     * Switch path with filesystem part
     *
     * @param username       Name of the user
     * @param fileSystemPart Part of the filesystem
     * @return Correct path for the part
     */
    Path basePathSwitcher(String username, String fileSystemPart);

    /**
     * Switch path with MIME type
     *
     * @param username Name of the user
     * @param mimeType MIME type of the file
     * @param type     (Optional) more string parameters
     * @return Correct path for current MIME type
     */
    Path mimeBasePathSwitcher(String username, String mimeType, String... type);
}

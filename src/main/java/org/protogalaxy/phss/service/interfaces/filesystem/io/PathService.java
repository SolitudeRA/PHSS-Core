package org.protogalaxy.phss.service.interfaces.filesystem.io;

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
     * Switch path with metadata information
     *
     * @param username       Name of the user
     * @param tempPath       Temporary path of the file
     * @param fileSystemPart File system part
     * @return Correct path for current MIME type
     */
    Path metadataPathSwitcher(String username, Path tempPath, String fileSystemPart);

    /**
     * Change file location
     *
     * @param username    name of current user
     * @param currentPath current file path
     * @param changedPath path that file to move
     * @return changed file path
     */
    Path changeLocation(String username, Path currentPath, Path changedPath);
}

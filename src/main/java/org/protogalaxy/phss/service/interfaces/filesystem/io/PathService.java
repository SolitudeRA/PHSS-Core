package org.protogalaxy.phss.service.interfaces.filesystem.io;

import java.nio.file.Path;
import java.util.Map;

public interface PathService {
    /**
     * Persist file in correct path
     *
     * @param mimeType MIME type of the file
     * @param tempPath Temporary path of the file
     * @param metadata Metadata of the file
     * @return Persisted path of the file
     */
    Path persistFile(String mimeType, Path tempPath, Map<String, Object> metadata);

    /**
     * Switch path with filesystem part
     *
     * @param fileSystemPart Part of the filesystem
     * @return Correct path for the part
     */
    Path basePathSwitcher(String fileSystemPart);

    /**
     * Switch path with metadata information
     *
     * @param tempPath       Temporary path of the file
     * @param fileSystemPart File system part
     * @return Correct path for current MIME type
     */
    Path metadataPathSwitcher(Path tempPath, String fileSystemPart);

    /**
     * Change file location
     *
     * @param currentPath current file path
     * @param changedPath path that file to move
     * @return changed file path
     */
    Path changeLocation(Path currentPath, Path changedPath);
}

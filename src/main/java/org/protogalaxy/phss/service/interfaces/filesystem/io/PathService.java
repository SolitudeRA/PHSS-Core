package org.protogalaxy.phss.service.interfaces.filesystem.io;

import java.nio.file.Path;
import java.util.Map;

public interface PathService {
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
     * Check path
     *
     * @param path path to check
     * @return checked path
     */
    Path pathCheck(Path path);

    /**
     * Get a temp directory
     *
     * @return Path of the temp directory
     */
    Path getTempDirectory();
}

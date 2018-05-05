package me.protogalaxy.service.main.filesystem;

import java.nio.ByteBuffer;
import java.nio.file.Path;

public interface CachingService {
    /**
     * Caching file from buffer
     *
     * @param buffer NIO Buffer of the file
     * @return Path of the cached file
     */
    Path cachingFileFromBuffer(ByteBuffer buffer);
}

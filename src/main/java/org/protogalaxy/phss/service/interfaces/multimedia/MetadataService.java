package org.protogalaxy.phss.service.interfaces.multimedia;

import java.nio.file.Path;
import java.util.Map;

public interface MetadataService {
    /**
     * Resolve music file metadata
     *
     * @param path Path of the file
     * @return Music metadata map of the file
     */
    Map<String, Object> musicMetadataResolver(Path path) throws Exception;

    /**
     * Resolve video file metadata
     *
     * @param path Path of the file
     * @return Video metadata map of the file
     */
    Map<String, Object> videoMetadataResolver(Path path) throws Exception;

    /**
     * Resolve photo file metadata
     *
     * @param path Path of the file
     * @return Photo metadata map of the file
     */
    Map<String, Object> photoMetadataResolver(Path path) throws Exception;

    /**
     * Resolve illustration file metadata
     *
     * @param path Path of the file
     * @return Illustration metadata map of the file
     */
    Map<String, Object> illustrationMetadataResolver(Path path) throws Exception;

    /**
     * Resolve document file metadata
     *
     * @param path Path of the file
     * @return Document metadata map of the file
     */
    Map<String, Object> documentMetadataResolver(Path path) throws Exception;

    /**
     * Resolve book file metadata
     *
     * @param path Path of the file
     * @return Book metadata map of the file
     */
    Map<String, Object> bookMetadataResolver(Path path) throws Exception;
}

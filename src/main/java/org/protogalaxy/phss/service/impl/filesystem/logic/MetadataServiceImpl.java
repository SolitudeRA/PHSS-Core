package org.protogalaxy.phss.service.impl.filesystem.logic;

import org.protogalaxy.phss.service.main.filesystem.logic.MetadataService;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Map;

@Service
public class MetadataServiceImpl implements MetadataService {
    /**
     * Resolve music file metadata
     *
     * @param path Path of the file
     * @return Music metadata map of the file
     */
    @Override
    public Map<String, Object> musicMetadataResolver(Path path) {
        return null;
    }

    /**
     * Resolve video file metadata
     *
     * @param path Path of the file
     * @return Video metadata map of the file
     */
    @Override
    public Map<String, Object> videoMetadataResolver(Path path) {
        return null;
    }

    /**
     * Resolve photo file metadata
     *
     * @param path Path of the file
     * @return Photo metadata map of the file
     */
    @Override
    public Map<String, Object> photoMetadataResolver(Path path) {
        return null;
    }

    /**
     * Resolve illustration file metadata
     *
     * @param path Path of the file
     * @return Illustration metadata map of the file
     */
    @Override
    public Map<String, Object> illustrationMetadataResolver(Path path) {
        return null;
    }

    /**
     * Resolve document file metadata
     *
     * @param path Path of the file
     * @return Document metadata map of the file
     */
    @Override
    public Map<String, Object> documentMetadataResolver(Path path) {
        return null;
    }

    /**
     * Resolve book file metadata
     *
     * @param path Path of the file
     * @return Book metadata map of the file
     */
    @Override
    public Map<String, Object> bookMetadataResolver(Path path) {
        return null;
    }
}

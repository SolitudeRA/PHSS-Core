package org.protogalaxy.phss.service.impl.filesystem.io;

import org.protogalaxy.phss.component.file.FileConsts;
import org.protogalaxy.phss.exception.storage.StorageException;
import org.protogalaxy.phss.service.config.PhssStorageServiceConfig;
import org.protogalaxy.phss.service.main.filesystem.io.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Map;

@Service
public class PathServiceImpl implements PathService {
    private PhssStorageServiceConfig storageServiceConfig;

    @Autowired
    public PathServiceImpl(PhssStorageServiceConfig storageServiceConfig) {
        this.storageServiceConfig = storageServiceConfig;
    }

    /**
     * Persist file in correct path
     *
     * @param username Name of current user
     * @param mimeType MIME type of the file
     * @param tempPath Temporary path of the file
     * @param metadata Metadata of the file
     * @return Persisted path of the file
     */
    @Override
    public Path persistFile(String username, String mimeType, Path tempPath, Map<String, Object> metadata) {
        return null;
    }

    /**
     * Switch path with MIME type
     *
     * @param username name of the user
     * @param mimeType MIME type of the file
     * @return Correct path for current MIME type
     */
    @Override
    public Path mimePathSwitcher(String username, String mimeType) {
        switch (mimeType) {
            case FileConsts.MIME_ADOBE_PDF:
            case FileConsts.MIME_ADOBE_PHOTOSHOP:
            case FileConsts.MIME_MICROSOFT_WORD:
            case FileConsts.MIME_MICROSOFT_EXCEL:
            case FileConsts.MIME_MICROSOFT_POWERPOINT:
            case FileConsts.MIME_MICROSOFT_WORD_OLD:
            case FileConsts.MIME_MICROSOFT_EXCEL_OLD:
            case FileConsts.MIME_MICROSOFT_POWERPOINT_OLD:
            case FileConsts.MIME_OPENDOCUMENT_TEXT:
            case FileConsts.MIME_OPENDOCUMENT_SPREADSHEET:
            case FileConsts.MIME_OPENDOCUMENT_PRESENTATION:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getDocumentLocation());
            default:
                throw new StorageException("Unsupported MIME type");
        }
    }
}

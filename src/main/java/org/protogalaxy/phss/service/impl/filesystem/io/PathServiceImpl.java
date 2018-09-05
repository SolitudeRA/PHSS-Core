package org.protogalaxy.phss.service.impl.filesystem.io;

import org.protogalaxy.phss.component.file.FileConsts;
import org.protogalaxy.phss.exception.path.PathException;
import org.protogalaxy.phss.exception.storage.StorageException;
import org.protogalaxy.phss.service.config.PhssStorageServiceConfig;
import org.protogalaxy.phss.service.main.filesystem.io.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Map;
import java.util.regex.Pattern;

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
     * Switch path with filesystem part
     *
     * @param username       Name of the user
     * @param fileSystemPart Part of the filesystem
     * @return Correct path for the part
     */
    @Override
    public Path basePathSwitcher(String username, String fileSystemPart) {
        switch (fileSystemPart) {
            case FileConsts.FILESYSTEM_MUSIC:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getMusicLocation());
            case FileConsts.FILESYSTEM_ANIME:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getAnimeLocation());
            case FileConsts.FILESYSTEM_MOVIE:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getMovieLocation());
            case FileConsts.FILESYSTEM_VIDEO:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getVideoLocation());
            case FileConsts.FILESYSTEM_PHOTO:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getPhotoLocation());
            case FileConsts.FILESYSTEM_ILLUSTRATION:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getIllustrationLocation());
            case FileConsts.FILESYSTEM_DOCUMENT:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getDocumentLocation());
            case FileConsts.FILESYSTEM_BOOK:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getBookLocation());
            default:
                throw new PathException("Invalid filesystem part");
        }
    }

    /**
     * Switch base path with MIME type
     *
     * @param username Name of the user
     * @param mimeType MIME type of the file
     * @param type     (Optional) more string parameters
     * @return Correct path for current MIME type
     */
    @Override
    public Path mimeBasePathSwitcher(String username, String mimeType, String... type) {
        if (type.length > 1) {
            throw new PathException("Only support one external parameter");
        }
        if (Pattern.matches("^audio/.*", mimeType)) {
            return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getMusicLocation());
        }
        if (Pattern.matches("^video/.*", mimeType)) {
            if (type[0] != null) {
                switch (type[0]) {
                    case FileConsts.FILESYSTEM_ANIME:
                        return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getAnimeLocation());
                    case FileConsts.FILESYSTEM_MOVIE:
                        return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getMovieLocation());
                    case FileConsts.FILESYSTEM_VIDEO:
                        return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getVideoLocation());
                }
            } else {
                throw new PathException("Need more parameters to switch path");
            }
        }
        if (Pattern.matches("^image/.*", mimeType)) {
            if (type[0] != null) {
                switch (type[0]) {
                    case FileConsts.FILESYSTEM_PHOTO:
                        return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getPhotoLocation());
                    case FileConsts.FILESYSTEM_ILLUSTRATION:
                        return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getIllustrationLocation());
                }
            } else {
                throw new PathException("Need more parameters to switch path");
            }
        }
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
            case FileConsts.MIME_MARKDOWN:
            case FileConsts.MIME_LATEX:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getDocumentLocation());
            case FileConsts.MIME_EBOOK_EPUB:
            case FileConsts.MIME_EBOOK_IBOOKS:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getBookLocation());
            default:
                throw new StorageException("Unsupported MIME type");
        }
    }
}

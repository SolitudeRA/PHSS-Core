package org.protogalaxy.phss.service.main.filesystem.io;

import org.protogalaxy.phss.component.file.FileCommonUtils;
import org.protogalaxy.phss.component.file.FileConsts;
import org.protogalaxy.phss.exception.path.PathException;
import org.protogalaxy.phss.exception.storage.StorageException;
import org.protogalaxy.phss.service.config.StorageServiceConfig;
import org.protogalaxy.phss.service.main.filesystem.multimedia.MetadataServiceImpl;
import org.protogalaxy.phss.service.interfaces.filesystem.io.PathService;
import org.protogalaxy.phss.service.interfaces.filesystem.multimedia.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class PathServiceImpl implements PathService {
    private StorageServiceConfig storageServiceConfig;
    private MetadataService metadataService;

    @Autowired
    public PathServiceImpl(StorageServiceConfig storageServiceConfig,
                           MetadataServiceImpl metadataService) {
        this.storageServiceConfig = storageServiceConfig;
        this.metadataService = metadataService;
    }

    /**
     * Persist file in correct path
     *
     * @param username Name of current account
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
     * @param username       Name of the account
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
     * Switch path with metadata information
     *
     * @param username       Name of the account
     * @param tempPath       Temporary path of the file
     * @param fileSystemPart File system part
     * @return Correct path for current MIME type
     */
    @Override
    public Path metadataPathSwitcher(String username, Path tempPath, String fileSystemPart) {
        String mimeType = FileCommonUtils.getMimeType(tempPath);
        switch (fileSystemPart) {
            case FileConsts.FILESYSTEM_MUSIC:
                if (Pattern.matches("^audio/.*", mimeType)) {
                    return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getMusicLocation());
                } else {
                    throw new PathException("Incorrect or unsupported mime type");
                }
            case FileConsts.FILESYSTEM_ANIME:
                if (Pattern.matches("^video/.*", mimeType)) {
                    return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getAnimeLocation());
                } else {
                    throw new PathException("Incorrect or unsupported mime type");
                }
            case FileConsts.FILESYSTEM_MOVIE:
                if (Pattern.matches("^video/.*", mimeType)) {
                    return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getMovieLocation());
                } else {
                    throw new PathException("Incorrect or unsupported mime type");
                }
            case FileConsts.FILESYSTEM_VIDEO:
                if (Pattern.matches("^video/.*", mimeType)) {
                    return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getVideoLocation());
                } else {
                    throw new PathException("Incorrect or unsupported mime type");
                }
            case FileConsts.FILESYSTEM_PHOTO:
                if (Pattern.matches("^image/.*", mimeType)) {
                    return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getPhotoLocation());
                } else {
                    throw new PathException("Incorrect or unsupported mime type");
                }
            case FileConsts.FILESYSTEM_ILLUSTRATION:
                if (Pattern.matches("^image/.*", mimeType)) {
                    return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getIllustrationLocation());
                } else {
                    throw new PathException("Incorrect or unsupported mime type");
                }
            case FileConsts.FILESYSTEM_DOCUMENT:
            case FileConsts.FILESYSTEM_BOOK:
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
                        throw new StorageException("Unsupported document MIME type");
                }
            default:
                throw new PathException("Invalid filesystem part");
        }
    }

    /**
     * Change file location
     *
     * @param username    name of current account
     * @param currentPath current file path
     * @param changedPath path that file to move
     * @return changed file path
     */
    @Override
    public Path changeLocation(String username, Path currentPath, Path changedPath) {
        return null;
    }
}

package org.protogalaxy.phss.service.main.filesystem.io;

import org.protogalaxy.phss.component.utilities.FileUtilities;
import org.protogalaxy.phss.component.consts.FileConst;
import org.protogalaxy.phss.exception.application.filesystem.real.path.PathServiceException;
import org.protogalaxy.phss.exception.application.filesystem.real.storage.StorageServiceException;
import org.protogalaxy.phss.service.config.StorageServiceConfig;
import org.protogalaxy.phss.service.interfaces.filesystem.io.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

@Service
public class PathServiceImpl implements PathService {
    private StorageServiceConfig storageServiceConfig;

    public PathServiceImpl() {
    }

    /**
     * Switch path with filesystem part
     *
     * @param fileSystemPart Part of the filesystem
     * @return Correct path for the part
     */
    @Override
    public Path basePathSwitcher(String fileSystemPart) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        switch (fileSystemPart) {
            case FileConst.FILESYSTEM_MUSIC:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getMusicLocation());
            case FileConst.FILESYSTEM_ANIME:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getAnimeLocation());
            case FileConst.FILESYSTEM_MOVIE:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getMovieLocation());
            case FileConst.FILESYSTEM_VIDEO:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getVideoLocation());
            case FileConst.FILESYSTEM_PHOTO:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getPhotoLocation());
            case FileConst.FILESYSTEM_ILLUSTRATION:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getIllustrationLocation());
            case FileConst.FILESYSTEM_DOCUMENT:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getDocumentLocation());
            case FileConst.FILESYSTEM_BOOK:
                return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getBookLocation());
            default:
                throw new PathServiceException("Invalid filesystem part");
        }
    }

    /**
     * Switch path with metadata information
     *
     * @param tempPath       Temporary path of the file
     * @param fileSystemPart File system part
     * @return Correct path for current MIME type
     */
    @Override
    public Path metadataPathSwitcher(Path tempPath, String fileSystemPart) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String mimeType = FileUtilities.getMimeType(tempPath);
        switch (fileSystemPart) {
            case FileConst.FILESYSTEM_MUSIC:
                if (Pattern.matches("^audio/.*", mimeType)) {
                    return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getMusicLocation());
                } else {
                    throw new PathServiceException("Incorrect or unsupported mime type");
                }
            case FileConst.FILESYSTEM_ANIME:
                if (Pattern.matches("^video/.*", mimeType)) {
                    return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getAnimeLocation());
                } else {
                    throw new PathServiceException("Incorrect or unsupported mime type");
                }
            case FileConst.FILESYSTEM_MOVIE:
                if (Pattern.matches("^video/.*", mimeType)) {
                    return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getMovieLocation());
                } else {
                    throw new PathServiceException("Incorrect or unsupported mime type");
                }
            case FileConst.FILESYSTEM_VIDEO:
                if (Pattern.matches("^video/.*", mimeType)) {
                    return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getVideoLocation());
                } else {
                    throw new PathServiceException("Incorrect or unsupported mime type");
                }
            case FileConst.FILESYSTEM_PHOTO:
                if (Pattern.matches("^image/.*", mimeType)) {
                    return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getPhotoLocation());
                } else {
                    throw new PathServiceException("Incorrect or unsupported mime type");
                }
            case FileConst.FILESYSTEM_ILLUSTRATION:
                if (Pattern.matches("^image/.*", mimeType)) {
                    return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getIllustrationLocation());
                } else {
                    throw new PathServiceException("Incorrect or unsupported mime type");
                }
            case FileConst.FILESYSTEM_DOCUMENT:
            case FileConst.FILESYSTEM_BOOK:
                switch (mimeType) {
                    case FileConst.MIME_ADOBE_PDF:
                    case FileConst.MIME_ADOBE_PHOTOSHOP:
                    case FileConst.MIME_MICROSOFT_WORD:
                    case FileConst.MIME_MICROSOFT_EXCEL:
                    case FileConst.MIME_MICROSOFT_POWERPOINT:
                    case FileConst.MIME_MICROSOFT_WORD_OLD:
                    case FileConst.MIME_MICROSOFT_EXCEL_OLD:
                    case FileConst.MIME_MICROSOFT_POWERPOINT_OLD:
                    case FileConst.MIME_OPENDOCUMENT_TEXT:
                    case FileConst.MIME_OPENDOCUMENT_SPREADSHEET:
                    case FileConst.MIME_OPENDOCUMENT_PRESENTATION:
                    case FileConst.MIME_MARKDOWN:
                    case FileConst.MIME_LATEX:
                        return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getDocumentLocation());
                    case FileConst.MIME_EBOOK_EPUB:
                    case FileConst.MIME_EBOOK_IBOOKS:
                        return storageServiceConfig.getRootLocation().resolve(username).resolve(storageServiceConfig.getBookLocation());
                    default:
                        throw new StorageServiceException("Unsupported document MIME type");
                }
            default:
                throw new PathServiceException("Invalid filesystem part");
        }
    }

    /**
     * Check path
     *
     * @param path path to check
     * @return checked path
     */
    @Override
    public Path pathCheck(Path path) {
        try {
            if (Files.notExists(path)) {
                return Files.createDirectories(path);
            } else {
                return path;
            }
        } catch (IOException e) {
            throw new StorageServiceException("Path check " + path.toString() + " error", e);
        }
    }

    /**
     * Get a temp directory
     *
     * @return Path of the temp directory
     */
    @Override
    public Path getTempDirectory() {
        return null;
    }

    @Autowired
    public void setStorageServiceConfig(StorageServiceConfig storageServiceConfig) {
        this.storageServiceConfig = storageServiceConfig;
    }
}

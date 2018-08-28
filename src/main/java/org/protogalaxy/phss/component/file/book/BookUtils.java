package org.protogalaxy.phss.component.file.book;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.epub.EpubReader;
import org.springframework.stereotype.Component;
import org.protogalaxy.phss.component.file.FileCommonUtils;
import org.protogalaxy.phss.component.file.FileConsts;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Component
public class BookUtils {
    private FileCommonUtils fileCommonUtils;

    public BookUtils(FileCommonUtils fileCommonUtils) {
        this.fileCommonUtils = fileCommonUtils;
    }

    public Map<String, Object> getBookMetadata(Path path, String mimeType) {
        Map<String, Object> metadata;
        switch (mimeType) {
            case FileConsts.MIME_EBOOK_EPUB:
                metadata =
        }
    }

    private Map<String, Object> getEpubMetadata(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        EpubReader reader = new EpubReader();
        Book book = reader.readEpub(Files.newInputStream(path));
        metadata.put(FileConsts.METADATA_BOOK_TITLE, book.getTitle());
        if (book.getMetadata().getAuthors() != null)
            metadata.put(FileConsts.METADATA_BOOK_AUTHOR, book.getMetadata().getAuthors().get(0).getFirstname() + book.getMetadata().getAuthors().get(0).getLastname());
        metadata.put(FileConsts.METADATA_BOOK_PATH, path.toString());
        metadata.put(FileConsts.METADATA_BOOK_CREATED, fileCommonUtils.getCreated(path));
        metadata.put(FileConsts.METADATA_BOOK_MODIFIED, fileCommonUtils.getModified(path));
        metadata.put(FileConsts.METADATA_BOOK_LASTACCESSTIME, fileCommonUtils.getLastAccessTime(path));
        metadata.put(FileConsts.METADATA_BOOK_COVER);
        //TODO:here yesterday
        return metadata;
    }
}

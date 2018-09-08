package org.protogalaxy.phss.component.file.book;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.epub.EpubReader;
import org.protogalaxy.phss.service.impl.filesystem.io.CacheServiceImpl;
import org.springframework.stereotype.Component;
import org.protogalaxy.phss.component.file.FileCommonUtils;
import org.protogalaxy.phss.component.file.FileConsts;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Component
public class BookUtils {

    public BookUtils(CacheServiceImpl cachingService) {
    }
}

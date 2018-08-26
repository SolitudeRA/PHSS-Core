package org.protogalaxy.phss.test.document.tika;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.epub.EpubReader;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * EPUB metadata reader test with epublib
 */
public class EPUBMetadataReader {
    @Test
    public void epubEpublibTest() throws Exception {
        EpubReader reader = new EpubReader();
        Book book = reader.readEpub(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.epub")));
        System.out.println(book.getTitle());
        System.out.println(book.getMetadata().getDates().get(0).getValue());
    }

    @Test
    public void epubTikaTest() throws Exception {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        parser.parse(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.epub")), handler, metadata, context);
        System.out.println(metadata.toString());
    }
}

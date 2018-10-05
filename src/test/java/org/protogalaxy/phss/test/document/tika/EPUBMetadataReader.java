package org.protogalaxy.phss.test.document.tika;

import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Date;
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
        Book book = reader.readEpub(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resource\\documents\\test.epub")));
        System.out.println(book.getTitle());
        for (Author author : book.getMetadata().getAuthors()) {
            System.out.println(author.getFirstname() + author.getLastname());
        }
        for (Date date : book.getMetadata().getDates()) {
            System.out.println(date.getValue());
        }
        for (String description : book.getMetadata().getDescriptions()) {
            System.out.println(description);
        }
        for (Author author : book.getMetadata().getContributors()) {
            System.out.println(author.getFirstname() + author.getLastname());
        }
        for (String publisher : book.getMetadata().getPublishers()) {
            System.out.println(publisher);
        }
        for (String right : book.getMetadata().getRights()) {
            System.out.println(right);
        }
        for (String subject : book.getMetadata().getSubjects()) {
            System.out.println(subject);
        }
        for (String type : book.getMetadata().getTypes()) {
            System.out.println(type);
        }
        System.out.println(book.getMetadata().getFormat());
        System.out.println(book.getMetadata().getLanguage());
    }

    @Test
    public void epubTikaTest() throws Exception {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        parser.parse(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resource\\documents\\test.epub")), handler, metadata, context);
        System.out.println(metadata.toString());
    }
}
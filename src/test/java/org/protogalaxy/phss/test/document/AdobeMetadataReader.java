package org.protogalaxy.phss.test.document;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


@DisplayName("Adobe metadata reader test")
public class AdobeMetadataReader {
    @Test
    @DisplayName("Read PDF metadata")
    public void pdfMetadataReader() throws Exception {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        parser.parse(Files.newInputStream(Paths.get("/Users/Luna/Desktop/PHSS-Core/src/test/resources/documents/test.pdf")), handler, metadata, context);
        System.out.println(metadata.get("pdf:PDFVersion"));
        System.out.println(metadata.get("Author"));
        System.out.println(metadata.get("producer"));
        System.out.println(metadata.get("created"));
        System.out.println(metadata.get("modified"));
        System.out.println(metadata.toString());
    }


    @Test
    @DisplayName("Read PSD metadata")
    public void psdMetadataReader() throws Exception {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        parser.parse(Files.newInputStream(Paths.get("/Users/Luna/Desktop/PHSS-Core/src/test/resources/documents/test.psd")), handler, metadata, context);
        System.out.println(new File("/Users/Luna/Desktop/PHSS-Core/src/test/resources/documents/test.psd"));
        System.out.println(metadata.toString());
    }
}

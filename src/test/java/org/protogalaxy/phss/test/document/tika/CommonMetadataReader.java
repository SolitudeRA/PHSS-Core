package org.protogalaxy.phss.test.document.tika;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@DisplayName("Adobe metadata reader test")
public class CommonMetadataReader {

    @Test
    @DisplayName("Read jpg metadata")
    public void commonPhotoJpgMetadataReader() throws IOException, TikaException, SAXException {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        parser.parse(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.jpg")), handler, metadata, context);
        System.out.println(metadata.toString());
    }

    @Test
    @DisplayName("Read png metadata")
    public void commonPhotoPngMetadataReader() throws IOException, TikaException, SAXException {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        parser.parse(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.png")), handler, metadata, context);
        System.out.println(metadata.get("CreatorTool"));
        System.out.println(metadata.toString());
    }
}

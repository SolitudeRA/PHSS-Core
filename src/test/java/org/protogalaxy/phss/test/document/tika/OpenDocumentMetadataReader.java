package org.protogalaxy.phss.test.document.tika;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@DisplayName("Open document metadata reader test" )
public class OpenDocumentMetadataReader {
    @Test
    @DisplayName("Read odt metadata" )
    public void odtMetadataReader() throws Exception {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        parser.parse(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.odt" )), handler, metadata, context);
        System.out.println(metadata.toString());
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(dateFormat.parse(metadata.get("meta:creation-date")));
    }

    @Test
    @DisplayName("Read ods metadata" )
    public void odsMetadataReader() throws Exception {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        parser.parse(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.ods" )), handler, metadata, context);
        System.out.println(metadata.toString());
    }

    @Test
    @DisplayName("Read odp metadata" )
    public void odpMetadataReader() throws Exception {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        parser.parse(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.odp" )), handler, metadata, context);
        System.out.println(metadata.toString());
    }
}

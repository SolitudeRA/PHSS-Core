package org.protogalaxy.phss.test.document;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.nio.file.Files;
import java.nio.file.Paths;

@DisplayName("Office metadata reader test")
public class OfficeMetadataReader {
    @Test
    public void docMetadataReader() throws Exception {
        WordExtractor extractor = new WordExtractor(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.doc")));
        System.out.println(extractor.getMetadataTextExtractor().getText());
    }

    @Test
    public void docxMetadataReader()throws Exception{
        XWPFWordExtractor extractor = new XWPFWordExtractor(new XWPFDocument(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.docx"))));
        System.out.println(extractor.getMetadataTextExtractor().getText());
    }
}

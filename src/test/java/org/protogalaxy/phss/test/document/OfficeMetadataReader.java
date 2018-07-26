package org.protogalaxy.phss.test.document;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.nio.file.Files;
import java.nio.file.Paths;

@DisplayName("Office metadata reader test")
public class OfficeMetadataReader {
    @Test
    public void wordMetadataReader() throws Exception {
        WordExtractor wordExtractor = new WordExtractor(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.doc")));
        String text = wordExtractor.getMetadataTextExtractor().getText();
        System.out.println(text);
    }
}

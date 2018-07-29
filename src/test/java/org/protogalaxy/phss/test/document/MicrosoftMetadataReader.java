package org.protogalaxy.phss.test.document;

import org.apache.poi.hslf.extractor.PowerPointExtractor;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.nio.file.Files;
import java.nio.file.Paths;

@DisplayName("Office metadata reader test")
public class MicrosoftMetadataReader {
    @Test
    @DisplayName("Read DOC metadata")
    public void docMetadataReader() throws Exception {
        WordExtractor extractor = new WordExtractor(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.doc")));
        System.out.println(extractor.getMetadataTextExtractor().getText());
    }

    @Test
    @DisplayName("Read XLS metadata")
    public void xlsMetadataReader() throws Exception {
        ExcelExtractor extractor = new ExcelExtractor(new HSSFWorkbook(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.xls"))));
        System.out.println(extractor.getMetadataTextExtractor().getText());
    }

    @Test
    @DisplayName("Read PPT metadata")
    public void pptMetadataReader() throws Exception {
        PowerPointExtractor extractor = new PowerPointExtractor(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.ppt")));
        System.out.println(extractor.getMetadataTextExtractor().getText());
    }

    @Test
    @DisplayName("Read DOCX metadata")
    public void docxMetadataReader() throws Exception {
        XWPFWordExtractor extractor = new XWPFWordExtractor(new XWPFDocument(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.docx"))));
        System.out.println(extractor.getMetadataTextExtractor().getText());
    }

    @Test
    @DisplayName("Read XLSX metadata")
    public void xlsxMetadataReader() throws Exception {
        XSSFExcelExtractor extractor = new XSSFExcelExtractor(new XSSFWorkbook(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.xlsx"))));
        System.out.println(extractor.getMetadataTextExtractor().getText());
    }

    @Test
    @DisplayName("Read PPTX metadata")
    public void pptxMetadataReader() throws Exception {
        XSLFPowerPointExtractor extractor = new XSLFPowerPointExtractor(new XMLSlideShow(Files.newInputStream(Paths.get("W:\\Projects\\PHSS-Core\\src\\test\\resources\\documents\\test.pptx"))));
        System.out.println(extractor.getMetadataTextExtractor().getText());
    }
}

package org.protogalaxy.phss.component.file.document;

import org.apache.poi.POIXMLProperties;
import org.apache.poi.hpsf.SummaryInformation;
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
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.protogalaxy.phss.component.file.FileCommonUtils;
import org.protogalaxy.phss.component.file.FileConsts;
import org.protogalaxy.phss.exception.component.file.ComponentFileInvalidMimeTypeException;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DocumentUtils {
    private FileCommonUtils fileCommonUtils;

    public DocumentUtils(FileCommonUtils fileCommonUtils) {
        this.fileCommonUtils = fileCommonUtils;
    }

    public Map<String, Object> getDocumentMetadata(Path path) throws Exception {
        Map<String, Object> metadata;
        switch (fileCommonUtils.getMimeType(path)) {
            case FileConsts.MIME_ADOBE_PDF:
                metadata = getMetadataAdobePdf(path);
                break;
            case FileConsts.MIME_ADOBE_PHOTOSHOP:
                metadata = getMetadataAdobePhotoshop(path);
                break;
            case FileConsts.MIME_MICROSOFT_WORD_OLD:
                metadata = getMetadataMicroSoftWordOld(path);
                break;
            case FileConsts.MIME_MICROSOFT_EXCEL_OLD:
                metadata = getMetadataMicroSoftExcelOld(path);
                break;
            case FileConsts.MIME_MICROSOFT_POWERPOINT_OLD:
                metadata = getMetadataMicroSoftPowerpointOld(path);
                break;
            case FileConsts.MIME_MICROSOFT_WORD:
                metadata = getMetadataMicroSoftWord(path);
                break;
            case FileConsts.MIME_MICROSOFT_EXCEL:
                metadata = getMetadataMicroSoftExcel(path);
                break;
            case FileConsts.MIME_MICROSOFT_POWERPOINT:
                metadata = getMetadataMicroSoftPowerpoint(path);
                break;
            case FileConsts.MIME_OPENDOCUMENT_PRESENTATION:
                metadata = getMetadataOpenDocumentPresentation(path);
                break;
            case FileConsts.MIME_OPENDOCUMENT_SPREADSHEET:
                metadata = getMetadataOpenDocumentSpreadsheet(path);
                break;
            case FileConsts.MIME_OPENDOCUMENT_TEXT:
                metadata = getMetadataOpenDocumentText(path);
                break;
            case FileConsts.MIME_MARKDOWN:
                metadata = getMetadataMarkdown(path);
                break;
            case FileConsts.MIME_LATEX:
                metadata = getMetadataLatex(path);
                break;
            default:
                throw new ComponentFileInvalidMimeTypeException("Invalid MIME type");
        }
        return metadata;
    }

    private Map<String, Object> getMetadataAdobePdf(Path path) throws Exception {
        return metadataFiller(FileConsts.ADOBE_PDF_METADATA_LIST, getTikaMetadata(path));
    }

    private Map<String, Object> getMetadataAdobePhotoshop(Path path) throws Exception {
        return metadataFiller(FileConsts.ADOBE_PHOTOSHOP_METADATA_LIST, getTikaMetadata(path));
    }

    private Map<String, Object> getMetadataMicroSoftWordOld(Path path) throws Exception {
        WordExtractor extractor = new WordExtractor(Files.newInputStream(path));
        return getMicroSoftOfficeMetadataOld(extractor.getSummaryInformation());
    }

    private Map<String, Object> getMetadataMicroSoftExcelOld(Path path) throws Exception {
        ExcelExtractor extractor = new ExcelExtractor(new HSSFWorkbook(Files.newInputStream(path)));
        return getMicroSoftOfficeMetadataOld(extractor.getSummaryInformation());
    }

    private Map<String, Object> getMetadataMicroSoftPowerpointOld(Path path) throws Exception {
        PowerPointExtractor extractor = new PowerPointExtractor(Files.newInputStream(path));
        return getMicroSoftOfficeMetadataOld(extractor.getSummaryInformation());
    }

    private Map<String, Object> getMetadataMicroSoftWord(Path path) throws Exception {
        XWPFWordExtractor extractor = new XWPFWordExtractor(new XWPFDocument(Files.newInputStream(path)));
        return getMicroSoftOfficeMetadata(extractor.getCoreProperties(), extractor.getExtendedProperties());
    }

    private Map<String, Object> getMetadataMicroSoftExcel(Path path) throws Exception {
        XSSFExcelExtractor extractor = new XSSFExcelExtractor(new XSSFWorkbook(Files.newInputStream(path)));
        return getMicroSoftOfficeMetadata(extractor.getCoreProperties(), extractor.getExtendedProperties());
    }

    private Map<String, Object> getMetadataMicroSoftPowerpoint(Path path) throws Exception {
        XSLFPowerPointExtractor extractor = new XSLFPowerPointExtractor(new XMLSlideShow(Files.newInputStream(path)));
        return getMicroSoftOfficeMetadata(extractor.getCoreProperties(), extractor.getExtendedProperties());
    }

    private Map<String, Object> getMetadataOpenDocumentPresentation(Path path) {
        return null;
    }

    private Map<String, Object> getMetadataOpenDocumentSpreadsheet(Path path) {
        return null;
    }

    private Map<String, Object> getMetadataOpenDocumentText(Path path) {
        return null;
    }

    private Map<String, Object> getMetadataMarkdown(Path path) {
        return null;
    }

    private Map<String, Object> getMetadataLatex(Path path) {
        return null;
    }

    private Map<String, Object> getMicroSoftOfficeMetadataOld(SummaryInformation information) {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_TITLE, information.getTitle());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_AUTHOR, information.getAuthor());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_KEYWORDS, information.getKeywords());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_COMMENTS, information.getComments());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_LASTAUTHOR, information.getLastAuthor());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_EDITTIME, information.getEditTime());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_CREATED, information.getCreateDateTime());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_LASTSAVEDTM, information.getLastSaveDateTime());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_PAGECOUNT, information.getPageCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_WORDCOUNT, information.getWordCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_CHARCOUNT, information.getCharCount());
        return metadata;
    }

    private Map<String, Object> getMicroSoftOfficeMetadata(POIXMLProperties.CoreProperties coreProperties, POIXMLProperties.ExtendedProperties extendedProperties) {
        Map<String, Object> metadata = new HashMap<>();
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_TITLE, coreProperties.getTitle());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_CREATOR, coreProperties.getCreator());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_KEYWORDS, coreProperties.getKeywords());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_CREATED, coreProperties.getCreated());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_MODIFIED, coreProperties.getModified());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_CHARACTERS, extendedProperties.getCharacters());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_CHARACTERSWITHSPACES, extendedProperties.getCharactersWithSpaces());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_PAGES, extendedProperties.getPages());
        return metadata;
    }

    private Map<String, Object> metadataFiller(List<String> metadataList, Metadata tikaMetadata) {
        Map<String, Object> metadata = new HashMap<>();
        for (String metadataName : metadataList) {
            metadata.put(metadataName, tikaMetadata.get(metadataName));
        }
        return metadata;
    }

    private Metadata getTikaMetadata(Path path) throws Exception {
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        parser.parse(Files.newInputStream(path), handler, metadata, context);
        return metadata;
    }
}

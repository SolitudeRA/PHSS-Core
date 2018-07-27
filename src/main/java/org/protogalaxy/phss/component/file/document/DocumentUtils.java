package org.protogalaxy.phss.component.file.document;

import org.apache.poi.POIXMLProperties;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hslf.extractor.PowerPointExtractor;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlideShow;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.protogalaxy.phss.component.file.FileCommonUtils;
import org.protogalaxy.phss.component.file.FileConsts;
import org.protogalaxy.phss.exception.component.file.ComponentFileInvalidMimeTypeException;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DocumentUtils {
    private FileCommonUtils fileCommonUtils;
    private static final List<String> MICROSOFT_OFFICE_OLD_METADATA_LIST = Arrays.asList(
            FileConsts.METADATA_MICROSOFT_OFFICE_OLD_TITLE,
            FileConsts.METADATA_MICROSOFT_OFFICE_OLD_AUTHOR,
            FileConsts.METADATA_MICROSOFT_OFFICE_OLD_KEYWORDS,
            FileConsts.METADATA_MICROSOFT_OFFICE_OLD_COMMENTS,
            FileConsts.METADATA_MICROSOFT_OFFICE_OLD_LASTAUTHOR,
            FileConsts.METADATA_MICROSOFT_OFFICE_OLD_EDITTIME,
            FileConsts.METADATA_MICROSOFT_OFFICE_OLD_CREATEDTM,
            FileConsts.METADATA_MICROSOFT_OFFICE_OLD_LASTSAVEDTM,
            FileConsts.METADATA_MICROSOFT_OFFICE_OLD_PAGECOUNT,
            FileConsts.METADATA_MICROSOFT_OFFICE_OLD_WORDCOUNT,
            FileConsts.METADATA_MICROSOFT_OFFICE_OLD_CHARCOUNT
    );
    private static final List<String> MICROSOFT_OFFICE_METADATA_LIST = Arrays.asList(
            FileConsts.METADATA_MICROSOFT_OFFICE_TITLE,
            FileConsts.METADATA_MICROSOFT_OFFICE_CREATOR,
            FileConsts.METADATA_MICROSOFT_OFFICE_KEYWORDS,
            FileConsts.METADATA_MICROSOFT_OFFICE_CREATED,
            FileConsts.METADATA_MICROSOFT_OFFICE_MODIFIED,
            FileConsts.METADATA_MICROSOFT_OFFICE_CHARACTERS,
            FileConsts.METADATA_MICROSOFT_OFFICE_CHARACTERSWITHSPACES,
            FileConsts.METADATA_MICROSOFT_OFFICE_PAGES
    );

    public DocumentUtils(FileCommonUtils fileCommonUtils) {
        this.fileCommonUtils = fileCommonUtils;
    }

    public Map<String, Object> getDocumentMetadata(Path path) throws Exception {
        Map<String, Object> metadata;
        switch (fileCommonUtils.getMimeType(path)) {
            case FileConsts.MIME_ADOBE_PDF:
                metadata = getMetadataAdobePdf(path);
                break;
            case FileConsts.MIME_ADOBE_INDESIGN:
                metadata = getMetadataAdobeIndesign(path);
                break;
            case FileConsts.MIME_ADOBE_PHOTOSHOP:
                metadata = getMetadataAdobePhotoshop(path);
                break;
            case FileConsts.MIME_ADOBE_ILLUSTRATOR:
                metadata = getMetadataAdobeIllustrator(path);
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

    private Map<String, Object> getMetadataAdobePdf(Path path) {
        return null;
    }

    private Map<String, Object> getMetadataAdobeIndesign(Path path) {
        return null;
    }

    private Map<String, Object> getMetadataAdobePhotoshop(Path path) {
        return null;
    }

    private Map<String, Object> getMetadataAdobeIllustrator(Path path) {
        return null;
    }

    private Map<String, Object> getMetadataMicroSoftWordOld(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        WordExtractor extractor = new WordExtractor(Files.newInputStream(path));
        return microSoftOfficeMetadataFillerOld(metadata, extractor.getSummaryInformation());
    }

    private Map<String, Object> getMetadataMicroSoftExcelOld(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        ExcelExtractor extractor = new ExcelExtractor(new HSSFWorkbook(Files.newInputStream(path)));
        return microSoftOfficeMetadataFillerOld(metadata, extractor.getSummaryInformation());
    }

    private Map<String, Object> getMetadataMicroSoftPowerpointOld(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        PowerPointExtractor extractor = new PowerPointExtractor(Files.newInputStream(path));
        return microSoftOfficeMetadataFillerOld(metadata, extractor.getSummaryInformation());
    }

    private Map<String, Object> getMetadataMicroSoftWord(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        XWPFWordExtractor extractor = new XWPFWordExtractor(new XWPFDocument(Files.newInputStream(path)));
        return microSoftOfficeMetadataFiller(metadata, extractor.getCoreProperties(), extractor.getExtendedProperties());
    }

    private Map<String, Object> getMetadataMicroSoftExcel(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        XSSFExcelExtractor extractor = new XSSFExcelExtractor(new XSSFWorkbook(Files.newInputStream(path)));
        return microSoftOfficeMetadataFiller(metadata, extractor.getCoreProperties(), extractor.getExtendedProperties());
    }

    private Map<String, Object> getMetadataMicroSoftPowerpoint(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        XSLFPowerPointExtractor extractor = new XSLFPowerPointExtractor(new XMLSlideShow(Files.newInputStream(path)));
        return microSoftOfficeMetadataFiller(metadata, extractor.getCoreProperties(), extractor.getExtendedProperties());
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

    private Map<String, Object> microSoftOfficeMetadataFillerOld(Map<String, Object> metadata, SummaryInformation information) {
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_TITLE, information.getTitle());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_AUTHOR, information.getAuthor());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_KEYWORDS, information.getKeywords());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_COMMENTS, information.getComments());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_LASTAUTHOR, information.getLastAuthor());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_EDITTIME, information.getEditTime());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_CREATEDTM, information.getCreateDateTime());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_LASTSAVEDTM, information.getLastSaveDateTime());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_PAGECOUNT, information.getPageCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_WORDCOUNT, information.getWordCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_OFFICE_OLD_CHARCOUNT, information.getCharCount());
        return metadata;
    }

    private Map<String, Object> microSoftOfficeMetadataFiller(Map<String, Object> metadata, POIXMLProperties.CoreProperties coreProperties, POIXMLProperties.ExtendedProperties extendedProperties) {
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
}

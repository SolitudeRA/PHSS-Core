package org.protogalaxy.phss.component.file.document;

import org.apache.poi.POIXMLProperties;
import org.apache.poi.hpsf.DocumentSummaryInformation;
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

import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.*;

//TODO: metadata reader format update
@Component
public class DocumentUtils {
    private FileCommonUtils fileCommonUtils;

    public DocumentUtils(FileCommonUtils fileCommonUtils){
        this.fileCommonUtils = fileCommonUtils;
    }

    public Map<String, Object> getDocumentMetadata(Path path) throws Exception{
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
                throw new ComponentFileInvalidMimeTypeException("Unsupported MIME type");
        }
        return metadata;
    }

    private Map<String, Object> getMetadataAdobePdf(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        Metadata tikaMetadata = getTikaMetadata(path);
        metadata.put(FileConsts.METADATA_ADOBE_PDF_TITLE, path.getFileName());
        metadata.put(FileConsts.METADATA_ADOBE_PDF_CREATED, getCreated(path));
        metadata.put(FileConsts.METADATA_ADOBE_PDF_MODIFIED, getModified(path));
        metadata.put(FileConsts.METADATA_ADOBE_PDF_PATH, path.toString());
        metadata.put(FileConsts.METADATA_ADOBE_PDF_LASTACCESSTIME, getLastAccessTime(path));
        metadata.put(FileConsts.METADATA_ADOBE_PDF_CREATOR, tikaMetadata.get(FileConsts.METADATA_ADOBE_PDF_CREATOR));
        metadata.put(FileConsts.METADATA_ADOBE_PDF_VERSION, tikaMetadata.get(FileConsts.METADATA_ADOBE_PDF_VERSION));
        metadata.put(FileConsts.METADATA_ADOBE_PDF_PRODUCER, tikaMetadata.get(FileConsts.METADATA_ADOBE_PDF_PRODUCER));
        return metadata;
    }

    private Map<String, Object> getMetadataAdobePhotoshop(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        Metadata tikaMetadata = getTikaMetadata(path);
        metadata.put(FileConsts.METADATA_ADOBE_PHOTOSHOP_TITLE, path.getFileName());
        metadata.put(FileConsts.METADATA_ADOBE_PHOTOSHOP_CREATED, getCreated(path));
        metadata.put(FileConsts.METADATA_ADOBE_PHOTOSHOP_MODIFIED, getModified(path));
        metadata.put(FileConsts.METADATA_ADOBE_PHOTOSHOP_PATH, path.toString());
        metadata.put(FileConsts.METADATA_ADOBE_PHOTOSHOP_LASTACCESSTIME, getLastAccessTime(path));
        metadata.put(FileConsts.METADATA_ADOBE_PHOTOSHOP_WIDTH, tikaMetadata.get(FileConsts.METADATA_ADOBE_PHOTOSHOP_WIDTH));
        metadata.put(FileConsts.METADATA_ADOBE_PHOTOSHOP_HEIGHT, tikaMetadata.get(FileConsts.METADATA_ADOBE_PHOTOSHOP_HEIGHT));
        metadata.put(FileConsts.METADATA_ADOBE_PHOTOSHOP_COLORMODE, tikaMetadata.get(FileConsts.METADATA_ADOBE_PHOTOSHOP_COLORMODE));
        metadata.put(FileConsts.METADATA_ADOBE_PHOTOSHOP_BITSPERSAMPLE, tikaMetadata.get(FileConsts.METADATA_ADOBE_PHOTOSHOP_BITSPERSAMPLE));
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftWordOld(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        WordExtractor extractor = new WordExtractor(Files.newInputStream(path));
        SummaryInformation summaryInformation = extractor.getSummaryInformation();
        DocumentSummaryInformation documentSummaryInformation = extractor.getDocSummaryInformation();
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_TITLE, summaryInformation.getTitle());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_CREATED, getCreated(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_MODIFIED, getModified(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_PATH, path.toString());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_LASTACCESSTIME, getLastAccessTime(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_CREATOR, summaryInformation.getAuthor());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_MODIFIER, summaryInformation.getLastAuthor());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_KEYWORDS, summaryInformation.getKeywords());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_COMMENTS, summaryInformation.getComments());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_APPNAME, summaryInformation.getApplicationName());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_EDITTIME, summaryInformation.getEditTime());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_PAGECOUNT, summaryInformation.getPageCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_WORDCOUNT, summaryInformation.getWordCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_CHARCOUNT, summaryInformation.getCharCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_LINECOUNT, documentSummaryInformation.getLineCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_PARCOUNT, documentSummaryInformation.getParCount());
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftExcelOld(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        ExcelExtractor extractor = new ExcelExtractor(new HSSFWorkbook(Files.newInputStream(path)));
        SummaryInformation summaryInformation = extractor.getSummaryInformation();
        DocumentSummaryInformation documentSummaryInformation = extractor.getDocSummaryInformation();
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_TITLE, summaryInformation.getTitle());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_CREATED, getCreated(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_MODIFIED, getModified(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_PATH, path.toString());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_LASTACCESSTIME, getLastAccessTime(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_CREATOR, summaryInformation.getAuthor());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_MODIFIER, summaryInformation.getLastAuthor());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_APPNAME, summaryInformation.getApplicationName());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_OLD_DOCPARTS, documentSummaryInformation.getDocparts());
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftPowerpointOld(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        PowerPointExtractor extractor = new PowerPointExtractor(Files.newInputStream(path));
        SummaryInformation summaryInformation = extractor.getSummaryInformation();
        DocumentSummaryInformation documentSummaryInformation = extractor.getDocSummaryInformation();
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_TITLE, summaryInformation.getTitle());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_CREATED, getCreated(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_MODIFIED, getModified(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_PATH, path.toString());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_LASTACCESSTIME, getLastAccessTime(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_CREATOR, summaryInformation.getAuthor());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_MODIFIER, summaryInformation.getLastAuthor());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_APPNAME, summaryInformation.getApplicationName());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_EDITTIME, summaryInformation.getEditTime());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_WORDCOUNT, summaryInformation.getWordCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_PRESFORMAT, documentSummaryInformation.getPresentationFormat());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_BYTECOUNT, documentSummaryInformation.getByteCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_PARCOUNT, documentSummaryInformation.getParCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_SLIDECOUNT, documentSummaryInformation.getSlideCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_NOTECOUNT, documentSummaryInformation.getNoteCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_HIDDENCOUNT, documentSummaryInformation.getHiddenCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_OLD_MMCLIPCOUNT, documentSummaryInformation.getMMClipCount());
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftWord(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        XWPFWordExtractor extractor = new XWPFWordExtractor(new XWPFDocument(Files.newInputStream(path)));
        POIXMLProperties.CoreProperties coreProperties = extractor.getCoreProperties();
        POIXMLProperties.ExtendedProperties extendedProperties = extractor.getExtendedProperties();
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_TITLE, coreProperties.getTitle());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_CREATED, getCreated(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_MODIFIED, getModified(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_PATH, path.toString());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_LASTACCESSTIME, getLastAccessTime(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_CREATOR, coreProperties.getCreator());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_MODIFIER, coreProperties.getLastModifiedByUser());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_APPLICATION, extendedProperties.getApplication());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_APPVERSION, extendedProperties.getAppVersion());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_CHARACTERS, extendedProperties.getCharacters());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_CHARACTERSWITHSPACES, extendedProperties.getCharactersWithSpaces());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_LINES, extendedProperties.getLines());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_PAGES, extendedProperties.getPages());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_PARAGRAPHS, extendedProperties.getParagraphs());
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftExcel(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        XSSFExcelExtractor extractor = new XSSFExcelExtractor(new XSSFWorkbook(Files.newInputStream(path)));
        POIXMLProperties.CoreProperties coreProperties = extractor.getCoreProperties();
        POIXMLProperties.ExtendedProperties extendedProperties = extractor.getExtendedProperties();
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_TITLE, coreProperties.getTitle());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_CREATED, getCreated(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_MODIFIED, getModified(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_PATH, path.toString());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_LASTACCESSTIME, getLastAccessTime(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_CREATOR, coreProperties.getCreator());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_MODIFIER, coreProperties.getLastModifiedByUser());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_APPLICATION, extendedProperties.getApplication());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_APPVERSION, extendedProperties.getAppVersion());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_CHARACTERS, extendedProperties.getCharacters());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_CHARACTERSWITHSPACES, extendedProperties.getCharactersWithSpaces());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_LINES, extendedProperties.getLines());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_PAGES, extendedProperties.getPages());
        metadata.put(FileConsts.METADATA_MICROSOFT_EXCEL_PARAGRAPHS, extendedProperties.getParagraphs());
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftPowerpoint(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        XSLFPowerPointExtractor extractor = new XSLFPowerPointExtractor(new XMLSlideShow(Files.newInputStream(path)));
        POIXMLProperties.CoreProperties coreProperties = extractor.getCoreProperties();
        POIXMLProperties.ExtendedProperties extendedProperties = extractor.getExtendedProperties();
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_TITLE, coreProperties.getTitle());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_CREATED, getCreated(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_MODIFIED, getModified(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_PATH, path.toString());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_LASTACCESSTIME, getLastAccessTime(path));
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_CREATOR, coreProperties.getCreator());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_MODIFIER, coreProperties.getLastModifiedByUser());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_APPLICATION, extendedProperties.getApplication());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_APPVERSION, extendedProperties.getAppVersion());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_CHARACTERS, extendedProperties.getCharacters());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_CHARACTERSWITHSPACES, extendedProperties.getCharactersWithSpaces());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_LINES, extendedProperties.getLines());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_PAGES, extendedProperties.getPages());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_PARAGRAPHS, extendedProperties.getParagraphs());
        metadata.put(FileConsts.METADATA_MICROSOFT_POWERPOINT_PRESENTATIONFORMAT, extendedProperties.getPresentationFormat());
        return metadata;
    }

    private Map<String, Object> getMetadataOpenDocumentText(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        Metadata tikaMetadata = getTikaMetadata(path);
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_TEXT_TITLE, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_TITLE));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_TEXT_CREATED, getCreated(path));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_TEXT_MODIFIED, getModified(path));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_TEXT_PATH, path.toString());
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_TEXT_LASTACCESSTIME, getLastAccessTime(path));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_TEXT_CREATOR, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_CREATOR));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_TEXT_MODIFIER, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_MODIFIER));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_TEXT_WORDCOUNT, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_WORDCOUNT));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_TEXT_CHARACTERCOUNT, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_CHARACTERCOUNT));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_TEXT_IMAGECOUNT, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_IMAGECOUNT));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_TEXT_PARCOUNT, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_PARCOUNT));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_TEXT_TABLECOUNT, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_TABLECOUNT));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_TEXT_PAGECOUNT, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_TEXT_PAGECOUNT));
        return metadata;
    }

    private Map<String, Object> getMetadataOpenDocumentSpreadsheet(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        Metadata tikaMetadata = getTikaMetadata(path);
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_TITLE, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_TITLE));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_CREATED, getCreated(path));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_MODIFIED, getModified(path));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_PATH, path.toString());
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_LASTACCESSTIME, getLastAccessTime(path));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_CREATOR, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_CREATOR));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_MODIFIER, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_SPREADSHEET_MODIFIER));
        return metadata;
    }

    private Map<String, Object> getMetadataOpenDocumentPresentation(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        Metadata tikaMetadata = getTikaMetadata(path);
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_TITLE, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_TITLE));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_CREATED, getCreated(path));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_MODIFIED, getModified(path));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_PATH, path.toString());
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_LASTACCESSTIME, getLastAccessTime(path));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_CREATOR, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_CREATOR));
        metadata.put(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_MODIFIER, tikaMetadata.get(FileConsts.METADATA_OPENDOCUMENT_PRESENTATION_MODIFIER));
        return metadata;
    }

    private Map<String, Object> getMetadataMarkdown(Path path){
        Map<String, Object> metadata = new HashMap<>();
        return metadata;
    }

    private Map<String, Object> getMetadataLatex(Path path){
        Map<String, Object> metadata = new HashMap<>();
        return metadata;
    }

    private Metadata getTikaMetadata(Path path) throws Exception{
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        parser.parse(Files.newInputStream(path), handler, metadata, context);
        return metadata;
    }

    private Date getCreated(Path path) throws Exception{
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        return new Date(attributes.creationTime().toMillis());
    }

    private Date getModified(Path path) throws Exception{
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        return new Date(attributes.lastModifiedTime().toMillis());
    }

    private Date getLastAccessTime(Path path) throws Exception{
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        return new Date(attributes.lastAccessTime().toMillis());
    }
}

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

        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftExcelOld(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        ExcelExtractor extractor = new ExcelExtractor(new HSSFWorkbook(Files.newInputStream(path)));
        SummaryInformation summaryInformation = extractor.getSummaryInformation();
        DocumentSummaryInformation documentSummaryInformation = extractor.getDocSummaryInformation();
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftPowerpointOld(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        PowerPointExtractor extractor = new PowerPointExtractor(Files.newInputStream(path));
        SummaryInformation summaryInformation = extractor.getSummaryInformation();
        DocumentSummaryInformation documentSummaryInformation = extractor.getDocSummaryInformation();
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftWord(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        XWPFWordExtractor extractor = new XWPFWordExtractor(new XWPFDocument(Files.newInputStream(path)));
        POIXMLProperties.CoreProperties coreProperties = extractor.getCoreProperties();
        POIXMLProperties.ExtendedProperties extendedProperties = extractor.getExtendedProperties();
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftExcel(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        XSSFExcelExtractor extractor = new XSSFExcelExtractor(new XSSFWorkbook(Files.newInputStream(path)));
        POIXMLProperties.CoreProperties coreProperties = extractor.getCoreProperties();
        POIXMLProperties.ExtendedProperties extendedProperties = extractor.getExtendedProperties();
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftPowerpoint(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        XSLFPowerPointExtractor extractor = new XSLFPowerPointExtractor(new XMLSlideShow(Files.newInputStream(path)));
        POIXMLProperties.CoreProperties coreProperties = extractor.getCoreProperties();
        POIXMLProperties.ExtendedProperties extendedProperties = extractor.getExtendedProperties();

        return metadata;
    }

    private Map<String, Object> getMetadataOpenDocumentText(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        return metadataFiller(FileConsts.OPENDOCUMENT_TEXT_METADATA_LIST, getTikaMetadata(path));
    }

    private Map<String, Object> getMetadataOpenDocumentSpreadsheet(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        return metadataFiller(FileConsts.OPENDOCUMENT_SPREADSHEET_METADATA_LIST, getTikaMetadata(path));
    }

    private Map<String, Object> getMetadataOpenDocumentPresentation(Path path) throws Exception{
        Map<String, Object> metadata = new HashMap<>();
        return metadataFiller(FileConsts.OPENDOCUMENT_SPREADSHEET_PRESENTATION_LIST, getTikaMetadata(path));
    }

    private Map<String, Object> getMetadataMarkdown(Path path){
        Map<String, Object> metadata = new HashMap<>();
        return null;
    }

    private Map<String, Object> getMetadataLatex(Path path){
        Map<String, Object> metadata = new HashMap<>();
        return null;
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

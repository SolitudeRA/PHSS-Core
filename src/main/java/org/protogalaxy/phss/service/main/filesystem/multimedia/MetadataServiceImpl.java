package org.protogalaxy.phss.service.main.filesystem.multimedia;


import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hslf.extractor.PowerPointExtractor;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ooxml.POIXMLProperties;
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
import org.bytedeco.javacpp.*;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.protogalaxy.phss.component.consts.AudioConst;
import org.protogalaxy.phss.component.consts.FileConst;
import org.protogalaxy.phss.component.utilities.FileUtilities;
import org.protogalaxy.phss.component.utilities.MultimediaUtilities;
import org.protogalaxy.phss.exception.application.filesystem.real.file.InvalidMimeTypeUtilsException;
import org.protogalaxy.phss.service.interfaces.filesystem.io.CacheService;
import org.protogalaxy.phss.service.interfaces.filesystem.multimedia.MetadataService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static org.bytedeco.javacpp.avformat.*;
import static org.bytedeco.javacpp.avutil.*;

public class MetadataServiceImpl implements MetadataService {
    private CacheService cacheService;

    public MetadataServiceImpl(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public Map<String, Object> musicMetadataResolver(Path path) throws Exception {
        Map<String, Object> metadataRawMap = new HashMap<>();
        Map<String, Object> metadataCurrentMap = new HashMap<>();
        AVFormatContext avFormatContext = avformat_alloc_context();
        AVDictionaryEntry entry = null;
        avformat_open_input(avFormatContext, path.toString(), null, null);
        avformat_find_stream_info(avFormatContext, (PointerPointer) null);
        while ((entry = av_dict_get(avFormatContext.metadata(), "", entry, AV_DICT_IGNORE_SUFFIX)) != null) {
            metadataRawMap.put(entry.key().getString(), entry.value().getString());
        }
        for (String key : AudioConst.METADATA_AUDIO_STANDARD_LIST) {
            if (metadataRawMap.get(key) != null) {
                metadataCurrentMap.put(key, metadataRawMap.get(key).toString().trim());
            }
        }
        metadataCurrentMap.put(AudioConst.METADATA_AUDIO_DURATION, MultimediaUtilities.formatDurationToMilliSeconds(avFormatContext.duration()));
        metadataCurrentMap.put(AudioConst.METADATA_AUDIO_BITRATE, MultimediaUtilities.formatBitrate(avFormatContext.streams(0).codecpar().bit_rate()));
        metadataCurrentMap.put(AudioConst.METADATA_AUDIO_SAMPLE_RATE, avFormatContext.streams(0).codecpar().sample_rate());
        metadataCurrentMap.put(AudioConst.METADATA_AUDIO_BIT_DEPTH, avFormatContext.streams(0).codecpar().bits_per_raw_sample());
        metadataCurrentMap.put(AudioConst.METADATA_AUDIO_SIZE, Files.size(path));
        metadataCurrentMap.put(AudioConst.METADATA_AUDIO_KIND, FilenameUtils.getExtension(path.getFileName().toString()));
        metadataCurrentMap.put(AudioConst.METADATA_AUDIO_MD5, FileUtilities.getMD5(path));
        avformat_close_input(avFormatContext);
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(path.toFile());
        Java2DFrameConverter converter = new Java2DFrameConverter();
        grabber.start();
        metadataCurrentMap.put(AudioConst.METADATA_AUDIO_ARTWORK, cacheService.cacheImage(converter.getBufferedImage(grabber.grabImage())));
        grabber.close();
        return metadataCurrentMap;
    }

    @Override
    public Map<String, Object> videoMetadataResolver(Path path) {
        Map<String, Object> metadataMap = new HashMap<>();
        AVFormatContext avFormatContext = avformat_alloc_context();
        avformat_open_input(avFormatContext, path.toString(), null, null);
        avformat_find_stream_info(avFormatContext, (PointerPointer) null);
        av_dict_get(avFormatContext.metadata(), "", null, AV_DICT_IGNORE_SUFFIX).key().getString();
        metadataMap.put(FileConst.METADATA_VIDEO_DURATION, MultimediaUtilities.formatDurationToMilliSeconds(avFormatContext.streams(0).duration()));
        metadataMap.put(FileConst.METADATA_VIDEO_WIDTH, avFormatContext.streams(0).codecpar().width());
        metadataMap.put(FileConst.METADATA_VIDEO_HEIGHT, avFormatContext.streams(0).codecpar().height());
        return metadataMap;
    }

    @Override
    public Map<String, Object> photoMetadataResolver(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        Metadata tikaMetadata = getTikaMetadata(path);
        return null;
    }

    @Override
    public Map<String, Object> illustrationMetadataResolver(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        Metadata tikaMetadata = getTikaMetadata(path);
        metadata.put(FileConst.METADATA_IMAGE_TITLE, path.getFileName());
        metadata.put(FileConst.METADATA_IMAGE_CREATED, FileUtilities.getCreated(path));
        metadata.put(FileConst.METADATA_IMAGE_MODIFIED, FileUtilities.getModified(path));
        metadata.put(FileConst.METADATA_IMAGE_WIDTH, tikaMetadata.get(FileConst.METADATA_IMAGE_WIDTH));
        metadata.put(FileConst.METADATA_IMAGE_HEIGHT, tikaMetadata.get(FileConst.METADATA_IMAGE_HEIGHT));
        return metadata;
    }

    @Override
    public Map<String, Object> documentMetadataResolver(Path path) throws Exception {
        switch (FileUtilities.getMimeType(path)) {
            case FileConst.MIME_ADOBE_PDF:
                return getMetadataAdobePdf(path);
            case FileConst.MIME_ADOBE_PHOTOSHOP:
                return getMetadataAdobePhotoshop(path);
            case FileConst.MIME_MICROSOFT_WORD:
                return getMetadataMicroSoftWord(path);
            case FileConst.MIME_MICROSOFT_EXCEL:
                return getMetadataMicroSoftExcel(path);
            case FileConst.MIME_MICROSOFT_POWERPOINT:
                return getMetadataMicroSoftPowerpoint(path);
            case FileConst.MIME_MICROSOFT_WORD_OLD:
                return getMetadataMicroSoftWordOld(path);
            case FileConst.MIME_MICROSOFT_EXCEL_OLD:
                return getMetadataMicroSoftExcelOld(path);
            case FileConst.MIME_MICROSOFT_POWERPOINT_OLD:
                return getMetadataMicroSoftPowerpointOld(path);
            case FileConst.MIME_OPENDOCUMENT_TEXT:
                return getMetadataOpenDocumentText(path);
            case FileConst.MIME_OPENDOCUMENT_SPREADSHEET:
                return getMetadataOpenDocumentSpreadsheet(path);
            case FileConst.MIME_OPENDOCUMENT_PRESENTATION:
                return getMetadataOpenDocumentPresentation(path);
            default:
                throw new InvalidMimeTypeUtilsException("MIME type not supported");
        }
    }

    @Override
    public Map<String, Object> bookMetadataResolver(Path path) throws Exception {
        return null;
    }

    /**
     * Resolve ADOBE PDF metadata
     *
     * @param path Temporary path of the file
     * @return Metadata map
     */
    private Map<String, Object> getMetadataAdobePdf(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        Metadata tikaMetadata = getTikaMetadata(path);
        metadata.put(FileConst.METADATA_ADOBE_PDF_TITLE, path.getFileName());
        metadata.put(FileConst.METADATA_ADOBE_PDF_CREATED, FileUtilities.getCreated(path));
        metadata.put(FileConst.METADATA_ADOBE_PDF_MODIFIED, FileUtilities.getModified(path));
        metadata.put(FileConst.METADATA_ADOBE_PDF_LASTACCESSTIME, FileUtilities.getLastAccessTime(path));
        metadata.put(FileConst.METADATA_ADOBE_PDF_CREATOR, tikaMetadata.get(FileConst.METADATA_ADOBE_PDF_CREATOR));
        metadata.put(FileConst.METADATA_ADOBE_PDF_VERSION, tikaMetadata.get(FileConst.METADATA_ADOBE_PDF_VERSION));
        metadata.put(FileConst.METADATA_ADOBE_PDF_PRODUCER, tikaMetadata.get(FileConst.METADATA_ADOBE_PDF_PRODUCER));
        return metadata;
    }

    private Map<String, Object> getMetadataAdobePhotoshop(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        Metadata tikaMetadata = getTikaMetadata(path);
        metadata.put(FileConst.METADATA_ADOBE_PHOTOSHOP_TITLE, path.getFileName());
        metadata.put(FileConst.METADATA_ADOBE_PHOTOSHOP_CREATED, FileUtilities.getCreated(path));
        metadata.put(FileConst.METADATA_ADOBE_PHOTOSHOP_MODIFIED, FileUtilities.getModified(path));
        metadata.put(FileConst.METADATA_ADOBE_PHOTOSHOP_LASTACCESSTIME, FileUtilities.getLastAccessTime(path));
        metadata.put(FileConst.METADATA_ADOBE_PHOTOSHOP_WIDTH, tikaMetadata.get(FileConst.METADATA_ADOBE_PHOTOSHOP_WIDTH));
        metadata.put(FileConst.METADATA_ADOBE_PHOTOSHOP_HEIGHT, tikaMetadata.get(FileConst.METADATA_ADOBE_PHOTOSHOP_HEIGHT));
        metadata.put(FileConst.METADATA_ADOBE_PHOTOSHOP_COLORMODE, tikaMetadata.get(FileConst.METADATA_ADOBE_PHOTOSHOP_COLORMODE));
        metadata.put(FileConst.METADATA_ADOBE_PHOTOSHOP_BITSPERSAMPLE, tikaMetadata.get(FileConst.METADATA_ADOBE_PHOTOSHOP_BITSPERSAMPLE));
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftWord(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        XWPFWordExtractor extractor = new XWPFWordExtractor(new XWPFDocument(Files.newInputStream(path)));
        POIXMLProperties.CoreProperties coreProperties = extractor.getCoreProperties();
        POIXMLProperties.ExtendedProperties extendedProperties = extractor.getExtendedProperties();
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_TITLE, coreProperties.getTitle());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_CREATED, FileUtilities.getCreated(path));
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_MODIFIED, FileUtilities.getModified(path));
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_LASTACCESSTIME, FileUtilities.getLastAccessTime(path));
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_CREATOR, coreProperties.getCreator());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_MODIFIER, coreProperties.getLastModifiedByUser());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_APPLICATION, extendedProperties.getApplication());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_APPVERSION, extendedProperties.getAppVersion());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_CHARACTERS, extendedProperties.getCharacters());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_CHARACTERSWITHSPACES, extendedProperties.getCharactersWithSpaces());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_LINES, extendedProperties.getLines());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_PAGES, extendedProperties.getPages());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_PARAGRAPHS, extendedProperties.getParagraphs());
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftExcel(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        XSSFExcelExtractor extractor = new XSSFExcelExtractor(new XSSFWorkbook(Files.newInputStream(path)));
        POIXMLProperties.CoreProperties coreProperties = extractor.getCoreProperties();
        POIXMLProperties.ExtendedProperties extendedProperties = extractor.getExtendedProperties();
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_TITLE, coreProperties.getTitle());
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_CREATED, FileUtilities.getCreated(path));
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_MODIFIED, FileUtilities.getModified(path));
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_LASTACCESSTIME, FileUtilities.getLastAccessTime(path));
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_CREATOR, coreProperties.getCreator());
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_MODIFIER, coreProperties.getLastModifiedByUser());
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_APPLICATION, extendedProperties.getApplication());
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_APPVERSION, extendedProperties.getAppVersion());
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_CHARACTERS, extendedProperties.getCharacters());
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_CHARACTERSWITHSPACES, extendedProperties.getCharactersWithSpaces());
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_LINES, extendedProperties.getLines());
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_PAGES, extendedProperties.getPages());
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_PARAGRAPHS, extendedProperties.getParagraphs());
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftPowerpoint(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        XSLFPowerPointExtractor extractor = new XSLFPowerPointExtractor(new XMLSlideShow(Files.newInputStream(path)));
        POIXMLProperties.CoreProperties coreProperties = extractor.getCoreProperties();
        POIXMLProperties.ExtendedProperties extendedProperties = extractor.getExtendedProperties();
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_TITLE, coreProperties.getTitle());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_CREATED, FileUtilities.getCreated(path));
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_MODIFIED, FileUtilities.getModified(path));
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_LASTACCESSTIME, FileUtilities.getLastAccessTime(path));
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_CREATOR, coreProperties.getCreator());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_MODIFIER, coreProperties.getLastModifiedByUser());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_APPLICATION, extendedProperties.getApplication());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_APPVERSION, extendedProperties.getAppVersion());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_CHARACTERS, extendedProperties.getCharacters());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_CHARACTERSWITHSPACES, extendedProperties.getCharactersWithSpaces());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_LINES, extendedProperties.getLines());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_PAGES, extendedProperties.getPages());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_PARAGRAPHS, extendedProperties.getParagraphs());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_PRESENTATIONFORMAT, extendedProperties.getPresentationFormat());
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftWordOld(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        WordExtractor extractor = new WordExtractor(Files.newInputStream(path));
        SummaryInformation summaryInformation = extractor.getSummaryInformation();
        DocumentSummaryInformation documentSummaryInformation = extractor.getDocSummaryInformation();
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_TITLE, summaryInformation.getTitle());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_CREATED, FileUtilities.getCreated(path));
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_MODIFIED, FileUtilities.getModified(path));
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_LASTACCESSTIME, FileUtilities.getLastAccessTime(path));
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_CREATOR, summaryInformation.getAuthor());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_MODIFIER, summaryInformation.getLastAuthor());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_KEYWORDS, summaryInformation.getKeywords());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_COMMENTS, summaryInformation.getComments());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_APPNAME, summaryInformation.getApplicationName());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_EDITTIME, summaryInformation.getEditTime());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_PAGECOUNT, summaryInformation.getPageCount());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_WORDCOUNT, summaryInformation.getWordCount());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_CHARCOUNT, summaryInformation.getCharCount());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_LINECOUNT, documentSummaryInformation.getLineCount());
        metadata.put(FileConst.METADATA_MICROSOFT_WORD_OLD_PARCOUNT, documentSummaryInformation.getParCount());
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftExcelOld(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        ExcelExtractor extractor = new ExcelExtractor(new HSSFWorkbook(Files.newInputStream(path)));
        SummaryInformation summaryInformation = extractor.getSummaryInformation();
        DocumentSummaryInformation documentSummaryInformation = extractor.getDocSummaryInformation();
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_OLD_TITLE, summaryInformation.getTitle());
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_OLD_CREATED, FileUtilities.getCreated(path));
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_OLD_MODIFIED, FileUtilities.getModified(path));
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_OLD_LASTACCESSTIME, FileUtilities.getLastAccessTime(path));
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_OLD_CREATOR, summaryInformation.getAuthor());
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_OLD_MODIFIER, summaryInformation.getLastAuthor());
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_OLD_APPNAME, summaryInformation.getApplicationName());
        metadata.put(FileConst.METADATA_MICROSOFT_EXCEL_OLD_DOCPARTS, documentSummaryInformation.getDocparts());
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftPowerpointOld(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        PowerPointExtractor extractor = new PowerPointExtractor(Files.newInputStream(path));
        SummaryInformation summaryInformation = extractor.getSummaryInformation();
        DocumentSummaryInformation documentSummaryInformation = extractor.getDocSummaryInformation();
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_TITLE, summaryInformation.getTitle());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_CREATED, FileUtilities.getCreated(path));
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_MODIFIED, FileUtilities.getModified(path));
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_LASTACCESSTIME, FileUtilities.getLastAccessTime(path));
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_CREATOR, summaryInformation.getAuthor());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_MODIFIER, summaryInformation.getLastAuthor());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_APPNAME, summaryInformation.getApplicationName());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_EDITTIME, summaryInformation.getEditTime());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_WORDCOUNT, summaryInformation.getWordCount());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_PRESFORMAT, documentSummaryInformation.getPresentationFormat());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_BYTECOUNT, documentSummaryInformation.getByteCount());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_PARCOUNT, documentSummaryInformation.getParCount());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_SLIDECOUNT, documentSummaryInformation.getSlideCount());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_NOTECOUNT, documentSummaryInformation.getNoteCount());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_HIDDENCOUNT, documentSummaryInformation.getHiddenCount());
        metadata.put(FileConst.METADATA_MICROSOFT_POWERPOINT_OLD_MMCLIPCOUNT, documentSummaryInformation.getMMClipCount());
        return metadata;
    }


    private Map<String, Object> getMetadataOpenDocumentText(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        Metadata tikaMetadata = getTikaMetadata(path);
        metadata.put(FileConst.METADATA_OPENDOCUMENT_TEXT_TITLE, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_TITLE));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_TEXT_CREATED, FileUtilities.getCreated(path));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_TEXT_MODIFIED, FileUtilities.getModified(path));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_TEXT_LASTACCESSTIME, FileUtilities.getLastAccessTime(path));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_TEXT_CREATOR, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_CREATOR));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_TEXT_MODIFIER, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_MODIFIER));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_TEXT_WORDCOUNT, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_WORDCOUNT));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_TEXT_CHARACTERCOUNT, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_CHARACTERCOUNT));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_TEXT_IMAGECOUNT, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_IMAGECOUNT));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_TEXT_PARCOUNT, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_PARCOUNT));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_TEXT_TABLECOUNT, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_TABLECOUNT));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_TEXT_PAGECOUNT, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_TEXT_PAGECOUNT));
        return metadata;
    }

    private Map<String, Object> getMetadataOpenDocumentSpreadsheet(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        Metadata tikaMetadata = getTikaMetadata(path);
        metadata.put(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_TITLE, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_TITLE));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_CREATED, FileUtilities.getCreated(path));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_MODIFIED, FileUtilities.getModified(path));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_LASTACCESSTIME, FileUtilities.getLastAccessTime(path));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_CREATOR, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_CREATOR));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_MODIFIER, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_SPREADSHEET_MODIFIER));
        return metadata;
    }

    private Map<String, Object> getMetadataOpenDocumentPresentation(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        Metadata tikaMetadata = getTikaMetadata(path);
        metadata.put(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_TITLE, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_TITLE));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_CREATED, FileUtilities.getCreated(path));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_MODIFIED, FileUtilities.getModified(path));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_LASTACCESSTIME, FileUtilities.getLastAccessTime(path));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_CREATOR, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_CREATOR));
        metadata.put(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_MODIFIER, tikaMetadata.get(FileConst.METADATA_OPENDOCUMENT_PRESENTATION_MODIFIER));
        return metadata;
    }

    private Map<String, Object> getMetadataMarkdown(Path path) {
        Map<String, Object> metadata = new HashMap<>();
        return metadata;
    }

    private Map<String, Object> getMetadataLatex(Path path) {
        Map<String, Object> metadata = new HashMap<>();
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

package org.protogalaxy.phss.component.file.document;

import org.apache.poi.POIXMLProperties;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hwpf.extractor.WordExtractor;
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
    private static final List<String> MICROSOFT_WORD_OLD_METADATA_LIST = Arrays.asList(
            FileConsts.METADATA_MICROSOFT_WORD_OLD_TITLE,
            FileConsts.METADATA_MICROSOFT_WORD_OLD_AUTHOR,
            FileConsts.METADATA_MICROSOFT_WORD_OLD_KEYWORDS,
            FileConsts.METADATA_MICROSOFT_WORD_OLD_COMMENTS,
            FileConsts.METADATA_MICROSOFT_WORD_OLD_LASTAUTHOR,
            FileConsts.METADATA_MICROSOFT_WORD_OLD_EDITTIME,
            FileConsts.METADATA_MICROSOFT_WORD_OLD_CREATEDTM,
            FileConsts.METADATA_MICROSOFT_WORD_OLD_LASTSAVEDTM,
            FileConsts.METADATA_MICROSOFT_WORD_OLD_PAGECOUNT,
            FileConsts.METADATA_MICROSOFT_WORD_OLD_WORDCOUNT,
            FileConsts.METADATA_MICROSOFT_WORD_OLD_CHARCOUNT
    );
    private static final List<String> MICROSOFT_WORD_METADATA_LIST = Arrays.asList(
            FileConsts.METADATA_MICROSOFT_WORD_TITLE,
            FileConsts.METADATA_MICROSOFT_WORD_CREATOR,
            FileConsts.METADATA_MICROSOFT_WORD_KEYWORDS,
            FileConsts.METADATA_MICROSOFT_WORD_CREATED,
            FileConsts.METADATA_MICROSOFT_WORD_MODIFIED,
            FileConsts.METADATA_MICROSOFT_WORD_CHARACTERS,
            FileConsts.METADATA_MICROSOFT_WORD_CHARACTERSWITHSPACES,
            FileConsts.METADATA_MICROSOFT_WORD_PAGES
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
        SummaryInformation information = extractor.getSummaryInformation();
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_TITLE, information.getTitle());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_AUTHOR, information.getAuthor());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_KEYWORDS, information.getKeywords());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_COMMENTS, information.getComments());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_LASTAUTHOR, information.getLastAuthor());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_EDITTIME, information.getEditTime());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_CREATEDTM, information.getCreateDateTime());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_LASTSAVEDTM, information.getLastSaveDateTime());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_PAGECOUNT, information.getPageCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_WORDCOUNT, information.getWordCount());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_OLD_CHARCOUNT, information.getCharCount());
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftExcelOld(Path path) throws Exception {
        return null;
    }

    private Map<String, Object> getMetadataMicroSoftPowerpointOld(Path path) {
        return null;
    }

    private Map<String, Object> getMetadataMicroSoftWord(Path path) throws Exception {
        Map<String, Object> metadata = new HashMap<>();
        XWPFWordExtractor extractor = new XWPFWordExtractor(new XWPFDocument(Files.newInputStream(path)));
        POIXMLProperties.CoreProperties coreProperties = extractor.getCoreProperties();
        POIXMLProperties.ExtendedProperties extendedProperties = extractor.getExtendedProperties();
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_TITLE, coreProperties.getTitle());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_CREATOR, coreProperties.getCreator());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_KEYWORDS, coreProperties.getKeywords());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_CREATED, coreProperties.getCreated());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_MODIFIED, coreProperties.getModified());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_CHARACTERS, extendedProperties.getCharacters());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_CHARACTERSWITHSPACES, extendedProperties.getCharactersWithSpaces());
        metadata.put(FileConsts.METADATA_MICROSOFT_WORD_PAGES, extendedProperties.getPages());
        return metadata;
    }

    private Map<String, Object> getMetadataMicroSoftExcel(Path path) {
        return null;
    }

    private Map<String, Object> getMetadataMicroSoftPowerpoint(Path path) {
        return null;
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
}

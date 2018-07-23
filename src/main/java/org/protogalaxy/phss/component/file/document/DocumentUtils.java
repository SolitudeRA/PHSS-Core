package org.protogalaxy.phss.component.file.document;

import org.protogalaxy.phss.component.file.FileCommonUtils;
import org.protogalaxy.phss.component.file.FileConsts;
import org.protogalaxy.phss.exception.component.file.ComponentFileInvalidMimeTypeException;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Component
public class DocumentUtils {
    private FileCommonUtils fileCommonUtils;

    public DocumentUtils(FileCommonUtils fileCommonUtils) {
        this.fileCommonUtils = fileCommonUtils;
    }

    public Map<String, String> getDocumentMetadata(Path path) {
        Map<String, String> metadata = new HashMap<>();
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

    private Map<String, String> getMetadataAdobePdf(Path path) {
        return null;
    }

    private Map<String, String> getMetadataAdobeIndesign(Path path) {
        return null;
    }

    private Map<String, String> getMetadataAdobePhotoshop(Path path) {
        return null;
    }

    private Map<String, String> getMetadataAdobeIllustrator(Path path) {
        return null;
    }

    private Map<String, String> getMetadataMicroSoftWordOld(Path path) {
        return null;
    }

    private Map<String, String> getMetadataMicroSoftExcelOld(Path path) {
        return null;
    }

    private Map<String, String> getMetadataMicroSoftPowerpointOld(Path path) {
        return null;
    }

    private Map<String, String> getMetadataMicroSoftWord(Path path) {
        return null;
    }

    private Map<String, String> getMetadataMicroSoftExcel(Path path) {
        return null;
    }

    private Map<String, String> getMetadataMicroSoftPowerpoint(Path path) {
        return null;
    }

    private Map<String, String> getMetadataOpenDocumentPresentation(Path path) {
        return null;
    }

    private Map<String, String> getMetadataOpenDocumentSpreadsheet(Path path) {
        return null;
    }

    private Map<String, String> getMetadataOpenDocumentText(Path path) {
        return null;
    }

    private Map<String, String> getMetadataMarkdown(Path path) {
        return null;
    }

    private Map<String, String> getMetadataLatex(Path path) {
        return null;
    }
}

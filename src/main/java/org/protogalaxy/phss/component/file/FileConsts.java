package org.protogalaxy.phss.component.file;


import java.util.Arrays;
import java.util.List;

public final class FileConsts {
    //Document MIME types
    public static final String
            MIME_ADOBE_PDF = "application/pdf",
            MIME_ADOBE_PHOTOSHOP = "image/vnd.adobe.photoshop",
            MIME_MICROSOFT_WORD_OLD = "application/msword",
            MIME_MICROSOFT_EXCEL_OLD = "application/vnd.ms-excel",
            MIME_MICROSOFT_POWERPOINT_OLD = "application/vnd.ms-powerpoint",
            MIME_MICROSOFT_WORD = "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            MIME_MICROSOFT_EXCEL = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
            MIME_MICROSOFT_POWERPOINT = "application/vnd.openxmlformats-officedocument.presentationml.presentation",
            MIME_OPENDOCUMENT_PRESENTATION = "application/vnd.oasis.opendocument.presentation",
            MIME_OPENDOCUMENT_SPREADSHEET = "application/vnd.oasis.opendocument.spreadsheet",
            MIME_OPENDOCUMENT_TEXT = "application/vnd.oasis.opendocument.text",
            MIME_MARKDOWN = "text/markdown",
            MIME_LATEX = "application/x-latex",
            MIME_EBOOK_IBOOKS = "application/x-ibooks+zip",
            MIME_EBOOK_EPUB = "application/epub+zip";
    //Audio metadata string
    public static final String
            METADATA_AUDIO_TITLE = "title",
            METADATA_AUDIO_ALBUM = "album",
            METADATA_AUDIO_ARTIST = "artist",
            METADATA_AUDIO_ALBUMARTIST = "album_artist",
            METADATA_AUDIO_COMPOSER = "composer",
            METADATA_AUDIO_PERFORMER = "performer",
            METADATA_AUDIO_DATE = "date",
            METADATA_AUDIO_TRACK = "track",
            METADATA_AUDIO_DISC = "disc",
            METADATA_AUDIO_GENRE = "genre",
            METADATA_AUDIO_PUBLISHER = "publisher",
            METADATA_AUDIO_COMMENT = "comment",
            METADATA_AUDIO_DURATION = "duration",
            METADATA_AUDIO_BITRATE = "bitrate",
            METADATA_AUDIO_SAMPLERATE = "sample_rate",
            METADATA_AUDIO_BITDEPTH = "bit_depth",
            METADATA_AUDIO_SIZE = "size",
            METADATA_AUDIO_COVER = "cover";
    //Document metadata string
    public static final String
            METADATA_ADOBE_PDF_TITLE = "title",
            METADATA_ADOBE_PDF_VERSION = "pdf:PDFVersion",
            METADATA_ADOBE_PDF_AUTHOR = "Author",
            METADATA_ADOBE_PDF_PRODUCER = "producer",
            METADATA_ADOBE_PDF_CREATED = "created",
            METADATA_ADOBE_PDF_MODIFIED = "modified";
    public static final String
            METADATA_ADOBE_PHOTOSHOP_TITLE = "title",
            METADATA_ADOBE_PHOTOSHOP_WIDTH = "tiff:ImageWidth",
            METADATA_ADOBE_PHOTOSHOP_HEIGHT = "tiff:ImageLength",
            METADATA_ADOBE_PHOTOSHOP_COLORMODE = "photoshop:ColorMode",
            METADATA_ADOBE_PHOTOSHOP_BITSPERSAMPLE = "tiff:BitsPerSample";
    public static final String
            METADATA_MICROSOFT_WORD_OLD_TITLE = "title",
            METADATA_MICROSOFT_WORD_OLD_AUTHOR = "author",
            METADATA_MICROSOFT_WORD_OLD_KEYWORDS = "keywords",
            METADATA_MICROSOFT_WORD_OLD_COMMENTS = "comments",
            METADATA_MICROSOFT_WORD_OLD_LASTAUTHOR = "last_author",
            METADATA_MICROSOFT_WORD_OLD_APPNAME = "app_name",
            METADATA_MICROSOFT_WORD_OLD_EDITTIME = "edit_time",
            METADATA_MICROSOFT_WORD_OLD_CREATEDTM = "create_dtm",
            METADATA_MICROSOFT_WORD_OLD_LASTSAVEDTM = "last_save_dtm",
            METADATA_MICROSOFT_WORD_OLD_PAGECOUNT = "page_count",
            METADATA_MICROSOFT_WORD_OLD_WORDCOUNT = "word_count",
            METADATA_MICROSOFT_WORD_OLD_CHARCOUNT = "char_count",
            METADATA_MICROSOFT_WORD_OLD_LINECOUNT = "line_count",
            METADATA_MICROSOFT_WORD_OLD_PARCOUNT = "par_count";
    public static final String
            METADATA_MICROSOFT_EXCEL_OLD_AUTHOR = "author",
            METADATA_MICROSOFT_EXCEL_OLD_LASTAUTHOR = "last_author",
            METADATA_MICROSOFT_EXCEL_OLD_APPNAME = "app_name",
            METADATA_MICROSOFT_EXCEL_OLD_CREATEDTM = "create_dtm",
            METADATA_MICROSOFT_EXCEL_OLD_LASTSAVEDTM = "last_save_dtm",
            METADATA_MICROSOFT_EXCEL_OLD_DOCPARTS="doc_parts";
    public static final String
            METADATA_MICROSOFT_POWERPOINT_OLD_TITLE = "title",
            METADATA_MICROSOFT_POWERPOINT_OLD_AUTHOR = "author",
            METADATA_MICROSOFT_POWERPOINT_OLD_LASTAUTHOR = "last_author",
            METADATA_MICROSOFT_POWERPOINT_OLD_APPNAME = "app_name",
            METADATA_MICROSOFT_POWERPOINT_OLD_EDITTIME = "edit_time",
            METADATA_MICROSOFT_POWERPOINT_OLD_CREATEDTM = "create_dtm",
            METADATA_MICROSOFT_POWERPOINT_OLD_LASTSAVEDTM = "last_save_dtm",
            METADATA_MICROSOFT_POWERPOINT_OLD_WORDCOUNT = "word_count",
            METADATA_MICROSOFT_POWERPOINT_OLD_PRESFORMAT = "present_format",
            METADATA_MICROSOFT_POWERPOINT_OLD_BYTECOUNT = "byte_count",
            METADATA_MICROSOFT_POWERPOINT_OLD_PARCOUNT = "part_count",
            METADATA_MICROSOFT_POWERPOINT_OLD_SLIDECOUNT = "slide_count",
            METADATA_MICROSOFT_POWERPOINT_OLD_NOTECOUNT = "note_count",
            METADATA_MICROSOFT_POWERPOINT_OLD_HIDDENCOUNT = "hidden_count",
            METADATA_MICROSOFT_POWERPOINT_OLD_MMCLIPCOUNT = "mmclip_count";
    public static final String
            METADATA_MICROSOFT_WORD_TITLE = "title",
            METADATA_MICROSOFT_WORD_CREATOR = "creator",
            METADATA_MICROSOFT_WORD_APPLICATION = "application",
            METADATA_MICROSOFT_WORD_APPVERSION = "app_version",
            METADATA_MICROSOFT_WORD_CREATED = "created",
            METADATA_MICROSOFT_WORD_MODIFIED = "modified",
            METADATA_MICROSOFT_WORD_LASTMODIFIEDBY = "last_modified_by",
            METADATA_MICROSOFT_WORD_CHARACTERS = "characters",
            METADATA_MICROSOFT_WORD_CHARACTERSWITHSPACES = "characters_with_space",
            METADATA_MICROSOFT_WORD_LINES = "lines",
            METADATA_MICROSOFT_WORD_PAGES = "pages",
            METADATA_MICROSOFT_WORD_PARAGRAPHS = "paragraphs";
    public static final String
            METADATA_MICROSOFT_EXCEL_APPLICATION = "application",
            METADATA_MICROSOFT_EXCEL_APPVERSION = "app_version",
            METADATA_MICROSOFT_EXCEL_CREATED = "created",
            METADATA_MICROSOFT_EXCEL_MODIFIED = "modified",
            METADATA_MICROSOFT_EXCEL_CHARACTERS = "characters",
            METADATA_MICROSOFT_EXCEL_CHARACTERSWITHSPACES = "characters_with_spaces",
            METADATA_MICROSOFT_EXCEL_LINES = "lines",
            METADATA_MICROSOFT_EXCEL_PAGES = "pages",
            METADATA_MICROSOFT_EXCEL_PARAGRAPHS = "paragraphs";
    public static final String
            METADATA_MICROSOFT_POWERPOINT_TITLE = "title",
            METADATA_MICROSOFT_POWERPOINT_APPLICATION = "application",
            METADATA_MICROSOFT_POWERPOINT_APPVERSION = "app_version",
            METADATA_MICROSOFT_POWERPOINT_CREATOR = "creator",
            METADATA_MICROSOFT_POWERPOINT_LASTMODIFIEDBY = "last_modified_by",
            METADATA_MICROSOFT_POWERPOINT_MODIFIED = "modified",
            METADATA_MICROSOFT_POWERPOINT_CHARACTERS = "characters",
            METADATA_MICROSOFT_POWERPOINT_CHARACTERSWITHSPACES = "characters_with_spaces",
            METADATA_MICROSOFT_POWERPOINT_LINES = "lines",
            METADATA_MICROSOFT_POWERPOINT_PAGES = "pages",
            METADATA_MICROSOFT_POWERPOINT_PARAGRAPHS = "paragraphs",
            METADATA_MICROSOFT_POWERPOINT_PRESENTATIONFORMAT = "presentation_format";
    //Audio metadata lists
    public static List<String> METADATA_AUDIO_STANDARD_LIST = Arrays.asList(
            METADATA_AUDIO_TITLE,
            METADATA_AUDIO_ALBUM,
            METADATA_AUDIO_ARTIST,
            METADATA_AUDIO_ALBUMARTIST,
            METADATA_AUDIO_COMPOSER,
            METADATA_AUDIO_PERFORMER,
            METADATA_AUDIO_DATE,
            METADATA_AUDIO_TRACK,
            METADATA_AUDIO_DISC,
            METADATA_AUDIO_GENRE,
            METADATA_AUDIO_PUBLISHER,
            METADATA_AUDIO_COMMENT
    );
    public static List<String> METADATA_AUDIO_FULL_LIST = Arrays.asList(
            METADATA_AUDIO_TITLE,
            METADATA_AUDIO_ALBUM,
            METADATA_AUDIO_ARTIST,
            METADATA_AUDIO_ALBUMARTIST,
            METADATA_AUDIO_COMPOSER,
            METADATA_AUDIO_PERFORMER,
            METADATA_AUDIO_DATE,
            METADATA_AUDIO_TRACK,
            METADATA_AUDIO_DISC,
            METADATA_AUDIO_GENRE,
            METADATA_AUDIO_PUBLISHER,
            METADATA_AUDIO_COMMENT,
            METADATA_AUDIO_DURATION,
            METADATA_AUDIO_BITRATE,
            METADATA_AUDIO_SAMPLERATE,
            METADATA_AUDIO_BITDEPTH,
            METADATA_AUDIO_SIZE,
            METADATA_AUDIO_COVER
    );
    //Document metadata Lists
    public static final List<String> ADOBE_PDF_METADATA_LIST = Arrays.asList(
            METADATA_ADOBE_PDF_TITLE,
            METADATA_ADOBE_PDF_VERSION,
            METADATA_ADOBE_PDF_AUTHOR,
            METADATA_ADOBE_PDF_PRODUCER,
            METADATA_ADOBE_PDF_CREATED,
            METADATA_ADOBE_PDF_MODIFIED
    );
    public static final List<String> ADOBE_PHOTOSHOP_METADATA_LIST = Arrays.asList(
            METADATA_ADOBE_PHOTOSHOP_TITLE,
            METADATA_ADOBE_PHOTOSHOP_WIDTH,
            METADATA_ADOBE_PHOTOSHOP_HEIGHT,
            METADATA_ADOBE_PHOTOSHOP_COLORMODE,
            METADATA_ADOBE_PHOTOSHOP_BITSPERSAMPLE
    );
    public static final List<String> MICROSOFT_WORD_OLD_METADATA_LIST = Arrays.asList(
            METADATA_MICROSOFT_WORD_OLD_TITLE,
            METADATA_MICROSOFT_WORD_OLD_AUTHOR,
            METADATA_MICROSOFT_WORD_OLD_KEYWORDS,
            METADATA_MICROSOFT_WORD_OLD_COMMENTS,
            METADATA_MICROSOFT_WORD_OLD_LASTAUTHOR,
            METADATA_MICROSOFT_WORD_OLD_APPNAME,
            METADATA_MICROSOFT_WORD_OLD_EDITTIME,
            METADATA_MICROSOFT_WORD_OLD_CREATEDTM,
            METADATA_MICROSOFT_WORD_OLD_LASTSAVEDTM,
            METADATA_MICROSOFT_WORD_OLD_PAGECOUNT,
            METADATA_MICROSOFT_WORD_OLD_WORDCOUNT,
            METADATA_MICROSOFT_WORD_OLD_CHARCOUNT,
            METADATA_MICROSOFT_WORD_OLD_LINECOUNT,
            METADATA_MICROSOFT_WORD_OLD_PARCOUNT
    );
    public static final List<String> MICROSOFT_EXCEL_OLD_METADATA_LIST = Arrays.asList(
            METADATA_MICROSOFT_EXCEL_OLD_AUTHOR,
            METADATA_MICROSOFT_EXCEL_OLD_LASTAUTHOR,
            METADATA_MICROSOFT_EXCEL_OLD_APPNAME,
            METADATA_MICROSOFT_EXCEL_OLD_CREATEDTM,
            METADATA_MICROSOFT_EXCEL_OLD_LASTSAVEDTM,
            METADATA_MICROSOFT_EXCEL_OLD_DOCPARTS
    );
    public static final List<String> MICROSOFT_POWERPOINT_OLD_METADATA_LIST = Arrays.asList(
            METADATA_MICROSOFT_POWERPOINT_OLD_TITLE,
            METADATA_MICROSOFT_POWERPOINT_OLD_AUTHOR,
            METADATA_MICROSOFT_POWERPOINT_OLD_LASTAUTHOR,
            METADATA_MICROSOFT_POWERPOINT_OLD_APPNAME,
            METADATA_MICROSOFT_POWERPOINT_OLD_EDITTIME,
            METADATA_MICROSOFT_POWERPOINT_OLD_CREATEDTM,
            METADATA_MICROSOFT_POWERPOINT_OLD_LASTSAVEDTM,
            METADATA_MICROSOFT_POWERPOINT_OLD_WORDCOUNT,
            METADATA_MICROSOFT_POWERPOINT_OLD_PRESFORMAT,
            METADATA_MICROSOFT_POWERPOINT_OLD_BYTECOUNT,
            METADATA_MICROSOFT_POWERPOINT_OLD_PARCOUNT,
            METADATA_MICROSOFT_POWERPOINT_OLD_SLIDECOUNT,
            METADATA_MICROSOFT_POWERPOINT_OLD_NOTECOUNT,
            METADATA_MICROSOFT_POWERPOINT_OLD_HIDDENCOUNT,
            METADATA_MICROSOFT_POWERPOINT_OLD_MMCLIPCOUNT
    );
    public static final List<String> MICROSOFT_WORD_METADATA_LIST = Arrays.asList(
            METADATA_MICROSOFT_WORD_TITLE,
            METADATA_MICROSOFT_WORD_CREATOR,
            METADATA_MICROSOFT_WORD_APPLICATION,
            METADATA_MICROSOFT_WORD_APPVERSION,
            METADATA_MICROSOFT_WORD_CREATED,
            METADATA_MICROSOFT_WORD_MODIFIED,
            METADATA_MICROSOFT_WORD_LASTMODIFIEDBY,
            METADATA_MICROSOFT_WORD_CHARACTERS,
            METADATA_MICROSOFT_WORD_CHARACTERSWITHSPACES,
            METADATA_MICROSOFT_WORD_LINES,
            METADATA_MICROSOFT_WORD_PAGES,
            METADATA_MICROSOFT_WORD_PARAGRAPHS
    );
    public static final List<String> MICROSOFT_EXCEL_METADATA_LIST = Arrays.asList(
            METADATA_MICROSOFT_EXCEL_APPLICATION,
            METADATA_MICROSOFT_EXCEL_APPVERSION,
            METADATA_MICROSOFT_EXCEL_CREATED,
            METADATA_MICROSOFT_EXCEL_MODIFIED,
            METADATA_MICROSOFT_EXCEL_CHARACTERS,
            METADATA_MICROSOFT_EXCEL_CHARACTERSWITHSPACES,
            METADATA_MICROSOFT_EXCEL_LINES,
            METADATA_MICROSOFT_EXCEL_PAGES,
            METADATA_MICROSOFT_EXCEL_PARAGRAPHS
    );
    public static final List<String> MICROSOFT_POWERPOINT_METADATA_LIST = Arrays.asList(
            METADATA_MICROSOFT_POWERPOINT_TITLE,
            METADATA_MICROSOFT_POWERPOINT_APPLICATION,
            METADATA_MICROSOFT_POWERPOINT_APPVERSION,
            METADATA_MICROSOFT_POWERPOINT_CREATOR,
            METADATA_MICROSOFT_POWERPOINT_LASTMODIFIEDBY,
            METADATA_MICROSOFT_POWERPOINT_MODIFIED,
            METADATA_MICROSOFT_POWERPOINT_CHARACTERS,
            METADATA_MICROSOFT_POWERPOINT_CHARACTERSWITHSPACES,
            METADATA_MICROSOFT_POWERPOINT_LINES,
            METADATA_MICROSOFT_POWERPOINT_PAGES,
            METADATA_MICROSOFT_POWERPOINT_PARAGRAPHS,
            METADATA_MICROSOFT_POWERPOINT_PRESENTATIONFORMAT
    );
}

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
            METADATA_MICROSOFT_OFFICE_OLD_TITLE = "title",
            METADATA_MICROSOFT_OFFICE_OLD_AUTHOR = "author",
            METADATA_MICROSOFT_OFFICE_OLD_KEYWORDS = "keywords",
            METADATA_MICROSOFT_OFFICE_OLD_COMMENTS = "comments",
            METADATA_MICROSOFT_OFFICE_OLD_LASTAUTHOR = "last_author",
            METADATA_MICROSOFT_OFFICE_OLD_EDITTIME = "edit_time",
            METADATA_MICROSOFT_OFFICE_OLD_CREATED = "create_dtm",
            METADATA_MICROSOFT_OFFICE_OLD_LASTSAVEDTM = "last_save_dtm",
            METADATA_MICROSOFT_OFFICE_OLD_PAGECOUNT = "page_count",
            METADATA_MICROSOFT_OFFICE_OLD_WORDCOUNT = "word_count",
            METADATA_MICROSOFT_OFFICE_OLD_CHARCOUNT = "char_count";
    public static final String
            METADATA_MICROSOFT_OFFICE_TITLE = "title",
            METADATA_MICROSOFT_OFFICE_CREATOR = "creator",
            METADATA_MICROSOFT_OFFICE_KEYWORDS = "keywords",
            METADATA_MICROSOFT_OFFICE_CREATED = "created",
            METADATA_MICROSOFT_OFFICE_MODIFIED = "modified",
            METADATA_MICROSOFT_OFFICE_CHARACTERS = "characters",
            METADATA_MICROSOFT_OFFICE_CHARACTERSWITHSPACES = "characters_with_space",
            METADATA_MICROSOFT_OFFICE_PAGES = "pages";
    //Metadata Lists
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
    public static final List<String> MICROSOFT_OFFICE_OLD_METADATA_LIST = Arrays.asList(
            METADATA_MICROSOFT_OFFICE_OLD_TITLE,
            METADATA_MICROSOFT_OFFICE_OLD_AUTHOR,
            METADATA_MICROSOFT_OFFICE_OLD_KEYWORDS,
            METADATA_MICROSOFT_OFFICE_OLD_COMMENTS,
            METADATA_MICROSOFT_OFFICE_OLD_LASTAUTHOR,
            METADATA_MICROSOFT_OFFICE_OLD_EDITTIME,
            METADATA_MICROSOFT_OFFICE_OLD_CREATED,
            METADATA_MICROSOFT_OFFICE_OLD_LASTSAVEDTM,
            METADATA_MICROSOFT_OFFICE_OLD_PAGECOUNT,
            METADATA_MICROSOFT_OFFICE_OLD_WORDCOUNT,
            METADATA_MICROSOFT_OFFICE_OLD_CHARCOUNT
    );
    public static final List<String> MICROSOFT_OFFICE_METADATA_LIST = Arrays.asList(
            METADATA_MICROSOFT_OFFICE_TITLE,
            METADATA_MICROSOFT_OFFICE_CREATOR,
            METADATA_MICROSOFT_OFFICE_KEYWORDS,
            METADATA_MICROSOFT_OFFICE_CREATED,
            METADATA_MICROSOFT_OFFICE_MODIFIED,
            METADATA_MICROSOFT_OFFICE_CHARACTERS,
            METADATA_MICROSOFT_OFFICE_CHARACTERSWITHSPACES,
            METADATA_MICROSOFT_OFFICE_PAGES
    );
}

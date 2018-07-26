package org.protogalaxy.phss.component.file;


import java.util.Arrays;
import java.util.List;

public final class FileConsts {
    //Document MIME types
    public static final String
            MIME_ADOBE_PDF = "application/pdf",
            MIME_ADOBE_INDESIGN = "application/x-indesign",
            MIME_ADOBE_PHOTOSHOP = "application/photoshop",
            MIME_ADOBE_ILLUSTRATOR = "application/illustrator",
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
            MIME_LATEX = "application/x-latex";
    //Document metadata string
    public static final String
            METADATA_DOCUMENT_AUTHOR = "author";
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
    //Audio metadata list
    public static final List<String>
            METADATA_AUDIO_STANDARD_LIST = Arrays.asList(
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
    ), METADATA_AUDIO_FULL_LIST = Arrays.asList(
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
}

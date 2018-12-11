package org.protogalaxy.phss.component.consts;

import java.util.Arrays;
import java.util.List;

public final class AudioConsts {
    public static final String
            METADATA_AUDIO_TITLE = "title",
            METADATA_AUDIO_ALBUM = "album",
            METADATA_AUDIO_ARTIST = "artist",
            METADATA_AUDIO_ALBUMARTIST = "album_artist",
            METADATA_AUDIO_COMPOSER = "composer",
            METADATA_AUDIO_RELEASE_YEAR = "date",
            METADATA_AUDIO_TRACK = "track",
            METADATA_AUDIO_DISC = "disc",
            METADATA_AUDIO_GENRE = "genre",
            METADATA_AUDIO_COMMENT = "comment",
            METADATA_AUDIO_DURATION = "duration",
            METADATA_AUDIO_BITRATE = "bitrate",
            METADATA_AUDIO_SAMPLERATE = "sample_rate",
            METADATA_AUDIO_BITDEPTH = "bit_depth",
            METADATA_AUDIO_SIZE = "size",
            METADATA_AUDIO_ARTWORK = "cover",
            METADATA_AUDIO_MD5 = "md5",
            METADATA_AUDIO_KIND = "kind";

    public static List<String> METADATA_AUDIO_STANDARD_LIST = Arrays.asList(
            METADATA_AUDIO_TITLE,
            METADATA_AUDIO_ALBUM,
            METADATA_AUDIO_ARTIST,
            METADATA_AUDIO_ALBUMARTIST,
            METADATA_AUDIO_COMPOSER,
            METADATA_AUDIO_RELEASE_YEAR,
            METADATA_AUDIO_TRACK,
            METADATA_AUDIO_DISC,
            METADATA_AUDIO_GENRE,
            METADATA_AUDIO_COMMENT
    );
    public static List<String> METADATA_AUDIO_FULL_LIST = Arrays.asList(
            METADATA_AUDIO_TITLE,
            METADATA_AUDIO_ALBUM,
            METADATA_AUDIO_ARTIST,
            METADATA_AUDIO_ALBUMARTIST,
            METADATA_AUDIO_COMPOSER,
            METADATA_AUDIO_RELEASE_YEAR,
            METADATA_AUDIO_TRACK,
            METADATA_AUDIO_DISC,
            METADATA_AUDIO_GENRE,
            METADATA_AUDIO_COMMENT,
            METADATA_AUDIO_DURATION,
            METADATA_AUDIO_BITRATE,
            METADATA_AUDIO_SAMPLERATE,
            METADATA_AUDIO_BITDEPTH,
            METADATA_AUDIO_SIZE,
            METADATA_AUDIO_ARTWORK,
            METADATA_AUDIO_MD5,
            METADATA_AUDIO_KIND
    );
}

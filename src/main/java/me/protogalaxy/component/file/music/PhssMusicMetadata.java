package me.protogalaxy.component.file.music;

import org.bytedeco.javacpp.*;

import static org.bytedeco.javacpp.avcodec.*;
import static org.bytedeco.javacpp.avformat.*;
import static org.bytedeco.javacpp.avutil.*;
import static org.bytedeco.javacpp.swscale.*;

import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;


@Component
public class PhssMusicMetadata {
    private List<String> metadataList = Arrays.asList("title", "album", "artist", "album_artist", "genre", "composer", "track", "disc", "bitrate", "comment");

    public Map<String, Object> getMetaData(Path path) {
        av_register_all();
        Map<String, Object> metadataFullMap = new HashMap<>();
        Map<String, Object> metadataCurrentMap = new HashMap<>();
        AVFormatContext avFormatContext = avformat_alloc_context();
        AVDictionaryEntry entry = null;
        avformat_open_input(avFormatContext, path.toString(), null, null);
        avformat_find_stream_info(avFormatContext, ((PointerPointer) null));
        while ((entry = av_dict_get(avFormatContext.metadata(), "", entry, AV_DICT_IGNORE_SUFFIX)) != null) {
            metadataFullMap.put(entry.key().getString(), entry.value().getString());
        }
        for (String key : metadataList) {
            metadataCurrentMap.put(key, metadataFullMap.get(key));
        }
        avformat_close_input(avFormatContext);
        return metadataCurrentMap;
    }

    //TODO: Artwork getter
    public byte[] getArtwork(Path path) {
        av_register_all();
        AVFormatContext avFormatContext = avformat_alloc_context();
        avformat_open_input(avFormatContext, path.toString(), null, null);
        avFormatContext.streams(1);
        //avformat_find_stream_info()
        return null;
    }

    private String getDuration(long duration) {
        long secs, us;
        secs = (duration / AV_TIME_BASE);
        us = (1000 * (duration % AV_TIME_BASE)) / AV_TIME_BASE;
        long totalus = 1000 * secs + us;
        SimpleDateFormat format = new SimpleDateFormat("mm:ss:SSS");
        return format.format(totalus);
    }

    private String getBitrate(long bitrate) {
        return String.valueOf(bitrate / 1000) + " kbps";
    }
}

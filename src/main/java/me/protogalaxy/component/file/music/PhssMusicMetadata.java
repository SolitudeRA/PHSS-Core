package me.protogalaxy.component.file.music;

import static org.bytedeco.javacpp.avformat.*;
import static org.bytedeco.javacpp.avutil.*;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;


@Component
public class PhssMusicMetadata {
    private List<String> metadataList = Arrays.asList("title", "album", "artist", "album_artist", "genre", "composer", "track", "disc", "variant_bitrate", "comment");

    public Map<String, String> getMetaData(MultipartFile musicFile) {
        Map<String, Object> metadata = new HashMap<>();
        av_register_all();
        AVFormatContext avFormatContext = avformat_alloc_context();
        AVDictionaryEntry dictionaryEntry = new AVDictionaryEntry();
    }
}

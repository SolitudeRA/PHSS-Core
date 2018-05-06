package me.protogalaxy.test.ffmpeg;

import org.bytedeco.javacpp.*;

import static org.bytedeco.javacpp.avcodec.*;
import static org.bytedeco.javacpp.avformat.*;
import static org.bytedeco.javacpp.avutil.*;
import static org.bytedeco.javacpp.swscale.*;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;


public class ffmpegtest {
    @Disabled
    @Test
    public void singleMetadataTest() {
        av_register_all();
        AVFormatContext avFormatContext = avformat_alloc_context();
        avformat_open_input(avFormatContext, "phssStorage/Alpha/test.aiff", null, null);
        AVDictionaryEntry avDictionaryEntry = av_dict_get(avFormatContext.metadata(), "artist", null, AV_DICT_IGNORE_SUFFIX);
        System.out.println(avFormatContext);
        System.out.println(avDictionaryEntry);
        System.out.println(avDictionaryEntry.value().getString());
        avformat_close_input(avFormatContext);
    }

    @Test
    public void multiMetadataTest() {
        av_register_all();
        AVFormatContext avFormatContext = avformat_alloc_context();
        avformat_open_input(avFormatContext, "phssStorage/Alpha/test.aiff", null, null);
        AVDictionaryEntry avDictionaryEntry = null;
        while ((avDictionaryEntry = av_dict_get(avFormatContext.metadata(), "", avDictionaryEntry, AV_DICT_IGNORE_SUFFIX)) != null) {
            System.out.println(avDictionaryEntry.key().getString());
            System.out.println(avDictionaryEntry.value().getString());
        }
    }
}

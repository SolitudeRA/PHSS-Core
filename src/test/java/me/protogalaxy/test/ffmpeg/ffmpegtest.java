package me.protogalaxy.test.ffmpeg;

import me.protogalaxy.component.file.music.PhssMusicMetadata;
import org.bytedeco.javacpp.*;

import static org.bytedeco.javacpp.avcodec.*;
import static org.bytedeco.javacpp.avformat.*;
import static org.bytedeco.javacpp.avutil.*;
import static org.bytedeco.javacpp.swscale.*;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ffmpegtest {
    @Autowired
    PhssMusicMetadata phssMusicMetadata;

    @Test
    public void singleMetadataTest() {
        av_register_all();
        AVFormatContext avFormatContext = avformat_alloc_context();
        avformat_open_input(avFormatContext, "phssStorage/Alpha/test.aiff", null, null);
        avformat_find_stream_info(avFormatContext, (PointerPointer) null);
        long secs, us;
        secs = (avFormatContext.duration() / AV_TIME_BASE);
        us = (1000 * (avFormatContext.duration() % AV_TIME_BASE)) / AV_TIME_BASE;
        long totalus = 1000 * secs + us;
        SimpleDateFormat format = new SimpleDateFormat("mm:ss:SSS");
        System.out.println(format.format(totalus));
        System.out.println(String.valueOf(avFormatContext.bit_rate() / 1000) + "kbps");
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
        avformat_close_input(avFormatContext);
    }

    @Test
    public void dumpFormatTest() {
        av_register_all();
        AVFormatContext avFormatContext = avformat_alloc_context();
        avformat_open_input(avFormatContext, "phssStorage/Alpha/test.aiff", null, null);
        avformat_find_stream_info(avFormatContext, (PointerPointer) null);
        av_dump_format(avFormatContext, 0, "", 0);
        avformat_close_input(avFormatContext);
    }

    @Test
    public void metadataTest() {
        Path path = Paths.get("phssStorage/Alpha/test.aiff");
        System.out.println(phssMusicMetadata.getMetaData(path));
    }

    @Test
    public void artworkTest() {
        av_register_all();
        AVFormatContext avFormatContext = avformat_alloc_context();
        AVDictionary avDictionary = null;
        AVCodecContext avCodecContext = null;
        AVCodec avCodec = null;
        AVPacket packet = av_packet_alloc();
        AVFrame frame = av_frame_alloc();
        avformat_open_input(avFormatContext, "phssStorage/Alpha/test.aiff", null, null);
        avformat_find_stream_info(avFormatContext, (PointerPointer) null);
        avCodecContext = avFormatContext.streams(1).codec();
        avCodec = avcodec_find_decoder(avCodecContext.codec_id());
        av_read_frame(avFormatContext, packet);
    }
}

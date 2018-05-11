package me.protogalaxy.test.ffmpeg;

import me.protogalaxy.component.file.music.PhssMusicMetadata;
import org.bytedeco.javacpp.*;

import static org.bytedeco.javacpp.avcodec.*;
import static org.bytedeco.javacpp.avformat.*;
import static org.bytedeco.javacpp.avutil.*;
import static org.bytedeco.javacpp.swscale.*;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

@SpringBootTest
@RunWith(SpringRunner.class)
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
        System.out.println(avFormatContext.streams(0).codecpar().sample_rate());
        System.out.println(avFormatContext.streams(0).codecpar().bits_per_coded_sample());
        System.out.println(avFormatContext.streams(0).codecpar().bits_per_raw_sample());
        System.out.println(Paths.get("phssStorage/Alpha/test.aiff").toFile().length());
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
    public void metadataTest() throws Exception{
        Path path = Paths.get("phssStorage/Alpha/test.aiff");
        System.out.println(phssMusicMetadata.getMetaData(path));
    }

    @Test
    public void artworkTest() throws FrameGrabber.Exception {
        File file = new File("phssStorage/Alpha/test.mp3");
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(file);
        grabber.start();
        Frame frame = grabber.grabImage();
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage bufferedImage = converter.getBufferedImage(frame);
        try {
            ImageIO.write(bufferedImage, "png", new File("test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

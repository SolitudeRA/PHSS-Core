package me.protogalaxy.component.file.music;

import org.bytedeco.javacpp.*;

import static org.bytedeco.javacpp.avcodec.*;
import static org.bytedeco.javacpp.avformat.*;
import static org.bytedeco.javacpp.avutil.*;
import static org.bytedeco.javacpp.swscale.*;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


@Component
public class PhssMusicMetadata {
    private List<String> metadataList = Arrays.asList("title", "album", "artist", "album_artist", "date", "genre", "composer", "track", "disc", "bitrate", "comment");

    public Map<String, Object> getMetaData(Path path) throws Exception {
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
            if (metadataFullMap.get(key) != null) {
                metadataCurrentMap.put(key, metadataFullMap.get(key));
            } else {
                metadataCurrentMap.put(key, "");
            }
        }
        metadataCurrentMap.put("duration", formatDuration(avFormatContext.duration()));
        metadataCurrentMap.put("bitrate", formatBitrate(avFormatContext.streams(0).codecpar().bit_rate()));
        metadataCurrentMap.put("sample_rate", avFormatContext.streams(0).codecpar().sample_rate());
        metadataCurrentMap.put("bit_depth", avFormatContext.streams(0).codecpar().bits_per_raw_sample());
        metadataCurrentMap.put("artwork", getArtwork(path));
        metadataCurrentMap.put("size", formatSize(path.toFile().length()));
        avformat_close_input(avFormatContext);
        return metadataCurrentMap;
    }

    private byte[] getArtwork(Path path) throws Exception {
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(path.toFile());
        Java2DFrameConverter converter = new Java2DFrameConverter();
        grabber.start();
        BufferedImage bufferedImage = converter.getBufferedImage(grabber.grabImage());
        grabber.close();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, ".png", outputStream);
        return outputStream.toByteArray();
    }

    private String formatDuration(long duration) {
        long secs, us;
        secs = (duration / AV_TIME_BASE);
        us = (1000 * (duration % AV_TIME_BASE)) / AV_TIME_BASE;
        long totalus = 1000 * secs + us;
        SimpleDateFormat format = new SimpleDateFormat("mm:ss:SSS");
        return format.format(totalus);
    }

    private String formatBitrate(long bitrate) {
        return String.valueOf(bitrate / 1000) + " kbps";
    }

    private String formatSize(long size) {
        if (size < 1024) {
            return String.valueOf(size) + "B";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            return String.valueOf(size) + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            size = size * 100;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "MB";
        } else {
            size = size * 100 / 1024;
            return String.valueOf((size / 100)) + "."
                    + String.valueOf((size % 100)) + "GB";
        }
    }
}

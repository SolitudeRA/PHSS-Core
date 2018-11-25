package org.protogalaxy.phss.component.utils;

import java.text.SimpleDateFormat;

import static org.bytedeco.javacpp.avutil.AV_TIME_BASE;

public class MultimediaUtils {
    /**
     * Format track duration string
     *
     * @param duration duration og the track
     * @return String format duration of the track
     */
    public static String formatDuration(long duration) {
        long secs, us;
        secs = (duration / AV_TIME_BASE);
        us = (1000 * (duration % AV_TIME_BASE)) / AV_TIME_BASE;
        long totalus = 1000 * secs + us;
        SimpleDateFormat format = new SimpleDateFormat("mm:ss:SSS");
        return format.format(totalus);
    }

    /**
     * Format track bitrate
     *
     * @param bitrate bitrate of the track
     * @return String format bitrate
     */
    public static String formatBitrate(long bitrate) {
        return String.valueOf(bitrate / 1000) + " kbps";
    }

}

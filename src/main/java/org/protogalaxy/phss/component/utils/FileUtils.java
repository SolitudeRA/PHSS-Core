package org.protogalaxy.phss.component.utils;

import org.bytedeco.javacv.FrameGrabber;
import org.protogalaxy.phss.exception.component.file.FileUtilsException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.util.Date;

public class FileUtils {
    private static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * Format size of the file
     *
     * @param size size of the file
     * @return String format size of the file
     */
    public static String formatSize(long size) {
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

    public static String getMimeType(Path path) {
        String mimeType = null;
        try {
            mimeType = Files.probeContentType(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mimeType;
    }

    public static String getMD5(Path path) {
        try {
            String fileName = path.getFileName().toString();
            String mimeType = Files.probeContentType(path);
            String size = String.valueOf(Files.size(path));
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update((fileName + mimeType + size).getBytes());
            return bufferToHex(messageDigest.digest());
        } catch (Exception e) {
            throw new FileUtilsException("MD5 hashing failed", e);
        }
    }

    public static Date getCreated(Path path) throws Exception {
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        return new Date(attributes.creationTime().toMillis());
    }

    public static Date getModified(Path path) throws Exception {
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        return new Date(attributes.lastModifiedTime().toMillis());
    }

    public static Date getLastAccessTime(Path path) throws Exception {
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        return new Date(attributes.lastAccessTime().toMillis());
    }

    private static String bufferToHex(byte[] bytes) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte[] bytes, int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hex[(bt & 0xf0) >> 4];
        char c1 = hex[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }
}

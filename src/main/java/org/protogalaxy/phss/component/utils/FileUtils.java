package org.protogalaxy.phss.component.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class FileUtils {
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
}

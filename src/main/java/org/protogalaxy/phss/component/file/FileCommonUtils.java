package org.protogalaxy.phss.component.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class FileCommonUtils {
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

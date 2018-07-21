package org.protogalaxy.phss.component.file.document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DocumentUtils {
    public String getMimeType(Path path) {
        String mimeType = null;
        try {
            mimeType = Files.probeContentType(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mimeType;
    }
}

package org.protogalaxy.phss.exception.component.file;

public class FileUtilsException extends RuntimeException {
    public FileUtilsException(String message) {
        super(message);
    }

    public FileUtilsException(String message, Throwable cause) {
        super(message, cause);
    }
}

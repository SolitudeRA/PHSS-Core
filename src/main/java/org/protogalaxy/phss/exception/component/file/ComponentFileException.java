package org.protogalaxy.phss.exception.component.file;

public class ComponentFileException extends RuntimeException {
    public ComponentFileException(String message) {
        super(message);
    }

    public ComponentFileException(String message, Throwable cause) {
        super(message, cause);
    }
}

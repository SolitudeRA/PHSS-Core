package org.protogalaxy.phss.exception.component.file;

public class ComponentFileInvalidMimeTypeException extends ComponentFileException{
    public ComponentFileInvalidMimeTypeException(String message) {
        super(message);
    }

    public ComponentFileInvalidMimeTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}

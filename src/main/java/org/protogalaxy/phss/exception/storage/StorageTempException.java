package org.protogalaxy.phss.exception.storage;

import java.io.IOException;

public class StorageTempException extends RuntimeException {
    public StorageTempException(String message) { super(message); }

    public StorageTempException(String message, Throwable cause) { super(message, cause); }
}

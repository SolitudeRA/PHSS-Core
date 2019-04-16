package org.protogalaxy.phss.exception.application.database;

import org.protogalaxy.phss.exception.PhssCustomException;
import org.protogalaxy.phss.exception.PhssErrorCode;

public class DatabaseException extends PhssCustomException {
    public DatabaseException() {
        super();
    }

    public DatabaseException(PhssErrorCode phssErrorCode) {
        super(phssErrorCode);
    }

    public DatabaseException(PhssErrorCode phssErrorCode, Throwable cause) {
        super(phssErrorCode, cause);
    }

    protected DatabaseException(PhssErrorCode phssErrorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(phssErrorCode, cause, enableSuppression, writableStackTrace);
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    }

    protected DatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

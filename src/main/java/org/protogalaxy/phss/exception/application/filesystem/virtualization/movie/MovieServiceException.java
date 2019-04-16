package org.protogalaxy.phss.exception.application.filesystem.virtualization.movie;

import org.protogalaxy.phss.exception.PhssCustomException;
import org.protogalaxy.phss.exception.PhssErrorCode;

public class MovieServiceException extends PhssCustomException {
    public MovieServiceException() {
        super();
    }

    public MovieServiceException(PhssErrorCode phssErrorCode) {
        super(phssErrorCode);
    }

    public MovieServiceException(PhssErrorCode phssErrorCode, Throwable cause) {
        super(phssErrorCode, cause);
    }

    protected MovieServiceException(PhssErrorCode phssErrorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(phssErrorCode, cause, enableSuppression, writableStackTrace);
    }

    public MovieServiceException(String message) {
        super(message);
    }

    public MovieServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovieServiceException(Throwable cause) {
        super(cause);
    }

    protected MovieServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

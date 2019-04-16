package org.protogalaxy.phss.exception.application.filesystem.virtualization.anime;

import org.protogalaxy.phss.exception.PhssCustomException;
import org.protogalaxy.phss.exception.PhssErrorCode;

public class AnimeServiceException extends PhssCustomException {
    public AnimeServiceException() {
        super();
    }

    public AnimeServiceException(PhssErrorCode phssErrorCode) {
        super(phssErrorCode);
    }

    public AnimeServiceException(PhssErrorCode phssErrorCode, Throwable cause) {
        super(phssErrorCode, cause);
    }

    protected AnimeServiceException(PhssErrorCode phssErrorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(phssErrorCode, cause, enableSuppression, writableStackTrace);
    }

    public AnimeServiceException(String message) {
        super(message);
    }

    public AnimeServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnimeServiceException(Throwable cause) {
        super(cause);
    }

    protected AnimeServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

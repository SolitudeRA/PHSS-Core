package org.protogalaxy.phss.exception.application.filesystem.virtualization.photo;

import org.protogalaxy.phss.exception.PhssCustomException;
import org.protogalaxy.phss.exception.PhssErrorCode;

public class PhotoServiceException extends PhssCustomException {
    public PhotoServiceException() {
        super();
    }

    public PhotoServiceException(PhssErrorCode phssErrorCode) {
        super(phssErrorCode);
    }

    public PhotoServiceException(PhssErrorCode phssErrorCode, Throwable cause) {
        super(phssErrorCode, cause);
    }

    protected PhotoServiceException(PhssErrorCode phssErrorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(phssErrorCode, cause, enableSuppression, writableStackTrace);
    }

    public PhotoServiceException(String message) {
        super(message);
    }

    public PhotoServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhotoServiceException(Throwable cause) {
        super(cause);
    }

    protected PhotoServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

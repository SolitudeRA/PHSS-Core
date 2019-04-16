package org.protogalaxy.phss.exception.application.filesystem.virtualization.document;

import org.protogalaxy.phss.exception.PhssCustomException;
import org.protogalaxy.phss.exception.PhssErrorCode;

public class DocumentServiceException extends PhssCustomException {
    public DocumentServiceException() {
        super();
    }

    public DocumentServiceException(PhssErrorCode phssErrorCode) {
        super(phssErrorCode);
    }

    public DocumentServiceException(PhssErrorCode phssErrorCode, Throwable cause) {
        super(phssErrorCode, cause);
    }

    protected DocumentServiceException(PhssErrorCode phssErrorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(phssErrorCode, cause, enableSuppression, writableStackTrace);
    }

    public DocumentServiceException(String message) {
        super(message);
    }

    public DocumentServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DocumentServiceException(Throwable cause) {
        super(cause);
    }

    protected DocumentServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

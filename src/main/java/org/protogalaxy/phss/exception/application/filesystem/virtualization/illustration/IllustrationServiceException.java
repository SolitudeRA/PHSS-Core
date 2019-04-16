package org.protogalaxy.phss.exception.application.filesystem.virtualization.illustration;

import org.protogalaxy.phss.exception.PhssCustomException;
import org.protogalaxy.phss.exception.PhssErrorCode;

public class IllustrationServiceException extends PhssCustomException {
    public IllustrationServiceException() {
        super();
    }

    public IllustrationServiceException(PhssErrorCode phssErrorCode) {
        super(phssErrorCode);
    }

    public IllustrationServiceException(PhssErrorCode phssErrorCode, Throwable cause) {
        super(phssErrorCode, cause);
    }

    protected IllustrationServiceException(PhssErrorCode phssErrorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(phssErrorCode, cause, enableSuppression, writableStackTrace);
    }

    public IllustrationServiceException(String message) {
        super(message);
    }

    public IllustrationServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllustrationServiceException(Throwable cause) {
        super(cause);
    }

    protected IllustrationServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

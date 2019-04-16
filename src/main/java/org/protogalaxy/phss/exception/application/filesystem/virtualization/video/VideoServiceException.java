package org.protogalaxy.phss.exception.application.filesystem.virtualization.video;

import org.protogalaxy.phss.exception.PhssCustomException;
import org.protogalaxy.phss.exception.PhssErrorCode;

public class VideoServiceException extends PhssCustomException {
    public VideoServiceException() {
        super();
    }

    public VideoServiceException(PhssErrorCode phssErrorCode) {
        super(phssErrorCode);
    }

    public VideoServiceException(PhssErrorCode phssErrorCode, Throwable cause) {
        super(phssErrorCode, cause);
    }

    protected VideoServiceException(PhssErrorCode phssErrorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(phssErrorCode, cause, enableSuppression, writableStackTrace);
    }

    public VideoServiceException(String message) {
        super(message);
    }

    public VideoServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public VideoServiceException(Throwable cause) {
        super(cause);
    }

    protected VideoServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

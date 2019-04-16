package org.protogalaxy.phss.exception.application.filesystem.virtualization.music;

import org.protogalaxy.phss.exception.PhssCustomException;
import org.protogalaxy.phss.exception.PhssErrorCode;

public class MusicServiceException extends PhssCustomException {
    public MusicServiceException() {
        super();
    }

    public MusicServiceException(PhssErrorCode phssErrorCode) {
        super(phssErrorCode);
    }

    public MusicServiceException(PhssErrorCode phssErrorCode, Throwable cause) {
        super(phssErrorCode, cause);
    }

    protected MusicServiceException(PhssErrorCode phssErrorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(phssErrorCode, cause, enableSuppression, writableStackTrace);
    }

    public MusicServiceException(String message) {
        super(message);
    }

    public MusicServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public MusicServiceException(Throwable cause) {
        super(cause);
    }

    protected MusicServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

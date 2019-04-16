package org.protogalaxy.phss.exception.application.base.security;

import org.protogalaxy.phss.exception.PhssCustomException;
import org.protogalaxy.phss.exception.PhssErrorCode;

public class OAuth2FailedException extends PhssCustomException {
    public OAuth2FailedException() {
        super();
    }

    public OAuth2FailedException(PhssErrorCode phssErrorCode) {
        super(phssErrorCode);
    }

    public OAuth2FailedException(PhssErrorCode phssErrorCode, Throwable cause) {
        super(phssErrorCode, cause);
    }

    protected OAuth2FailedException(PhssErrorCode phssErrorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(phssErrorCode, cause, enableSuppression, writableStackTrace);
    }

    public OAuth2FailedException(String message) {
        super(message);
    }

    public OAuth2FailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public OAuth2FailedException(Throwable cause) {
        super(cause);
    }

    protected OAuth2FailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

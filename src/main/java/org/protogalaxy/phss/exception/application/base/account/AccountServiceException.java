package org.protogalaxy.phss.exception.application.base.account;

import org.protogalaxy.phss.exception.PhssCustomException;
import org.protogalaxy.phss.exception.PhssErrorCode;

public class AccountServiceException extends PhssCustomException {
    public AccountServiceException() {
        super();
    }

    public AccountServiceException(PhssErrorCode phssErrorCode) {
        super(phssErrorCode);
    }

    public AccountServiceException(PhssErrorCode phssErrorCode, Throwable cause) {
        super(phssErrorCode, cause);
    }

    protected AccountServiceException(PhssErrorCode phssErrorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(phssErrorCode, cause, enableSuppression, writableStackTrace);
    }

    public AccountServiceException(String message) {
        super(message);
    }

    public AccountServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountServiceException(Throwable cause) {
        super(cause);
    }

    protected AccountServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

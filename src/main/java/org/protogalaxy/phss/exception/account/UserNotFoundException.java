package org.protogalaxy.phss.exception.account;

import org.protogalaxy.phss.exception.main.PhssErrorCodeMain;

public class UserNotFoundException extends AccountServiceException {
    /**
     * Constructs a new runtime exception with {@code PhssErrorCodeMain} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     *
     * @param errorCode the error code object (which is saved for later retrieval
     *                  by the {@link #getErrorCode()} method).
     */
    public UserNotFoundException(PhssErrorCodeMain errorCode) {
        super(errorCode);
    }

    /**
     * Constructs a new runtime exception with the specified {@code PhssErrorCodeMain} and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this runtime exception's detail message.
     *
     * @param errorCode the error code object (which is saved for later retrieval
     *                  by the {@link #getErrorCode()} method).
     * @param cause     the cause (which is saved for later retrieval by the
     *                  {@link #getCause()} method).  (A <tt>null</tt> value is
     */
    public UserNotFoundException(PhssErrorCodeMain errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}

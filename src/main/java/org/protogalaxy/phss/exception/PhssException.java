package org.protogalaxy.phss.exception;

public class PhssException extends RuntimeException {
    private PhssErrorCode errorCode;

    /**
     * Constructs a new runtime exception with {@code PhssErrorCode} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     *
     * @param errorCode the error code object (which is saved for later retrieval
     *                  by the {@link #getErrorCode()} method).
     */
    public PhssException(PhssErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Constructs a new runtime exception with the specified {@code PhssErrorCode} and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this runtime exception's detail message.
     *
     * @param errorCode the error code object (which is saved for later retrieval
     *                  by the {@link #getErrorCode()} method).
     * @param cause     the cause (which is saved for later retrieval by the
     *                  {@link #getCause()} method).  (A <tt>null</tt> value is
     *                  permitted, and indicates that the cause is nonexistent or
     *                  unknown.)
     */
    public PhssException(PhssErrorCode errorCode, Throwable cause) {
        super(errorCode.getInformation(), cause);
        this.errorCode = errorCode;
    }

    public PhssErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(PhssErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}

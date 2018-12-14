package org.protogalaxy.phss.exception;


public enum PhssErrorCodeMain implements PhssErrorCode {

    SERVICE_BASE_ACCOUNT_ALREADY_EXISTS(0x10101001, "Account already exists"),

    SERVICE_BASE_ACCOUNT_INVALID_ID(0x10101002, "Invalid ID"),

    SERVICE_BASE_ACCOUNT_INVALID_USERNAME(0x10101003, "Invalid username"),

    SERVICE_BASE_ACCOUNT_INVALID_PASSWORD(0x10101004, "Invalid password"),

    SERVICE_BASE_ACCOUNT_NOT_ENABLED(0x10101005, "Account not enabled"),

    SERVICE_BASE_ACCOUNT_IS_LOCKED(0x10101006, "Account is locked"),

    SERVICE_BASE_ACCOUNT_IS_EXPIRED(0x10101007, "Account is expired"),

    SERVICE_BASE_ACCOUNT_AUTHORITIES_NOT_ALLOWED(0x10101008, "Account authorities not allowed"),

    SERVICE_FILESYSTEM_STORAGE_FILE_ALREADY_EXISTS(0x10102001, "File already exists");

    private final int errorCode;

    private final String information;

    PhssErrorCodeMain(int value, String information) {
        this.errorCode = value;
        this.information = information;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getInformation() {
        return information;
    }

    /**
     * Returns the error code main series of this error code.
     */
    public PhssErrorCodeMainSeries mainSeries() {
        return PhssErrorCodeMainSeries.valueOf(this);
    }

    /**
     * Returns the error code service series of this error code.
     */
    public PhssErrorCodeServiceSeries serviceSeries() {
        return PhssErrorCodeServiceSeries.valueOf(this);
    }

    /**
     * Return a string representation of this error code.
     */
    @Override
    public String toString() {
        return this.errorCode + " " + name();
    }

    /**
     * Return the enum constant of this type with the specified numeric value.
     *
     * @param errorCode the numeric value of the enum to be returned
     * @return the enum constant with the specified numeric value
     * @throws IllegalArgumentException if this enum has no constant for the specified numeric value
     */
    public static PhssErrorCodeMain valueOf(int errorCode) {
        PhssErrorCodeMain phssErrorCodeMainSample = resolve(errorCode);
        if (phssErrorCodeMainSample == null) {
            throw new IllegalArgumentException("No matching constant for [" + errorCode + "]");
        }
        return phssErrorCodeMainSample;
    }

    /**
     * Resolve the given status code to an {@code HttpStatus}, if possible.
     *
     * @param errorCode the HTTP status code (potentially non-standard)
     * @return the corresponding {@code PhssErrorCodeMain}, or {@code null} if not found
     */
    public static PhssErrorCodeMain resolve(int errorCode) {
        for (PhssErrorCodeMain phssErrorCodeMainSample : values()) {
            if (phssErrorCodeMainSample.errorCode == errorCode) {
                return phssErrorCodeMainSample;
            }
        }
        return null;
    }
}

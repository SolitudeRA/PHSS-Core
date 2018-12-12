package org.protogalaxy.phss.exception;


public enum PhssErrorCode {

    ACCOUNT_ALREADY_EXISTS(10101, "Account already exists"),

    ACCOUNT_INVALID_ID(10102, "Invalid ID"),

    ACCOUNT_INVALID_USERNAME(10103, "Invalid username"),

    ACCOUNT_INVALID_PASSWORD(10104, "Invalid password"),

    ACCOUNT_NOT_ENABLED(10105, "Account not enabled"),

    ACCOUNT_IS_LOCKED(10106, "Account is locked"),

    ACCOUNT_IS_EXPIRED(10107, "Account is expired"),

    ACCOUNT_AUTHORITIES_NOT_ALLOWED(10108, "Account authorities not allowed"),

    FILESYSTEM_FILE_ALREADY_EXISTS(10201, "File already exists");

    private final int errorCode;

    private final String information;

    PhssErrorCode(int value, String information) {
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
    public MainSeries mainSeries() {
        return MainSeries.valueOf(this);
    }

    /**
     * Returns the error code service series of this error code.
     */
    public ServiceSeries serviceSeries() {
        return ServiceSeries.valueOf(this);
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
    public static PhssErrorCode valueOf(int errorCode) {
        PhssErrorCode phssErrorCodeSample = resolve(errorCode);
        if (phssErrorCodeSample == null) {
            throw new IllegalArgumentException("No matching constant for [" + errorCode + "]");
        }
        return phssErrorCodeSample;
    }

    /**
     * Resolve the given status code to an {@code HttpStatus}, if possible.
     *
     * @param errorCode the HTTP status code (potentially non-standard)
     * @return the corresponding {@code PhssErrorCode}, or {@code null} if not found
     */
    public static PhssErrorCode resolve(int errorCode) {
        for (PhssErrorCode phssErrorCodeSample : values()) {
            if (phssErrorCodeSample.errorCode == errorCode) {
                return phssErrorCodeSample;
            }
        }
        return null;
    }

    /**
     * Enumeration of error code main series.
     */
    public enum MainSeries {
        SERVICE_ERROR(1),

        SYSTEM_ERROR(2),

        SERVER_ERROR(3);

        private final int mainSeriesCode;

        MainSeries(int mainSeriesCode) {
            this.mainSeriesCode = mainSeriesCode;
        }

        /**
         * Return the integer value of this status series. Ranges from 1 to 3.
         */
        public int getMainSeriesCode() {
            return mainSeriesCode;
        }

        public static PhssErrorCode.MainSeries valueOf(int code) {
            int seriesCode = code / 10000;
            for (PhssErrorCode.MainSeries mainSeries : values()) {
                if (mainSeries.mainSeriesCode == seriesCode) {
                    return mainSeries;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }

        public static PhssErrorCode.MainSeries valueOf(PhssErrorCode phssErrorCode) {
            return valueOf(phssErrorCode.errorCode);
        }
    }

    /**
     * Enumeration of error code sub series.
     */
    public enum ServiceSeries {
        ACCOUNT_SERVICE(1),

        FILESYSTEM_MUSIC_SERVICE(2),

        FILESYSTEM_ANIME_SERVICE(3),

        FILESYSTEM_MOVIE_SERVICE(4),

        FILESYSTEM_VIDEO_SERVICE(5),

        FILESYSTEM_BOOK_SERVICE(6),

        FILESYSTEM_DOCUMENT_SERVICE(7),

        FILESYSTEM_PHOTO_SERVICE(8),

        FILESYSTEM_ILLUSTRATION_SERVICE(9);

        private final int serviceSeriesCode;

        ServiceSeries(int serviceSeriesCode) {
            this.serviceSeriesCode = serviceSeriesCode;
        }

        /**
         * Return the integer value of this status series. Ranges from 1 to 9.
         */
        public int getServiceSeriesCode() {
            return this.serviceSeriesCode;
        }

        public static PhssErrorCode.ServiceSeries valueOf(int code) {
            int seriesCode = code % 10000 / 1000;
            for (PhssErrorCode.ServiceSeries serviceSeries : values()) {
                if (serviceSeries.serviceSeriesCode == seriesCode) {
                    return serviceSeries;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }

        public static PhssErrorCode.ServiceSeries valueOf(PhssErrorCode phssErrorCode) {
            return valueOf(phssErrorCode.errorCode);
        }
    }
}

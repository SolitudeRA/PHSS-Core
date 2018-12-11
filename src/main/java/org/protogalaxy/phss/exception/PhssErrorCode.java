package org.protogalaxy.phss.exception;


public enum PhssErrorCode {

    ACCOUNT_ALREADY_EXISTS(10101, "Account already exists");

    private final int value;

    private final String information;

    PhssErrorCode(int value, String information) {
        this.value = value;
        this.information = information;
    }

    public int getValue() {
        return value;
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
        return this.value + " " + name();
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
            if (phssErrorCodeSample.value == errorCode) {
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

        private final int value;

        MainSeries(int value) {
            this.value = value;
        }

        /**
         * Return the integer value of this status series. Ranges from 1 to 5.
         */
        public int getValue() {
            return value;
        }

        public static PhssErrorCode.MainSeries valueOf(int code) {
            int seriesCode = code / 10000;
            for (PhssErrorCode.MainSeries series : values()) {
                if (series.value == seriesCode) {
                    return series;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }

        public static PhssErrorCode.MainSeries valueOf(PhssErrorCode phssErrorCode) {
            return valueOf(phssErrorCode.value);
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

        private final int value;

        ServiceSeries(int value) {
            this.value = value;
        }

        /**
         * Return the integer value of this status series. Ranges from 1 to 5.
         */
        public int getValue() {
            return value;
        }

        public static PhssErrorCode.ServiceSeries valueOf(int code) {
            int seriesCode = code % 10000 / 1000;
            for (PhssErrorCode.ServiceSeries series : values()) {
                if (series.value == seriesCode) {
                    return series;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }

        public static PhssErrorCode.ServiceSeries valueOf(PhssErrorCode phssErrorCode) {
            return valueOf(phssErrorCode.value);
        }
    }
}

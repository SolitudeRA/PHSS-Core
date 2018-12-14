package org.protogalaxy.phss.exception;

public enum  PhssErrorCodeServiceSeries {
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

    PhssErrorCodeServiceSeries(int serviceSeriesCode) {
        this.serviceSeriesCode = serviceSeriesCode;
    }

    /**
     * Return the integer value of this status series. Ranges from 1 to 9.
     */
    public int getServiceSeriesCode() {
        return this.serviceSeriesCode;
    }

    public static PhssErrorCodeServiceSeries valueOf(int code) {
        int seriesCode = code % 10000 / 1000;
        for (PhssErrorCodeServiceSeries serviceSeries : values()) {
            if (serviceSeries.serviceSeriesCode == seriesCode) {
                return serviceSeries;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }

    public static PhssErrorCodeServiceSeries valueOf(PhssErrorCode phssErrorCode) {
        return valueOf(phssErrorCode.getErrorCode());
    }
}

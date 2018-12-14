package org.protogalaxy.phss.exception;

public enum PhssErrorCodeMainSeries {
    SERVICE_ERROR(1),

    SYSTEM_ERROR(2),

    SERVER_ERROR(3);

    private final int mainSeriesCode;

    PhssErrorCodeMainSeries(int mainSeriesCode) {
        this.mainSeriesCode = mainSeriesCode;
    }

    /**
     * Return the integer value of this status series. Ranges from 1 to 3.
     */
    public int getMainSeriesCode() {
        return mainSeriesCode;
    }

    public static PhssErrorCodeMainSeries valueOf(int code) {
        int seriesCode = code / 10000;
        for (PhssErrorCodeMainSeries phssErrorCodeMainSeries : values()) {
            if (phssErrorCodeMainSeries.mainSeriesCode == seriesCode) {
                return phssErrorCodeMainSeries;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }

    public static PhssErrorCodeMainSeries valueOf(PhssErrorCode phssErrorCode) {
        return valueOf(phssErrorCode.getErrorCode());
    }
}

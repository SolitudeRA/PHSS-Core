package org.protogalaxy.phss.exception.main;

import org.protogalaxy.phss.exception.PhssErrorCode;

public enum PhssErrorCodeBaseSeries {
    APPLICATION_SERIES_ERROR(0x1, "Application error"),

    SYSTEM_SERIES_ERROR(0x2, "System error"),

    SERVER_SERIES_ERROR(0x3, "Server error");

    private final int mainSeriesCode;

    private final String information;

    PhssErrorCodeBaseSeries(int mainSeriesCode, String information) {
        this.mainSeriesCode = mainSeriesCode;
        this.information = information;
    }

    /**
     * Return the integer code value of this main series. Ranges from 0x1 to 0x3.
     */
    public int code() {
        return this.mainSeriesCode;
    }

    /**
     * Return the information of the main series code
     */
    public String getInformation() {
        return this.information;
    }

    public static PhssErrorCodeBaseSeries valueOf(int code) {
        int seriesCode = code / 0xFFFFFFF;
        for (PhssErrorCodeBaseSeries phssErrorCodeBaseSeries : values()) {
            if (phssErrorCodeBaseSeries.mainSeriesCode == seriesCode) {
                return phssErrorCodeBaseSeries;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }

    public static PhssErrorCodeBaseSeries valueOf(PhssErrorCode phssErrorCode) {
        return valueOf(phssErrorCode.getErrorCode());
    }
}

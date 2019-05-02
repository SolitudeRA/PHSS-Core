package org.protogalaxy.phss.exception;

public enum PhssErrorCodeBaseSeries {
    APPLICATION(0x01, "Application error"),

    SYSTEM(0x02, "System error"),

    HARDWARE(0x03, "Hardware error"),

    SERVER(0x04, "Server error");

    private final int baseSeriesCode;

    private final String information;

    PhssErrorCodeBaseSeries(int baseSeriesCode, String information) {
        this.baseSeriesCode = baseSeriesCode;
        this.information = information;
    }

    /**
     * Return the integer code value of this authentication series. Ranges from 0x1 to 0x3.
     */
    public int getBaseSeriesCode() {
        return this.baseSeriesCode;
    }

    /**
     * Return the information of the authentication series code
     */
    public String getInformation() {
        return this.information;
    }

    public static PhssErrorCodeBaseSeries valueOf(long code) {
        long seriesCode = code / 0xFFFFFFF;
        for (PhssErrorCodeBaseSeries phssErrorCodeBaseSeries : values()) {
            if (phssErrorCodeBaseSeries.baseSeriesCode == seriesCode) {
                return phssErrorCodeBaseSeries;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }

    public static PhssErrorCodeBaseSeries valueOf(PhssErrorCode phssErrorCode) {
        return valueOf(phssErrorCode.getErrorCode());
    }
}
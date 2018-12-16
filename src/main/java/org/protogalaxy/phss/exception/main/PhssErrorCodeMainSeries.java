package org.protogalaxy.phss.exception.main;

import org.protogalaxy.phss.exception.PhssErrorCode;

public class PhssErrorCodeMainSeries {
    public static int SERVICE_ERROR_CODE = 0x1;

    public static int SYSTEM_ERROR_CODE = 0x2;

    public static int SERVER_ERROR_CODE = 0x3;

    public static String SERVICE_ERROR_INFORMATION = "Service error";

    public static String SYSTEM_ERROR_INFORMATION = "System error";

    public static String SERVER_ERROR_INFORMATION = "Server error";

    private final int mainSeriesCode;

    PhssErrorCodeMainSeries(int mainSeriesCode) {
        this.mainSeriesCode = mainSeriesCode;
    }

    /**
     * Return the integer value of this status series. Ranges from 0x1 to 0x3.
     */
    public int getMainSeriesCode() {
        return mainSeriesCode;
    }

    public String getMainSeriesCodeString() {
        return Integer.toHexString(this.mainSeriesCode);
    }

    public static PhssErrorCodeMainSeries valueOf(int code) {
        int seriesCode = code / 0x;
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

package org.protogalaxy.phss.exception.application.base;

import org.protogalaxy.phss.exception.PhssErrorCodeServiceSeries;

public enum PhssErrorCodeApplicationBaseServiceSeries implements PhssErrorCodeServiceSeries {

    ACCOUNT(0x01, "account"),

    SECURITY(0x02, "security");

    public final int serviceSeriesCode;

    public final String information;

    PhssErrorCodeApplicationBaseServiceSeries(int serviceSeriesCode, String information) {
        this.serviceSeriesCode = serviceSeriesCode;
        this.information = information;
    }

    public int getServiceSeriesCode() {
        return this.serviceSeriesCode;
    }

    public String getInformation() {
        return this.information;
    }
}

package org.protogalaxy.phss.exception.application;

import org.protogalaxy.phss.exception.PhssErrorCodeModuleSeries;

public enum PhssErrorCodeApplicationModuleSeries implements PhssErrorCodeModuleSeries {

    BASE(0x01, "base"),

    DATABASE(0x02, "database"),

    FILESYSTEM(0x03, "file system");

    private final int moduleSeriesCode;

    private final String information;

    PhssErrorCodeApplicationModuleSeries(int moduleSeriesCode, String information) {
        this.moduleSeriesCode = moduleSeriesCode;
        this.information = information;
    }

    @Override
    public int getModuleSeriesCode() {
        return this.moduleSeriesCode;
    }

    @Override
    public String getInformation() {
        return this.information;
    }
}

package org.protogalaxy.phss.exception.application.database;

import org.protogalaxy.phss.exception.PhssErrorCode;
import org.protogalaxy.phss.exception.PhssErrorCodeBaseSeries;
import org.protogalaxy.phss.exception.PhssErrorCodeModuleSeries;
import org.protogalaxy.phss.exception.PhssErrorCodeServiceSeries;
import org.protogalaxy.phss.exception.application.PhssErrorCodeApplicationModuleSeries;

public enum PhssErrorCodeApplicationDatabaseSeries implements PhssErrorCodeServiceSeries, PhssErrorCode {

    CONNECTION(0x01, "connection");

    private final PhssErrorCodeBaseSeries baseSeries = PhssErrorCodeBaseSeries.APPLICATION;

    private final PhssErrorCodeModuleSeries moduleSeries = PhssErrorCodeApplicationModuleSeries.DATABASE;

    public final int errorCode;

    public final String information;

    PhssErrorCodeApplicationDatabaseSeries(int errorCode, String information) {
        this.errorCode = errorCode;
        this.information = information;
    }

    @Override
    public PhssErrorCodeBaseSeries getBaseSeries() {
        return this.baseSeries;
    }

    @Override
    public int getBaseSeriesCode() {
        return this.baseSeries.getBaseSeriesCode();
    }

    @Override
    public PhssErrorCodeModuleSeries getModuleSeries() {
        return this.moduleSeries;
    }

    @Override
    public int getModuleSeriesCode() {
        return this.moduleSeries.getModuleSeriesCode();
    }

    @Override
    public PhssErrorCodeServiceSeries getServiceSeries() {
        return this;
    }

    @Override
    public int getServiceSeriesCode() {
        return this.errorCode;
    }

    @Override
    public int getErrorCode() {
        return this.baseSeries.getBaseSeriesCode() * 0xFFFFFFF
                + this.moduleSeries.getModuleSeriesCode() * 0xFFFFF
                + this.getServiceSeriesCode() * 0xFFF
                + this.errorCode;
    }

    @Override
    public String getInformation() {
        return this.information;
    }

    @Override
    public String getFullInformation() {
        return this.baseSeries.getInformation() + ", "
                + this.moduleSeries.getInformation() + ", "
                + this.getInformation();
    }

    @Override
    public String getFullTrackName() {
        return this.getErrorCode() + this.getFullInformation();
    }
}

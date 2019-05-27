package org.protogalaxy.phss.exception.application.base.account;

import org.protogalaxy.phss.exception.PhssErrorCode;
import org.protogalaxy.phss.exception.PhssErrorCodeBaseSeries;
import org.protogalaxy.phss.exception.PhssErrorCodeModuleSeries;
import org.protogalaxy.phss.exception.PhssErrorCodeServiceSeries;
import org.protogalaxy.phss.exception.application.PhssErrorCodeApplicationModuleSeries;
import org.protogalaxy.phss.exception.application.base.PhssErrorCodeApplicationBaseServiceSeries;

public enum PhssErrorCodeApplicationBaseAccountService implements PhssErrorCode {

    ACCOUNT_ALREADY_EXISTS(0x001, "Account already exists"),

    ACCOUNT_INVALID_ID(0x002, "Invalid ID"),

    ACCOUNT_INVALID_USERNAME_OR_PASSWORD(0x003, "Invalid username or password"),

    ACCOUNT_DISABLED(0x004, "Account not enabled"),

    ACCOUNT_LOCKED(0x005, "Account is locked"),

    ACCOUNT_EXPIRED(0x006, "Account is expired"),

    ACCOUNT_AUTHORITIES_NOT_ALLOWED(0x007, "Account authorities not allowed");

    private final PhssErrorCodeBaseSeries baseSeries = PhssErrorCodeBaseSeries.APPLICATION;

    private final PhssErrorCodeModuleSeries moduleSeries = PhssErrorCodeApplicationModuleSeries.BASE;

    private final PhssErrorCodeServiceSeries serviceSeries = PhssErrorCodeApplicationBaseServiceSeries.ACCOUNT;

    private final int errorCode;

    private final String information;

    PhssErrorCodeApplicationBaseAccountService(int errorCode, String information) {
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
        return this.serviceSeries;
    }

    @Override
    public int getServiceSeriesCode() {
        return this.serviceSeries.getServiceSeriesCode();
    }

    @Override
    public int getErrorCode() {
        return this.baseSeries.getBaseSeriesCode() * 0xFFFFFFF
                + this.moduleSeries.getModuleSeriesCode() * 0xFFFFF
                + this.serviceSeries.getServiceSeriesCode() * 0xFFF
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
                + this.serviceSeries.getInformation() + ", "
                + this.information;
    }

    @Override
    public String getFullTrackName() {
        return this.getErrorCode() + this.getFullInformation();
    }
}

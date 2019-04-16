package org.protogalaxy.phss.exception.application.filesystem;

import org.protogalaxy.phss.exception.PhssErrorCodeServiceSeries;

public enum PhssErrorCodeApplicationFileSystemServiceSeries implements PhssErrorCodeServiceSeries {

    STORAGE(0x02, "storage"),

    PATH(0x02, "path"),

    MUSIC(0x01, "music"),

    ANIME(0x02, "anime"),

    MOVIE(0x03, "movie"),

    VIDEO(0x04, "video"),

    BOOK(0x05, "book"),

    DOCUMENT(0x06, "document"),

    PHOTO(0x07, "photo"),

    ILLUSTRATION(0x08, "illustration");

    public final int serviceSeriesCode;

    public final String information;

    PhssErrorCodeApplicationFileSystemServiceSeries(int serviceSeriesCode, String information) {
        this.serviceSeriesCode = serviceSeriesCode;
        this.information = information;
    }

    @Override
    public int getServiceSeriesCode() {
        return this.serviceSeriesCode;
    }

    @Override
    public String getInformation() {
        return this.information;
    }
}

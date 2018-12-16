package org.protogalaxy.phss.exception;

public interface PhssErrorCode {

    int getErrorCode();

    String getInformation();

    static PhssErrorCode valueOf(int errorCode) {
        return null;
    }

    static PhssErrorCode resolve(int errorCode) {
        return null;
    }
}

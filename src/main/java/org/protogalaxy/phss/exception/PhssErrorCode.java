package org.protogalaxy.phss.exception;

public interface PhssErrorCode {

    int getErrorCode();

    String getInformation();

    static PhssErrorCode valueOf(int errorCode) {
        PhssErrorCode phssErrorCodeSample = resolve(errorCode);
        if (phssErrorCodeSample == null) {
            throw new IllegalArgumentException("No matching constant for [" + errorCode + "]");
        }
        return phssErrorCodeSample;
    }

    static PhssErrorCode resolve(int errorCode) {
        for (PhssErrorCode phssErrorCodeSample : values()) {
            if (phssErrorCodeSample.getErrorCode() == errorCode) {
                return phssErrorCodeSample;
            }
        }
        return null;
    }
}

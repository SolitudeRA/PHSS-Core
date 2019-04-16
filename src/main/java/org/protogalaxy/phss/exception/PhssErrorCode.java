package org.protogalaxy.phss.exception;

/**
 * The {@code PhssErrorCode} interface is the basic interface of all PHSS error code
 * in the PHSS error code system.It must includes a {@link PhssErrorCodeBaseSeries},
 * a {@link PhssErrorCodeModuleSeries} and a {@link PhssErrorCodeServiceSeries}.
 *
 * @author SolitudeRA
 * @since 1.0.0-release
 */
public interface PhssErrorCode {

    PhssErrorCodeBaseSeries getBaseSeries();

    int getBaseSeriesCode();

    PhssErrorCodeModuleSeries getModuleSeries();

    int getModuleSeriesCode();

    PhssErrorCodeServiceSeries getServiceSeries();

    int getServiceSeriesCode();

    int getErrorCode();

    String getInformation();

    String getFullInformation();

    String getFullTrackName();
}

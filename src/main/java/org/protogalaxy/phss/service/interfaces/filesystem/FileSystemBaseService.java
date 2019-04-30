package org.protogalaxy.phss.service.interfaces.filesystem;

public interface FileSystemBaseService {
    String getJavaVersion();

    String getJavaHome();

    String getOSName();

    String getOSArch();

    String getOSVersion();

    String getMemoryTotal();

    String getMemoryAvailable();

    String getCPUUsage();

    Long getSpaceTotal();

    String getSpaceTotalFormatted();

    Long getSpaceAvailabe();

    String getSpaceAvailableFormatted();
}

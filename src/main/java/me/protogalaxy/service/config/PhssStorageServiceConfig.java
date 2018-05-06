package me.protogalaxy.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "storage")
public class PhssStorageServiceConfig {

    /**
     * Folder location for storing files
     */
    private String prefix = "phss_";

    private String location = "phssStorage";

    private String tempLocation = "phssTemp";

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTempLocation() {
        return tempLocation;
    }

    public void setTempLocation(String tempLocation) {
        this.tempLocation = tempLocation;
    }
}

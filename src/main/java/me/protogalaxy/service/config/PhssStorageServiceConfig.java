package me.protogalaxy.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "storage")
public class PhssStorageServiceConfig {

    /**
     * Folder location for storing files
     */
    private String location = "phss";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

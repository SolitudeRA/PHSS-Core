package org.protogalaxy.phss.service.config;

import org.protogalaxy.phss.service.interfaces.filesystem.multimedia.MetadataService;
import org.protogalaxy.phss.service.main.filesystem.multimedia.MetadataServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultimediaServiceConfig {
    @Bean
    public MetadataService metadataService() {
        return new MetadataServiceImpl();
    }
}

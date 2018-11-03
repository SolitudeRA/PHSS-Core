package org.protogalaxy.phss;

import org.protogalaxy.phss.service.config.StorageServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({StorageServiceConfig.class})
public class PhssApplication {
    public static void main(String args[]) {
        SpringApplication.run(PhssApplication.class, args);
    }
}

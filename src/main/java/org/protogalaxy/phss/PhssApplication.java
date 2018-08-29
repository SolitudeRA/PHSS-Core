package org.protogalaxy.phss;

import org.protogalaxy.phss.service.config.PhssStorageServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({PhssStorageServiceConfig.class})
public class PhssApplication {
    public static void main(String args[]) {
        SpringApplication.run(PhssApplication.class, args);
    }
}

package org.protogalaxy.phss;

import org.protogalaxy.phss.exception.main.GlobalExceptionResolver;
import org.protogalaxy.phss.service.config.StorageServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableConfigurationProperties({StorageServiceConfig.class})
public class PhssApplication {
    public static void main(String[] args) {
        SpringApplication.run(PhssApplication.class, args);
    }

    @Bean
    public GlobalExceptionResolver globalExceptionResolver() {
        return new GlobalExceptionResolver();
    }
}

package me.protogalaxy;

import me.protogalaxy.datasource.config.PhssDatasourceConfig;
import me.protogalaxy.service.config.PhssStorageServiceConfig;
import me.protogalaxy.service.impl.filesystem.PhssStorageServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableConfigurationProperties({PhssStorageServiceConfig.class})
@Import(PhssDatasourceConfig.class)
public class PhssApplication {
    public static void main(String args[]) {
        SpringApplication.run(PhssApplication.class, args);
    }

    @Bean
    CommandLineRunner init(PhssStorageServiceImpl phssStorageService) {
        return (args -> {
            phssStorageService.init();
        });
    }
}

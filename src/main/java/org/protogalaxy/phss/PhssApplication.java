package org.protogalaxy.phss;

import org.protogalaxy.phss.datasource.config.PhssDatasourceConfig;
import org.protogalaxy.phss.service.config.PhssStorageServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
//TODO:番组管理，视频管理，图书管理
@SpringBootApplication
@EnableConfigurationProperties({PhssStorageServiceConfig.class})
@Import(PhssDatasourceConfig.class)
public class PhssApplication {
    public static void main(String args[]) {
        SpringApplication.run(PhssApplication.class, args);
    }
}

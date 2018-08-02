package org.protogalaxy.phss.datasource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableJpaRepositories("org.protogalaxy.phss.datasource.entity.repository.jpa")
@EnableMongoRepositories("org.protogalaxy.phss.datasource.entity.repository.mongodb")
public class PhssDatasourceConfig {
}

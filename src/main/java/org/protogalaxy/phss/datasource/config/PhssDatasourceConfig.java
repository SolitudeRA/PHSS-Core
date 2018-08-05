package org.protogalaxy.phss.datasource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration
@EnableSpringDataWebSupport
@EnableJpaRepositories("org.protogalaxy.phss.datasource.entity.repository.jpa")
@EnableMongoRepositories("org.protogalaxy.phss.datasource.entity.repository.mongodb")
@EnableRedisRepositories("org.protogalaxy.phss.datasource.entity.repository.redis")
public class PhssDatasourceConfig {
}

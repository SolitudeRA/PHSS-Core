package me.protogalaxy;

import me.protogalaxy.service.security.config.PhssMainSecurityConfig;
import me.protogalaxy.service.security.config.PhssMethodSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({PhssMainSecurityConfig.class, PhssMethodSecurityConfig.class})
public class PHSSBootstrap {
    public static void main(String args[]) {
        SpringApplication.run(PHSSBootstrap.class, args);
    }
}

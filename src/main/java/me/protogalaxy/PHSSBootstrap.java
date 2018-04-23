package me.protogalaxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(PHSSSecurityConfig.class)
public class PHSSBootstrap {
    public static void main(String args[]) {
        SpringApplication.run(PHSSBootstrap.class, args);
    }
}

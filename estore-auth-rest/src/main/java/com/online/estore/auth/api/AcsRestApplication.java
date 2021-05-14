package com.online.estore.auth.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.online.estore.core.repository")
@EntityScan("com.online.estore.core.entity")
public class AcsRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcsRestApplication.class, args);
    }
}

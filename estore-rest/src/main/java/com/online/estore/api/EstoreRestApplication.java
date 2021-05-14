package com.online.estore.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.online.estore.api")
@EnableJpaRepositories("com.online.estore.core.repository")
@EntityScan("com.online.estore.core.entity")
public class EstoreRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(EstoreRestApplication.class, args);
    }
}

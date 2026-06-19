package com.urbanGuard.safebus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SafeBusApplication {
    public static void main(String[] args) {
        SpringApplication.run(SafeBusApplication.class, args);
    }
}

package com.example.coffeedee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CoffeeDeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeDeeApplication.class, args);
    }

}

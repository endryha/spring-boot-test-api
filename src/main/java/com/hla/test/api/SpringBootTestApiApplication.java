package com.hla.test.api;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class SpringBootTestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApiApplication.class, args);
    }

    @Bean
    Faker faker() {
        return new Faker();
    }
}

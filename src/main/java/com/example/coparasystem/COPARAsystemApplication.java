package com.example.coparasystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class COPARAsystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(COPARAsystemApplication.class, args);
    }
}

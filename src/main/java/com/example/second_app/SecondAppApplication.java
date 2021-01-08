package com.example.second_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@SpringBootApplication()
public class SecondAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondAppApplication.class, args);
    }

}

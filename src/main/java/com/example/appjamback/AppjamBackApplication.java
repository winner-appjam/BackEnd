package com.example.appjamback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class AppjamBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppjamBackApplication.class, args);
    }

}

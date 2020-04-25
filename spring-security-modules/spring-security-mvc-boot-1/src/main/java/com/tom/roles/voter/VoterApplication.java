package com.tom.roles.voter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.tom.voter"})
public class VoterApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoterApplication.class, args);
    }
}

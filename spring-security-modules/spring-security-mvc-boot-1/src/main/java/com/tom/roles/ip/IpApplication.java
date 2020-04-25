package com.tom.roles.ip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("com.tom.ip")
@PropertySource("classpath:application-defaults.properties")
public class IpApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(IpApplication.class, args);
    }
}

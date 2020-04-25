package com.tom.roles.custom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@ComponentScan("com.tom.roles.custom")
//@EnableJpaRepositories(basePackages = "com.tom.roles.custom.persistence.dao")
@PropertySource("classpath:application-defaults.properties")
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

package com.tom.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class Application {
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        log.info("系统入口");
        applicationContext = SpringApplication.run(Application.class, args);
    }
}

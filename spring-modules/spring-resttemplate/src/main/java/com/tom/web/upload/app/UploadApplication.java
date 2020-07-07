package com.tom.web.upload.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.tom.web.upload")
@SpringBootApplication
public class UploadApplication extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(UploadApplication.class, args);
    }
}
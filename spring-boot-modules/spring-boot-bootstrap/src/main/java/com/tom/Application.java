package com.tom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/25
 */
@SpringBootApplication
@EnableJpaRepositories("com.tom.persistence.repo")
@EntityScan("com.tom.persistence.model")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
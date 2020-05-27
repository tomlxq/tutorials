package com.tom.ex.dataintegrityviolationexception.spring;

import com.tom.spring.config.PersistenceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

@Configuration
@ComponentScan("com.tom.ex.dataIntegrityviolationexception.cause1")
@Import(PersistenceConfig.class)
public class Cause1DataContextWithJavaConfig {

    public Cause1DataContextWithJavaConfig() {
        super();
    }

    // beans

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
package com.tom.ex.dataintegrityviolationexception.spring;

import com.tom.spring.config.PersistenceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.tom.ex.dataIntegrityviolationexception.cause2")
@Import(PersistenceConfig.class)
public class Cause2DataContextWithJavaConfig {

    public Cause2DataContextWithJavaConfig() {
        super();
    }

    // beans

}
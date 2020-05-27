package com.tom.ex.beancreationexception.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tom.ex.beancreationexception.cause8")
public class Cause8ContextWithJavaConfig {

    public Cause8ContextWithJavaConfig() {
        super();
    }

    // beans

}
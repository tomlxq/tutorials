package com.tom.ex.beandefinitionstoreexception.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.tom.ex.beandefinitionstoreexception.cause1")
@ImportResource("beans.xml")
public class Cause1ContextWithJavaConfig {

    public Cause1ContextWithJavaConfig() {
        super();
    }

    // beans

}
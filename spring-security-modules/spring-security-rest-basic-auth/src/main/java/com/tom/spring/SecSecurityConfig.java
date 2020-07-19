package com.tom.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:webSecurityConfig.xml"})
@ComponentScan("com.tom.security")
public class SecSecurityConfig {

    public SecSecurityConfig() {
        super();
    }

}

package com.tom.spring;

import org.springframework.context.annotation.ComponentScan;

// @Configuration
// @ImportResource({ "classpath:webSecurityConfig.xml" })
@ComponentScan("com.tom.security")
public class SecurityXmlConfig {

    public SecurityXmlConfig() {
        super();
    }

}

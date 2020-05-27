package com.tom.properties.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:configForPropertiesOne.xml")
@ComponentScan("com.tom.core")
public class PropertiesWithXmlConfigOne {

    public PropertiesWithXmlConfigOne() {
        super();
    }

}
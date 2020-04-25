package com.tom.contexts.config;

import com.tom.contexts.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.tom.contexts.services"})
public class RootApplicationConfig {

    @Bean
    public Greeting greeting() {
        Greeting greeting = new Greeting();
        greeting.setMessage("Hello World !!");
        return greeting;
    }
}

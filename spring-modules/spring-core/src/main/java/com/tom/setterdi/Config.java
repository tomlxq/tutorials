package com.tom.setterdi;

import com.tom.setterdi.domain.Engine;
import com.tom.setterdi.domain.Trailer;
import com.tom.setterdi.domain.Transmission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.tom.setterdi")
public class Config {

    @Bean
    public Engine engine() {
        Engine engine = new Engine();
        engine.setType("v8");
        engine.setVolume(5);
        return engine;
    }

    @Bean
    public Transmission transmission() {
        Transmission transmission = new Transmission();
        transmission.setType("sliding");
        return transmission;
    }

    @Bean
    public Trailer trailer() {
        Trailer trailer = new Trailer();
        return trailer;
    }
}
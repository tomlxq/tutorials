package com.tom.bean.config;

import com.tom.bean.injection.Helm;
import com.tom.bean.injection.Ship;
import org.springframework.context.annotation.Bean;

public class SetterBasedShipConfig {

    @Bean
    public Ship ship() {
        return new Ship();
    }

    @Bean
    public Helm helm() {
        return new Helm();
    }
}

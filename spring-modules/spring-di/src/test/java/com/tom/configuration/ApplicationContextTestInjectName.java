package com.tom.configuration;

import com.tom.dependency.ArbitraryDependency;
import com.tom.dependency.YetAnotherArbitraryDependency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextTestInjectName {

    @Bean
    public ArbitraryDependency yetAnotherFieldInjectDependency() {
        ArbitraryDependency yetAnotherFieldInjectDependency = new YetAnotherArbitraryDependency();
        return yetAnotherFieldInjectDependency;
    }
}

package com.tom.di.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SpringBeansConfig.class})
@ComponentScan("com.tom.di.spring")
public class SpringMainConfig {

    @Bean
    public BookService bookServiceGenerator() {
        return new BookServiceImpl();
    }

}

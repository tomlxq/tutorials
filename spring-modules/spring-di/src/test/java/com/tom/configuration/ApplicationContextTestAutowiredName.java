package com.tom.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.tom.dependency"})
public class ApplicationContextTestAutowiredName {
}

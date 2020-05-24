package com.tom.profiles;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.tom.profiles")
@PropertySource(value = "classpath:application.properties")
public class SpringProfilesConfig {

}

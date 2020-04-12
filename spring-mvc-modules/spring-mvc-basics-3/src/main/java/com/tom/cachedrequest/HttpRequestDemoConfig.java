package com.tom.cachedrequest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * To initialize the WebApplication, Please see
 * {@link com.tom.spring.config.MainWebAppInitializer}
 */

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.tom.cachedrequest")
public class HttpRequestDemoConfig implements WebMvcConfigurer {

}
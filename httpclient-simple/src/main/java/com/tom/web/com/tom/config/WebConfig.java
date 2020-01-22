package com.tom.web.com.tom.config;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/17
 */
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("com.tom.web")
public class WebConfig implements WebMvcConfigurer {

    public WebConfig() {
        super();
    }

    // beans

    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    //

}

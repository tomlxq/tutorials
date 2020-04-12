package com.tom.boot.config;

import com.tom.boot.converter.GenericBigDecimalConverter;
import com.tom.boot.converter.StringToAbstractEntityConverterFactory;
import com.tom.boot.converter.StringToEmployeeConverter;
import com.tom.boot.converter.StringToEnumConverter;
import com.tom.boot.web.resolver.HeaderVersionArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new HeaderVersionArgumentResolver());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEmployeeConverter());
        registry.addConverter(new StringToEnumConverter());
        registry.addConverterFactory(new StringToAbstractEntityConverterFactory());
        registry.addConverter(new GenericBigDecimalConverter());
    }
}

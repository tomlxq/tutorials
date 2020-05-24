package com.tom.sampleabstract;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.tom.sampleabstract")
public class DemoApp {


    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DemoApp.class);
    }

}

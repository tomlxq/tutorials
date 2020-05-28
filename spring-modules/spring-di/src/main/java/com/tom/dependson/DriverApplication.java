package com.tom.dependson;

import com.tom.dependson.config.Config;
import com.tom.dependson.file.processor.FileProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DriverApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        ctx.getBean(FileProcessor.class);
        ctx.close();
    }
}

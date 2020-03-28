package com.tom.springbootmvc.jsfapplication;

import com.tom.springbootmvc.jsfapplication.controller.JsfController;
import com.tom.springbootmvc.jsfapplication.model.TodoDao;
import com.tom.springbootmvc.jsfapplication.service.TodoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication
@ComponentScan(basePackageClasses = {JsfController.class, TodoDao.class, TodoService.class})
public class JsfApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JsfApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
        return servletRegistrationBean;
    }

}

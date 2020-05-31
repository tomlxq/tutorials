package com.tom.scopes;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class ScopesConfig {

    @Bean
    //@Scope("singleton")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Person personSingleton() {
        return new Person();
    }

    @Bean
    // @Scope("prototype")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Person personPrototype() {
        return new Person();
    }

    @Bean
    @RequestScope
    public HelloMessageGenerator requestScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @SessionScope
    public HelloMessageGenerator sessionScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @ApplicationScope
    public HelloMessageGenerator applicationScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HelloMessageGenerator websocketScopedBean() {
        return new HelloMessageGenerator();
    }
}

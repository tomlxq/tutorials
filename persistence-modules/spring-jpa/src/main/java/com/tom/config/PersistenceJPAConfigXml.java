package com.tom.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// @Configuration
@EnableTransactionManagement
@ComponentScan({"com.tom.persistence"})
@ImportResource({"classpath:jpaConfig.xml"})
public class PersistenceJPAConfigXml {

    public PersistenceJPAConfigXml() {
        super();
    }

}
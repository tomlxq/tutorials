package com.tom.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.tom.persistence.dao", "com.tom.persistence.service"})
@ImportResource({"classpath:hibernate5Config.xml"})
public class PersistenceXmlConfig {

}
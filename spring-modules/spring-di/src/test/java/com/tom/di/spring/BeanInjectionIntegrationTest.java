package com.tom.di.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
public class BeanInjectionIntegrationTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("com.tom.di.spring.xml");
    }

    @Test
    public void singletonBean_getBean_returnsSingleInstance() {
        final IndexApp indexApp1 = applicationContext.getBean("indexApp", IndexApp.class);
        final IndexApp indexApp2 = applicationContext.getBean("indexApp", IndexApp.class);
        final IndexApp indexApp3 = applicationContext.getBean("indexAppWithConstructor", IndexApp.class);
        log.info("indexApp1 hashCode {}", indexApp1.hashCode());
        log.info("indexApp2 hashCode {}", indexApp2.hashCode());
        log.info("indexApp3 hashCode {}", indexApp3.hashCode());
        assertEquals(indexApp1, indexApp2);
    }

    @Test
    public void getBean_staticFactory() {
        final IndexApp indexApp = applicationContext.getBean("indexAppWithStaticFactory", IndexApp.class);
        assertNotNull(indexApp);
        log.info(" {}", indexApp.getServiceValue());
    }

    @Test
    public void getBean_FactoryMethod() {
        final IndexApp indexApp = applicationContext.getBean("indexAppWithFactoryMethod", IndexApp.class);
        assertNotNull(indexApp);
        log.info(" {}", indexApp.getServiceValue());
    }

    @Test
    public void getBean_returnsInstance() {

        final IndexApp indexApp = applicationContext.getBean("indexApp", IndexApp.class);
        assertNotNull(indexApp);
    }

}

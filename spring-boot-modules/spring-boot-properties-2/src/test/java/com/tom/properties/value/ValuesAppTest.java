package com.tom.properties.value;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/5/30
 */
@Slf4j
public class ValuesAppTest {
    ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        System.setProperty("systemValue", "Some system parameter value");
        System.setProperty("priority", "System property");
        applicationContext = new AnnotationConfigApplicationContext(ValuesApp.class);
    }

    @Test
    public void test_getMap() {
        final ValuesApp bean = applicationContext.getBean(ValuesApp.class);
        log.info("{}", bean.getUnknownMap());
        log.info("{}", bean.getSystemPropertiesMap());
    }
}
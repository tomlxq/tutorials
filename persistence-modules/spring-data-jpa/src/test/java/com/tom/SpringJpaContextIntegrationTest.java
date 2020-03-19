package com.tom;

import com.tom.boot.Application;
import com.tom.boot.config.PersistenceConfiguration;
import com.tom.multipledb.PersistenceProductConfiguration;
import com.tom.multipledb.PersistenceUserConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest(excludeAutoConfiguration = {
        PersistenceConfiguration.class,
        PersistenceUserConfiguration.class,
        PersistenceProductConfiguration.class})
@ContextConfiguration(classes = Application.class)
public class SpringJpaContextIntegrationTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
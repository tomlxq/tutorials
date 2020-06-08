package com.tom;

import com.tom.spring.session.SessionWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This live test requires:
 * redis instance running on the environment
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SessionWebApplication.class)
public class SpringContextLiveTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}

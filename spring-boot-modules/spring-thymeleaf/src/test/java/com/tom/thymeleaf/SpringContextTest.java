package com.tom.thymeleaf;

import com.tom.thymeleaf.config.InitSecurity;
import com.tom.thymeleaf.config.WebApp;
import com.tom.thymeleaf.config.WebMVCConfig;
import com.tom.thymeleaf.config.WebMVCSecurity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebApp.class, WebMVCConfig.class, WebMVCSecurity.class, InitSecurity.class})
public class SpringContextTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}

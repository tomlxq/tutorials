package com.tom;

import com.tom.spring.Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class AppContextIntegrationTest {
    @Test
    public void contextLoads() {
    }
}

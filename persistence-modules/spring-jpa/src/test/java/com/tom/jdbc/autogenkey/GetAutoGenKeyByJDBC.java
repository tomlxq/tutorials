package com.tom.jdbc.autogenkey;

import com.tom.jdbc.autogenkey.repository.MessageRepositoryJDBCTemplate;
import com.tom.jdbc.autogenkey.repository.MessageRepositorySimpleJDBCInsert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class GetAutoGenKeyByJDBC {

    final String MESSAGE_CONTENT = "Test";
    @Autowired
    MessageRepositorySimpleJDBCInsert messageRepositorySimpleJDBCInsert;

    @Autowired
    MessageRepositoryJDBCTemplate messageRepositoryJDBCTemplate;

    @Test
    public void insertJDBC_whenLoadMessageByKey_thenGetTheSameMessage() {
        long key = messageRepositoryJDBCTemplate.insert(MESSAGE_CONTENT);
        String loadedMessage = messageRepositoryJDBCTemplate.getMessageById(key);

        assertEquals(MESSAGE_CONTENT, loadedMessage);

    }

    @Test
    public void insertSimpleInsert_whenLoadMessageKey_thenGetTheSameMessage() {
        long key = messageRepositorySimpleJDBCInsert.insert(MESSAGE_CONTENT);
        String loadedMessage = messageRepositoryJDBCTemplate.getMessageById(key);

        assertEquals(MESSAGE_CONTENT, loadedMessage);
    }

    @Configuration
    @ComponentScan(basePackages = {"com.tom.jdbc.autogenkey"})
    public static class SpringConfig {

    }

}

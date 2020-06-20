package com.tom.optionalreturntype;

import org.junit.Before;
import org.junit.Test;

import java.io.NotSerializableException;
import java.util.Optional;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/6/20
 */
public class SerializeOptionalTypeExampleTest {
    SerializeOptionalTypeExample tmpExample = null;

    @Before
    public void setUp() throws Exception {
        tmpExample = new SerializeOptionalTypeExample();
    }

    @Test(expected = NotSerializableException.class)
    public void serializeObject() {

        User user1 = new User();
        user1.setUserId(1l);
        user1.setFirstName("guava");

        tmpExample.serializeObject(user1, "user1.ser");

        UserOptionalField user2 = new UserOptionalField();
        user2.setUserId(1l);
        user2.setFirstName(Optional.of("guava"));

        tmpExample.serializeObject(user2, "user2.ser");
    }
}
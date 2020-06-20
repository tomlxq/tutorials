package com.tom.optionalreturntype;

import lombok.Data;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Optional;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/6/20
 */
public class HandleOptionalTypeExampleTest {
    @Test(expected = NotSerializableException.class)
    public void givenOptional_whenGetObject_thenGetNotSerializableException() throws IOException {
        new ObjectOutputStream(new ByteArrayOutputStream()).writeObject(new Sock());
    }

    @Data
    public class Sock implements Serializable {
        Integer size;
        Optional<Sock> pair;

        // ... getters and setters
    }
}
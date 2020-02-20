package com.tom;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/23
 */
public class String2InputStreamTest {
    @Test
    public void givenUsingPlainJava_whenConvertingStringToInputStream_thenCorrect()
            throws IOException {
        String initialString = "text";
        InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
    }
}
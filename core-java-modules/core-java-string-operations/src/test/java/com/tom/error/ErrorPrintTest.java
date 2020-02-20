package com.tom.error;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/23
 */
@Slf4j
public class ErrorPrintTest {
    NullPointerException e;

    /**
     * Conversion with Core Java
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
         e = new NullPointerException("this is test");
    }

    /**
     * Conversion with Commons-Lang
     */
    @Test
    public void test() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
       log.info("{}",sw.toString());
    }
    @Test
    public void test1() {
        String stacktrace = ExceptionUtils.getStackTrace(e);
        log.info("{}",stacktrace);
    }

}
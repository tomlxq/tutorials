package com.tom.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
@Slf4j
public class ThreadLocalDemoTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void name() {
        ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();
        threadLocalValue.set(1);
        Integer result = threadLocalValue.get();
        log.info("{}",result);
    }
    @Test
    public void initial() {
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);
        Integer result = threadLocal.get();
        log.info("{}",result);
        threadLocal.remove();
         result = threadLocal.get();
        log.info("{}",result);
    }
}
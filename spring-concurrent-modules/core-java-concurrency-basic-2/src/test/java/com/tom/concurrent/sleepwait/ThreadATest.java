package com.tom.concurrent.sleepwait;

import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/5/16
 */
public class ThreadATest {
    @Test
    public void name() throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.start();
        threadA.join();
    }
}
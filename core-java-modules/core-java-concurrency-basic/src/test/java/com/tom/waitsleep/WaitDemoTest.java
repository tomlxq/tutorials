package com.tom.waitsleep;

import org.junit.Test;

import static com.tom.waitsleep.WaitDemo.sleepWaitExamples;
import static com.tom.waitsleep.WaitDemo.sleepWaitExamples2;
import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/14
 */
public class WaitDemoTest {
@Test
    public void run() throws InterruptedException {
        sleepWaitExamples();
    }

    @Test
    public void run2() throws InterruptedException {
        sleepWaitExamples2();
    }
}
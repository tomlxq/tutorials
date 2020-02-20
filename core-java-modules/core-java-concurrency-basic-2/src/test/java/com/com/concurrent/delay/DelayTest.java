package com.com.concurrent.delay;

import org.junit.jupiter.api.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/17
 */
public class DelayTest {
    @Test
    public void test_delay()  {
        Delay delay = new Delay();
        delay.threadSleep(4, 1);
        delay.timeunitSleep(4, 1);
        delay.delayedServiceTask(5);
        delay.fixedRateServiceTask(5);
        System.out.println("Done.");
    }
}
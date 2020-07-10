package com.tom.concurrent.sleepwait;

import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/5/16
 */
public class WaitSleepExampleUnitTest {
    @Test
    public void testWaitAndSleep() throws InterruptedException {
        WaitSleepExample.sleepWaitInSynchronizedBlocks();
    }
}
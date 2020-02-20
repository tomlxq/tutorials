package com.tom.threadlifecycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * there are five ways to put a thread on TIMED_WAITING state:
 *
 * thread.sleep(long millis)
 * wait(int timeout) or wait(int timeout, int nanos)
 * thread.join(long millis)
 * LockSupport.parkNanos
 * LockSupport.parkUntil
 *
 * @author TomLuo
 * @date 2020/2/12
 */
@Slf4j
public class TimedWaitingStateTest {
    @Test
    public void name() throws InterruptedException {
        DemoThread obj1 = new DemoThread();
        Thread t1 = new Thread(obj1);
        t1.start();

        // The following sleep will give enough time for ThreadScheduler
        // to start processing of thread t1
        Thread.sleep(1000);
        log.info("{}",t1.getState());
        Assert.assertEquals(t1.getState().name(), Thread.State.TIMED_WAITING.name());
    }
}
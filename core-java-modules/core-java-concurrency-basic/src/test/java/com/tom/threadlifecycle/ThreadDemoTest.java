package com.tom.threadlifecycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
@Slf4j
public class ThreadDemoTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void newState() {
        Runnable runnable = new NewState();
        Thread t = new Thread(runnable);
        log.info("{}", t.getState());
        Assert.assertEquals(t.getState().name(), Thread.State.NEW.name());
    }

    @Test
    public void runnableState() {
        Runnable runnable = new NewState();
        Thread t = new Thread(runnable);
        t.start();
        log.info("{}", t.getState());
        Assert.assertEquals(t.getState().name(), Thread.State.RUNNABLE.name());
    }
}
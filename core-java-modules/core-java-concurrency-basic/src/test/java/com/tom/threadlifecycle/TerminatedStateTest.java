package com.tom.threadlifecycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
@Slf4j
public class TerminatedStateTest {
    @Test
    public void name() throws InterruptedException{
        Thread t1 = new Thread(new TerminatedState());
        t1.start();
        // The following sleep method will give enough time for
        // thread t1 to complete
        TimeUnit.SECONDS.sleep(1);
        log.info("{}",t1.getState());
        Assert.assertEquals(t1.getState().name(), Thread.State.TERMINATED.name());
    }
}
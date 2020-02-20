package com.tom.threadlifecycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
@Slf4j
public class DemoThreadBTest {
    /**
     * We've created two different threads – t1 and t2
     * t1 starts and enters the synchronized commonResource() method; this means that only one thread can access it; all other subsequent threads that try to access this method will be blocked from the further execution until the current one will finish the processing
     * When t1 enters this method, it is kept in infinite while loop; this is just to imitate heavy processing so that all other threads cannot enter this method
     * Now when we start t2, it tries to enter commonResource() method, which is already being accessed by t1, thus, t2 will be kept in BLOCKED state
     * @throws InterruptedException
     */
    @Test
    public void run() throws InterruptedException {
        Thread t1 = new Thread(new DemoThreadB());
        Thread t2 = new Thread(new DemoThreadB());

        t1.start();
        t2.start();

        Thread.sleep(1000);

        log.info("{}", t2.getState());
        Assert.assertEquals(t2.getState().name(), Thread.State.BLOCKED.name());
        System.exit(0);
    }
}
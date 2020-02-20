package com.tom.concurrency.cyclicbarrier;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CyclicBarrier;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
@Slf4j
public class TaskTest {
    @Test
    public void start() {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            // ...
            log.info("All previous tasks are completed");
        });

        Thread t1 = new Thread(new Task(cyclicBarrier), "T1");
        Thread t2 = new Thread(new Task(cyclicBarrier), "T2");
        Thread t3 = new Thread(new Task(cyclicBarrier), "T3");

        if (!cyclicBarrier.isBroken()) {
            t1.start();
            t2.start();
            t3.start();
        }
    }
}
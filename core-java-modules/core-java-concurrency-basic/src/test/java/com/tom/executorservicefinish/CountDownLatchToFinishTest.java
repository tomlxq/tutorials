package com.tom.executorservicefinish;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */
class CountDownLatchToFinishTest {
    ExecutorService WORKER_THREAD_POOL
            = Executors.newFixedThreadPool(10);
    @Test
    void test_countDownLatch_shutdown_gracefully() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            WORKER_THREAD_POOL.submit(() -> {
                try {
                    //模拟业务执行操作
                    TimeUnit.SECONDS.sleep(3);
                    latch.countDown();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

// wait for the latch to be decremented by the two remaining threads
        latch.await();
    }
}
package com.tom.cyclicbarriervscountdownlatch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
@Slf4j
public class CountDownLatchDemoTest {
    /**
     * 一旦锁存器达到零，等待调用就会返回。
     * 请注意，在这种情况下，我们能够使同一线程将计数减少两次。
     *
     * @throws InterruptedException
     */
    @Test
    public void test_countDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t = new Thread(() -> {
            countDownLatch.countDown();
            countDownLatch.countDown();
        });
        t.start();
        countDownLatch.await();

        assertEquals(0, countDownLatch.getCount());
    }

    /**
     * 我们观察到，即使有20个不同的线程调用countDown（），计数达到零也不会重置。
     * @throws InterruptedException
     */
    @Test
    public void test_countDownLatch_count() throws InterruptedException {
        List<String> outputScraper = Collections.synchronizedList(new ArrayList<>(16));
        CountDownLatch countDownLatch = new CountDownLatch(7);
        ExecutorService es = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            es.execute(() -> {
                long prevValue = countDownLatch.getCount();
                countDownLatch.countDown();
                 long afterValue = countDownLatch.getCount();
                if (afterValue != prevValue) {
                    log.info("prevValue {} afterValue {}",prevValue,afterValue);
                    outputScraper.add("Count Updated");
                }
            });
        }
        es.shutdown();
        log.info("outputScraper size {}", outputScraper.size());
        assertTrue(outputScraper.size() <= 7);
    }

    /**
     * 我们观察到，即使有20个不同的线程调用countDown（），计数达到零重置。
     * @throws InterruptedException
     */
    @Test
    public void test_cyclicBarrier_count() throws InterruptedException {
        List<String> outputScraper = Collections.synchronizedList(new ArrayList<>(16));
//等待线程数达到7即执行下一步操作
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7);
        ExecutorService es = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            es.execute(() -> {
                try {
                    //Returns the number of parties currently waiting at the barrier
                    long prevValue = cyclicBarrier.getNumberWaiting();
                    if (prevValue <= 0) {
                        outputScraper.add("Count Updated");
                    }
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    // error handling
                }
            });
        }
        es.shutdown();

        try {
            es.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TimeUnit.SECONDS.sleep(5);
        log.info("outputScraper size {} {}", outputScraper.size(),cyclicBarrier.getNumberWaiting());
        assertTrue(outputScraper.size() > 7);

    }

}
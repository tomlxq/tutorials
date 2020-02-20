package com.tom.cyclicbarriervscountdownlatch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
@Slf4j
public class CyclicBarrierDemoTest {
    /**
     * 这里的第一个区别是正在等待的线程本身就是障碍。
     * 其次，更重要的是，第二个await（）是无用的。 单个线程无法两次向下计数障碍。
     * 的确，因为t必须等待另一个线程调用await（）才能使计数增加到2，
     * 所以第二个对await（）的调用实际上不会被调用，直到屏障已经被打破！
     * 在我们的测试中，没有越过障碍，因为我们只有一个线程在等待，而没有两个线程将使障碍被触发。
     * 从CyclicBarrier.isBroken（）方法也很明显，该方法返回false。
     */
    @Test
    public void test_cyclicBarrier() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        Thread t = new Thread(() -> {
            try {
                cyclicBarrier.await();
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                // error handling
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        assertEquals(1, cyclicBarrier.getNumberWaiting());
        assertFalse(cyclicBarrier.isBroken());
    }

    @Test
    public void test_cyclicBarrier_twice() throws InterruptedException {
         ExecutorService executorService = Executors.newFixedThreadPool(2);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        IntStream.rangeClosed(1,2).forEach(idx->{
            Thread t1 = new Thread(() -> {
                try {
                    log.info("execute {} getNumberWaiting {}",Thread.currentThread().getName(),cyclicBarrier.getNumberWaiting());
                    cyclicBarrier.await();
                    log.info("execute {} getNumberWaiting {}",Thread.currentThread().getName(),cyclicBarrier.getNumberWaiting());
                } catch (InterruptedException | BrokenBarrierException e) {
                    // error handling
                }
            });
           // t1.start();
            log.info("execute {} getNumberWaiting {}",Thread.currentThread().getName(),cyclicBarrier.getNumberWaiting());
            executorService.submit(t1);
            log.info("execute {} getNumberWaiting {}",Thread.currentThread().getName(),cyclicBarrier.getNumberWaiting());
        });
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(1);
        assertEquals(0, cyclicBarrier.getNumberWaiting());
        assertFalse(cyclicBarrier.isBroken());
    }


}
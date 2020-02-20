package com.tom.concurrent.cyclicbarrier;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class CyclicBarrierCompletionMethodExample {

    private int count;
    /**
     * 线程数量
     */
    private int threadCount;
    private final AtomicInteger updateCount;

    CyclicBarrierCompletionMethodExample(int count, int threadCount) {
        updateCount = new AtomicInteger(0);
        this.count = count;
        this.threadCount = threadCount;
    }

    /**
     * 计算到达公共执行点的线程数
     *
     * @return 到达公共执行点的线程数
     */
    public int countTrips() {
        /**
         * CyclicBarrier的构造函数很简单。 它使用一个整数来表示需要在屏障实例上调用await（）方法以表示到达公共执行点的线程数
         * 第二个参数传递给构造函数，即Runnable实例。 这具有将由绊倒障碍的最后一个线程运行的逻辑
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count, () -> {
            log.info("{}", updateCount.get());
            updateCount.incrementAndGet();
        });
//初始化线程池，个数为threadCount
        ExecutorService es = Executors.newFixedThreadPool(threadCount);
        //执行任务
        for (int i = 0; i < threadCount; i++) {
            es.execute(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        //关闭线程池
        es.shutdown();
        try {
            //阻塞直到关闭请求后所有任务完成执行，或者发生超时，或者当前线程被中断（以先发生者为准）。
            es.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return updateCount.get();
    }


}

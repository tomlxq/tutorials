package com.tom.concurrent.locks;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */
class StampedLockDemoTest {

    @Test
    void testStampedLockDemo() {

            final int threadCount = 4;
            final ExecutorService service = Executors.newFixedThreadPool(threadCount);
            StampedLockDemo object = new StampedLockDemo();

            Runnable writeTask = () -> {

                try {
                    object.put("key1", "value1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Runnable readTask = () -> {

                try {
                    object.get("key1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Runnable readOptimisticTask = () -> {

                try {
                    object.readWithOptimisticLock("key1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            service.submit(writeTask);
            service.submit(writeTask);
            service.submit(readTask);
            service.submit(readOptimisticTask);

            service.shutdown();


    }
}
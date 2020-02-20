package com.tom.concurrency.executorservice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
@Slf4j
class TaskTest {
    ExecutorService executor = null;

    @BeforeEach
    void setUp() {
        executor = Executors.newFixedThreadPool(10);
    }

    @Test
    void run() {
        executor.submit(new Task());
        executor.submit(() -> {
            new Task();
        });
        //it waits till the all submitted task finish executing.
        // executor.shutdown();
        //which immediately terminates all the pending/executing tasks.
        // executor.shutdownNow();
        //which forcefully blocks until all tasks have completed execution after a shutdown event triggered or execution-timeout occurred, or the execution thread itself is interrupted,
        try {
            executor.awaitTermination(20l, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void invoke() throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<String> future = executorService.submit(() -> {
            // ...
            Thread.sleep(10000l);
            return "Hello world";
        });

        if (future.isDone() && !future.isCancelled()) {
            try {
                String str = future.get(10, TimeUnit.SECONDS);;
                log.info("{}", str);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }
        System.in.read();
    }
}
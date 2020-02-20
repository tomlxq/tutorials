package com.tom.executorservicefinish;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.tom.executorservicefinish.ExecutorServiceWaitTermination.awaitTerminationAfterShutdown;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */
public class ExecutorServiceWaitTerminationTest {
    ExecutorService threadPool = null;


    @BeforeEach
    void setUp() {
        threadPool = Executors.newFixedThreadPool(5);
    }

    @Test
    void test_shutdown_gracefully() {
        threadPool.execute(() -> {
            System.out.println("渣渣");
        });
        awaitTerminationAfterShutdown(threadPool);
        Assert.assertTrue(threadPool.isShutdown());
    }


}
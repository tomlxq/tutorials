package com.tom.executorservicefinish;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

import static com.tom.executorservicefinish.ExecutorServiceWaitTermination.awaitTerminationAfterShutdown;
import static org.junit.Assert.assertTrue;


/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */
class InvokeAllToFinishTest {
    ExecutorService WORKER_THREAD_POOL = Executors.newFixedThreadPool(10);

    @Test
    public void givenMultipleThreads_whenInvokeAll_thenMainThreadShouldWaitForAllToFinish() {



        List<Callable<String>> callables = Arrays.asList(
                new DelayedCallable("fast thread", 100),
                new DelayedCallable("slow thread", 3000));

        try {
            long startProcessingTime = System.currentTimeMillis();
            List<Future<String>> futures = WORKER_THREAD_POOL.invokeAll(callables);

            awaitTerminationAfterShutdown(WORKER_THREAD_POOL);

            try {
                WORKER_THREAD_POOL.submit((Callable<String>) () -> {
                    Thread.sleep(1000000);
                    return null;
                });
            } catch (RejectedExecutionException ex) {
                //
            }

            long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
            assertTrue(totalProcessingTime >= 3000);

            String firstThreadResponse = futures.get(0)
                    .get();
            assertTrue("First response should be from the fast thread", "fast thread".equals(firstThreadResponse));

            String secondThreadResponse = futures.get(1)
                    .get();
            assertTrue("Last response should be from the slow thread", "slow thread".equals(secondThreadResponse));

        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }


}
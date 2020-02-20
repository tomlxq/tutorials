package com.tom.executorservicefinish;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.tom.executorservicefinish.ExecutorServiceWaitTermination.awaitTerminationAfterShutdown;
import static org.junit.Assert.assertTrue;


/**
 * 运行多个线程的另一种方法是使用ExecutorCompletionService。 它使用提供的ExecutorService执行任务。
 * 与invokeAll（）的不同之处在于，返回表示执行任务的期货的顺序。
 * ExecutorCompletionService使用队列按照结果完成的顺序存储结果
 * 而invokeAll（）返回的列表具有与给定任务列表的迭代器相同的顺序
 *
 * @author TomLuo
 * @date 2020/2/15
 */
@Slf4j
class CompletionServiceToFinishTest {
    private final static ExecutorService WORKER_THREAD_POOL = Executors.newFixedThreadPool(10);
    @Test
    public void givenMultipleThreads_whenUsingCompletionService_thenMainThreadShouldWaitForAllToFinish() {

        CompletionService<String> service = new ExecutorCompletionService<>(WORKER_THREAD_POOL);

        List<Callable<String>> callables = Arrays.asList(
                new DelayedCallable("fast thread", 100),
                new DelayedCallable("slow thread", 3000));

        for (Callable<String> callable : callables) {
            service.submit(callable);
        }

        try {

            long startProcessingTime = System.currentTimeMillis();

            Future<String> future = service.take();
            String firstThreadResponse = future.get();
            long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;

            assertTrue("First response should be from the fast thread", "fast thread".equals(firstThreadResponse));
            assertTrue(totalProcessingTime >= 100 && totalProcessingTime < 1000);
            log.debug("Thread finished after: " + totalProcessingTime + " milliseconds");
//The results can be accessed using the take() method
            future = service.take();
            String secondThreadResponse = future.get();
            totalProcessingTime = System.currentTimeMillis() - startProcessingTime;

            assertTrue("Last response should be from the slow thread", "slow thread".equals(secondThreadResponse));
            assertTrue(totalProcessingTime >= 3000 && totalProcessingTime < 4000);
            log.debug("Thread finished after: " + totalProcessingTime + " milliseconds");

        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            awaitTerminationAfterShutdown(WORKER_THREAD_POOL);
        }
    }
}
package com.tom.threadpool;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/13
 */
@Slf4j
public class JavaThreadPoolTest {
    @Test
    public void testExecutors() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Hello World"));
    }

    @Test
    public void testExecutorService() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> "Hello World");
        // some operations
        String result = future.get();
        log.info("{}", result);
        assertEquals(result, "Hello World");
    }

    @Test
    public void testFixedPool() {

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.submit(() ->

        {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() ->

        {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() ->

        {
            Thread.sleep(1000);
            return null;
        });

        assertEquals(2, executor.getPoolSize());

        assertEquals(1, executor.getQueue().

                size());
    }

    /**
     * This method does not receive a number of threads at all. The corePoolSize is actually set to 0,
     * and the maximumPoolSize is set to Integer.MAX_VALUE for this instance.
     * The keepAliveTime is 60 seconds for this one.
     */
    @Test
    public void testCachedPool() {
        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });

        assertEquals(3, executor.getPoolSize());
        assertEquals(0, executor.getQueue().size());
    }

    /**
     * The corePoolSize and maximumPoolSize parameters are equal to 1,
     * and the keepAliveTime is zero.
     */
    @Test
    public void testSinglePool() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            counter.set(1);
        });
        executor.submit(() -> {
            counter.compareAndSet(1, 2);
        });
        TimeUnit.SECONDS.sleep(2);
        assertEquals(2, counter.get());


    }

    @Test
    public void testScheduledPool() throws IOException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.schedule(() ->
        {
            System.out.println("Hello World");
        }, 500, TimeUnit.MILLISECONDS);
       System.in.read();
    }
    @Test
    public void testScheduledFixedRate() throws InterruptedException {
        CountDownLatch lock = new CountDownLatch(3);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
            System.out.println("Hello World");
            lock.countDown();
        }, 500, 100, TimeUnit.MILLISECONDS);

        lock.await(1000, TimeUnit.MILLISECONDS);
        future.cancel(true);
    }
    @Test
    public void testGuava() throws InterruptedException {
        Executor executor = MoreExecutors.directExecutor();

        AtomicBoolean executed = new AtomicBoolean();

        executor.execute(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executed.set(true);
        });

        assertTrue(executed.get());
    }
    @Test
    public void testExitExecutorService() {
        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        ExecutorService executorService =
                MoreExecutors.getExitingExecutorService(executor,
                        100, TimeUnit.MILLISECONDS);

        executorService.submit(() -> {
            while (true) {
            }
        });
    }
    @Test
    public void testResultGuava() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ListeningExecutorService listeningExecutorService =
                MoreExecutors.listeningDecorator(executorService);

        ListenableFuture<String> future1 =
                listeningExecutorService.submit(() -> "Hello");
        ListenableFuture<String> future2 =
                listeningExecutorService.submit(() -> "World");

        String greeting = Futures.allAsList(future1, future2).get()
                .stream()
                .collect(Collectors.joining(" "));
        assertEquals("Hello World", greeting);
    }
}
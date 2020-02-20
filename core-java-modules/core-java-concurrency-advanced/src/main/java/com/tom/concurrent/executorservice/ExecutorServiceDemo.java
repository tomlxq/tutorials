package com.tom.concurrent.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Executors.html
 * Keeping an unused ExecutorService alive: There is a detailed explanation in section 4 of this article about how to shut down an ExecutorService;
 *
 * Wrong thread-pool capacity while using fixed length thread-pool: It is very important to determine how many threads the application will need to execute tasks efficiently. A thread-pool that is too large will cause unnecessary overhead just to create threads which mostly will be in the waiting mode. Too few can make an application seem unresponsive because of long waiting periods for tasks in the queue;
 *
 * Calling a Future‘s get() method after task cancellation: An attempt to get the result of an already canceled task will trigger a CancellationException.
 *
 * Unexpectedly-long blocking with Future‘s get() method: Timeouts should be used to avoid unexpected waits.
 *
 * @author TomLuo
 * @date 2020/2/14
 */
public class ExecutorServiceDemo {
    ExecutorService executor = Executors.newFixedThreadPool(10);

    /**
     * You may notice that the code above is very similar to the source code of the factory method newSingleThreadExecutor()
     *
     * @return
     */
    public ExecutorService genCustomizedExecutorService() {
        ExecutorService executorService =
                new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());
        return executorService;
    }

}

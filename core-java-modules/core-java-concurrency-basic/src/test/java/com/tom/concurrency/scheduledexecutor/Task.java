package com.tom.concurrency.scheduledexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class Task {
    public void execute() {
        ScheduledExecutorService executorService
                = Executors.newSingleThreadScheduledExecutor();

        Future<String> future = executorService.schedule(() -> {
            // ...
            return "Hello world";
        }, 1, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFuture = executorService.schedule(() -> {
            // ...
        }, 1, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(() -> {
            // ...
        }, 1, 10, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay(() -> {
            // ...
        }, 1, 10, TimeUnit.SECONDS);

        executorService.shutdown();
    }
}

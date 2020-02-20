package com.tom.concurrent.executorservice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/14
 */
@Slf4j
class ScheduledExecutorServiceDemoTestTest {
    ScheduledExecutorService executorService=null;
    @BeforeEach
    void setUp() {
         executorService = Executors
                .newSingleThreadScheduledExecutor();
    }

    @Test
    void testOneTask() throws IOException {
        Callable<String> callableTask=()->{
            log.info("{}",new Date());
            return
                "hello";
        };
        Future<String> resultFuture =
                executorService.schedule(callableTask, 1, TimeUnit.SECONDS);
        System.in.read();
    }
    @Test
    void testOneTask2() throws IOException {
        Runnable callableTask=()->{
            log.info("{}",new Date());

        };
        ScheduledFuture<?> resultFuture = executorService
                .scheduleAtFixedRate(callableTask, 100, 450, TimeUnit.MILLISECONDS);
        System.in.read();
    }
    @Test
    void testOneTask3() throws IOException {
        Runnable task = () -> {
            log.info("{}", new Date());

        };
        executorService.scheduleWithFixedDelay(task, 100, 150, TimeUnit.MILLISECONDS);
        System.in.read();
    }

}
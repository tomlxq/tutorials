package com.tom.concurrent.executorservice;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/14
 */
@Slf4j
class ExecutorServiceDemoTestTest {
    ExecutorService executorService = null;

    @BeforeEach
    void setUp() {
        ExecutorServiceDemo executorServiceDemo = new ExecutorServiceDemo();
        executorService = executorServiceDemo.genCustomizedExecutorService();
    }

    @Test
    void name() throws ExecutionException, InterruptedException {
        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
//The execute() method is void, and it doesn't give any possibility to get the result of task's execution or to
// check the task's status (is it running or executed).
        executorService.execute(runnableTask);
//submit() submits a Callable or a Runnable task to an ExecutorService and returns a result of type Future.
        Future<String> future =
                executorService.submit(callableTask);
        log.info("{}", JSON.toJSONString(future, true));
//invokeAny() assigns a collection of tasks to an ExecutorService, causing each to be executed,
// and returns the result of a successful execution of one task (if there was a successful execution).
        String result = executorService.invokeAny(callableTasks);
        log.info("{}", JSON.toJSONString(result, true));
        //invokeAll() assigns a collection of tasks to an ExecutorService,
        // causing each to be executed,
        // and returns the result of all task executions in the form of a list of objects of type Future.
        List<Future<String>> futures = executorService.invokeAll(callableTasks);
        log.info("{}", JSON.toJSONString(futures, true));
    }

    @Test
    void test_shutdown() throws ExecutionException, InterruptedException {
        executorService.execute(() -> {
            System.out.println("hello");
        });
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        Assert.assertTrue(executorService.isShutdown());
    }
    @Test
    void test_future() throws ExecutionException, InterruptedException {
        Future<String> future = executorService.submit(()->{
            return "Task's execution";
        });
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        log.info("{}", JSON.toJSONString(result, true));
Assert.assertEquals(result,"Task's execution");
       // String result = future.get(200, TimeUnit.MILLISECONDS);
    }
    @Test
    void test_future_timeout() throws ExecutionException, InterruptedException {
        Future<String> future = executorService.submit(()->{
            return "Task's execution";
        });
        String result = null;
        try {
          result = future.get(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException| TimeoutException e) {
            e.printStackTrace();
        }
        log.info("{}", JSON.toJSONString(result, true));
        Assert.assertEquals(result,"Task's execution");



    }
    @Test
    void test_future_cancel() throws ExecutionException, InterruptedException {
        Future<String> future = executorService.submit(()->{
            return "Task's execution";
        });
        boolean canceled = future.cancel(true);
        boolean isCancelled = future.isCancelled();


        Assert.assertTrue(canceled);
        Assert.assertTrue(isCancelled);



    }
}
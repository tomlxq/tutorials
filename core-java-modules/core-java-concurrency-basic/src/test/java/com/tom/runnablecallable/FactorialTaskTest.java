package com.tom.runnablecallable;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/13
 */
public class FactorialTaskTest {
    ExecutorService executorService=null;
    @Before
    public void setUp() throws Exception {
        executorService= Executors.newSingleThreadExecutor();
    }


        @Test
        public void whenTaskSubmitted_ThenFutureResultObtained() throws ExecutionException, InterruptedException {
            FactorialTask task = new FactorialTask(5);
            Future<Integer> future = executorService.submit(task);

            assertEquals(120, future.get().intValue());
        }

    @Test(expected = ExecutionException.class)
    public void whenException_ThenCallableThrowsIt() throws ExecutionException, InterruptedException {

        FactorialTask task = new FactorialTask(-5);
        Future<Integer> future = executorService.submit(task);
        Integer result = future.get().intValue();
    }
    @Test
    public void whenException_ThenCallableDoesntThrowsItIfGetIsNotCalled(){
        FactorialTask task = new FactorialTask(-5);
        Future<Integer> future = executorService.submit(task);

        assertEquals(false, future.isDone());
    }


}
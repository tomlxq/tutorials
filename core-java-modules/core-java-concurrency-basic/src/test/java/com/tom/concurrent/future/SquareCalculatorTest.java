package com.tom.concurrent.future;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


import java.util.concurrent.CancellationException;
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
 * @date 2020/2/12
 */
@Slf4j
public class SquareCalculatorTest {
    ExecutorService executorService=null;

    ExecutorService executorService1=null;
    @Before
    public void setUp() throws Exception {
        executorService1= Executors.newFixedThreadPool(3);

         executorService = Executors.newSingleThreadExecutor();
    }

    @Test
    public  void calculate() throws InterruptedException, ExecutionException {

        Future<Integer> future = new SquareCalculator(executorService).calculate(10);

        while (!future.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }

        Integer result = future.get();
        System.out.println(result);
    }

    /**
     * the former will throw a TimeoutException if the task doesn't return before the specified timeout period
     *
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     */
    @Test
    public void calculate2() throws InterruptedException, ExecutionException, TimeoutException {
        Future<Integer> future = new SquareCalculator(executorService).calculate(10);

        while (!future.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }
        Integer result = future.get(500, TimeUnit.MILLISECONDS);
        System.out.println(result);
    }

    @Test(expected = CancellationException.class)
   public void calculate3() throws ExecutionException, InterruptedException {

        Future<Integer> future = new SquareCalculator(executorService).calculate(4);

        boolean canceled = future.cancel(true);

        log.info("{}",future.get());
        log.info("{}",canceled);
    }
    @Test
    public void calculate4() throws InterruptedException, ExecutionException {
        SquareCalculator squareCalculator = new SquareCalculator(executorService1);

        Future<Integer> future1 = squareCalculator.calculate(10);
        Future<Integer> future2 = squareCalculator.calculate(100);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        System.out.println(result1 + " and " + result2);

        executorService1.shutdown();
    }
}
package com.tom.threadrunnable;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/13
 */
@Slf4j
public class SimpleRunnableTest {
    ExecutorService executorService=null;
    @Before
    public void setUp() throws Exception {
        executorService= Executors.newSingleThreadExecutor();
    }
    @Test
    public void givenRunnable_whenRunIt_thenResult()
            throws Exception {
        Thread thread = new Thread(new SimpleRunnable(
                "SimpleRunnable executed using Thread"));
        thread.start();
        thread.join();
    }

    @Test
    public void givenARunnable_whenSubmitToES_thenResult()
            throws Exception {

        executorService.submit(new SimpleRunnable(
                "SimpleRunnable executed using ExecutorService")).get();
    }

    @Test
    public void givenARunnableLambda_whenSubmitToES_thenResult()
            throws Exception {

        executorService.submit(
                () -> log.info("Lambda runnable executed!"));
    }
}
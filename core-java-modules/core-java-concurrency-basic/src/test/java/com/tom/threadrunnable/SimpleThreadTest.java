package com.tom.threadrunnable;

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
public class SimpleThreadTest {
    ExecutorService executorService=null;
    @Before
    public void setUp() throws Exception {
        executorService= Executors.newSingleThreadExecutor();
    }
    @Test
    public void givenAThread_whenRunIt_thenResult()
            throws Exception {

        Thread thread = new SimpleThread(
                "SimpleThread executed using Thread");
        thread.start();
        thread.join();
    }


    @Test
    public void givenAThread_whenSubmitToES_thenResult()
            throws Exception {

        executorService.submit(new SimpleThread(
                "SimpleThread executed using ExecutorService")).get();
    }
}
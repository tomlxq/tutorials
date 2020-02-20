package com.tom.runnablecallable;

import org.junit.Before;
import org.junit.Test;

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
public class EventLoggingTaskTest {

    ExecutorService executorService=null;
    @Before
    public void setUp() throws Exception {
        executorService= Executors.newSingleThreadExecutor();
    }



    @Test
    public void run() {

            executorService = Executors.newSingleThreadExecutor();
            Future future = executorService.submit(new EventLoggingTask());
            executorService.shutdown();

    }
}
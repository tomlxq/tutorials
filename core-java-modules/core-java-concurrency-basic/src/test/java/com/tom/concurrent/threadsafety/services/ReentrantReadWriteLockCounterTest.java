package com.tom.concurrent.threadsafety.services;

import com.tom.concurrent.threadsafety.callables.ReentranReadWriteLockCounterCallable;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/17
 */
public class ReentrantReadWriteLockCounterTest {
    @Test
    public void whenCalledIncrementCounter_thenCorrect() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ReentrantReadWriteLockCounter counter = new ReentrantReadWriteLockCounter();
        Future<Integer> future1 = (Future<Integer>) executorService.submit(new ReentranReadWriteLockCounterCallable(counter));
        Future<Integer> future2 = (Future<Integer>) executorService.submit(new ReentranReadWriteLockCounterCallable(counter));

        // Just to make sure both are completed
        future1.get();
        future2.get();

        assertThat(counter.getCounter()).isEqualTo(2);
    }
}
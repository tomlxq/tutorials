package com.tom.concurrent.threadsafety.services;

import com.tom.concurrent.threadsafety.callables.ExtrinsicLockCounterCallable;
import com.tom.concurrent.threadsafety.callables.IntrinsicLockCounterCallable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
public class IntrinsicLockCounterTest {
    @Test
    public void whenCalledIncrementCounter_thenCorrect() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntrinsicLockCounter counter = new IntrinsicLockCounter();
        Future<Integer> future1 = (Future<Integer>) executorService.submit(new IntrinsicLockCounterCallable(counter));
        Future<Integer> future2 = (Future<Integer>) executorService.submit(new IntrinsicLockCounterCallable(counter));

        // Just to make sure both are completed
        future1.get();
        future2.get();

        assertThat(counter.getCounter()).isEqualTo(2);
    }
}
package com.tom.concurrent.threadsafety.services;

import com.tom.concurrent.threadsafety.callables.AtomicCounterCallable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
public class AtomicCounterTest {
    @Test
    public void test_atomic_counter() throws Exception {
        AtomicCounter atomicCounter = new AtomicCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future11 = (Future<Integer>) executorService.submit(new AtomicCounterCallable(atomicCounter));
        Future<Integer> future12 = (Future<Integer>) executorService.submit(new AtomicCounterCallable(atomicCounter));
        System.out.println(future11.get());
        System.out.println(future12.get());
    }

}
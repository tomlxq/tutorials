package com.tom.concurrent.threadsafety.callables;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/17
 */


import com.tom.concurrent.threadsafety.services.ReentrantReadWriteLockCounter;
import java.util.concurrent.Callable;

public class ReentranReadWriteLockCounterCallable implements Callable<Integer> {

    private final ReentrantReadWriteLockCounter counter;

    public ReentranReadWriteLockCounterCallable(ReentrantReadWriteLockCounter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }

}
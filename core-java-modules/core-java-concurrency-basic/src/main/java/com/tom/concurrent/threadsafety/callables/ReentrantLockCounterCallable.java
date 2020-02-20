package com.tom.concurrent.threadsafety.callables;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/17
 */


import com.tom.concurrent.threadsafety.services.ReentrantLockCounter;
import java.util.concurrent.Callable;

public class ReentrantLockCounterCallable implements Callable<Integer> {

    private final ReentrantLockCounter counter;

    public ReentrantLockCounterCallable(ReentrantLockCounter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}

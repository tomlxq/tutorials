package com.tom.concurrent.threadsafety.callables;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */


import com.tom.concurrent.threadsafety.services.IntrinsicLockCounter;

import java.util.concurrent.Callable;

public class IntrinsicLockCounterCallable implements Callable<Integer> {

    private final IntrinsicLockCounter counter;

    public IntrinsicLockCounterCallable(IntrinsicLockCounter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}

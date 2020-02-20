package com.tom.concurrent.threadsafety.callables;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */


import com.tom.concurrent.threadsafety.services.ExtrinsicLockCounter;
import java.util.concurrent.Callable;

public class ExtrinsicLockCounterCallable implements Callable<Integer> {

    private final ExtrinsicLockCounter counter;

    public ExtrinsicLockCounterCallable(ExtrinsicLockCounter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}

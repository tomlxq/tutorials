

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
package com.tom.concurrent.threadsafety.callables;

import com.tom.concurrent.threadsafety.services.Counter;
import java.util.concurrent.Callable;

public class CounterCallable implements Callable<Integer> {

    private final Counter counter;

    public CounterCallable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}
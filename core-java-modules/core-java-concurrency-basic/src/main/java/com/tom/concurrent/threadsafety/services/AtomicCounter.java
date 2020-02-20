package com.tom.concurrent.threadsafety.services;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子物体
 * 使用Java提供的一组原子类（包括AtomicInteger，AtomicLong，AtomicBoolean和AtomicReference）也可以实现线程安全。
 * 原子类允许我们执行线程安全的原子操作，而无需使用同步。 原子操作在单个机器级别的操作中执行。
 *
 * @author TomLuo
 * @date 2020/2/16
 */

public class AtomicCounter {

    private final AtomicInteger counter = new AtomicInteger();

    public void incrementCounter() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }
}
package com.tom.concurrent.threadsafety.services;

/**
 * ReadWriteLock锁实际上使用一对关联的锁，一个用于只读操作，另一个用于写操作。
 * 结果，只要没有线程写入资源，就有可能有许多线程在读取资源。 此外，将线程写入资源将阻止其他线程读取资源。
 *
 * @author TomLuo
 * @date 2020/2/17
 */


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockCounter {

    private int counter;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public ReentrantReadWriteLockCounter() {
        this.counter = 0;
    }

    public void incrementCounter() {
        writeLock.lock();
        try {
            counter += 1;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCounter() {
        readLock.lock();
        try {
            return counter;
        } finally {
            readLock.unlock();
        }
    }
}

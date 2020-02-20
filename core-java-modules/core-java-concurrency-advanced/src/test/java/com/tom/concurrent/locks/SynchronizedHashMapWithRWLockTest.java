package com.tom.concurrent.locks;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */
class SynchronizedHashMapWithRWLockTest {
    @Test
    void name() {
        final int threadCount = 3;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);
        SynchronizedHashMapWithRWLock object = new SynchronizedHashMapWithRWLock();

        service.execute(new Thread(new SynchronizedHashMapWithRWLock.Writer(object), "Writer"));
        service.execute(new Thread(new SynchronizedHashMapWithRWLock.Reader(object), "Reader1"));
        service.execute(new Thread(new SynchronizedHashMapWithRWLock.Reader(object), "Reader2"));

        service.shutdown();
    }


}
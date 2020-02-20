package com.tom.concurrent.locks;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */
@Slf4j
class SharedObjectWithLockTest {
    @Test
    void test_lock_or_tryLock() {


        final int threadCount = 2;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);
        final SharedObjectWithLock object = new SharedObjectWithLock();
        log.info("getCounter {} isLocked {}", object.getCounter(), object.isLocked());
        service.execute(object::perform);
        log.info("getCounter {} isLocked {}", object.getCounter(), object.isLocked());
        service.execute(object::performTryLock);
        log.info("getCounter {} isLocked {}", object.getCounter(), object.isLocked());
        service.shutdown();


    }
}
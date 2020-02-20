

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */
package com.tom.concurrent.locks;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

@Slf4j
public class SharedObjectWithLock {

    private ReentrantLock lock = new ReentrantLock(true);

    private int counter = 0;

    void perform() {

        lock.lock();
        log.info("Thread - " + Thread.currentThread().getName() + " acquired the lock");
        try {
            log.info("Thread - " + Thread.currentThread().getName() + " processing");
            counter++;
        } catch (Exception exception) {
            log.error(" Interrupted Exception ", exception);
        } finally {
            lock.unlock();
            log.info("Thread - " + Thread.currentThread().getName() + " released the lock");
        }
    }

    protected void performTryLock() {

        log.info("Thread - " + Thread.currentThread().getName() + " attempting to acquire the lock");
        try {
            boolean isLockAcquired = lock.tryLock(2, TimeUnit.SECONDS);
            if (isLockAcquired) {
                try {
                    log.info("Thread - " + Thread.currentThread().getName() + " acquired the lock");

                    log.info("Thread - " + Thread.currentThread().getName() + " processing");
                    sleep(1000);
                } finally {
                    lock.unlock();
                    log.info("Thread - " + Thread.currentThread().getName() + " released the lock");

                }
            }
        } catch (InterruptedException exception) {
            log.error(" Interrupted Exception ", exception);
        }
        log.info("Thread - " + Thread.currentThread().getName() + " could not acquire the lock");
    }

    public ReentrantLock getLock() {
        return lock;
    }

    boolean isLocked() {
        return lock.isLocked();
    }

    boolean hasQueuedThreads() {
        return lock.hasQueuedThreads();
    }

    int getCounter() {
        return counter;
    }



}
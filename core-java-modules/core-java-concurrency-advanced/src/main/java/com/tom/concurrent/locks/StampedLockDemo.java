package com.tom.concurrent.locks;

/**
 * StampedLock is introduced in Java 8. It also supports both read and write locks.
 * However, lock acquisition methods returns a stamp that is used to release a lock or to check if the lock is still valid
 *
 * @author TomLuo
 * @date 2020/2/15
 */


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

import static java.lang.Thread.sleep;
@Slf4j
public class StampedLockDemo {
    private Map<String, String> map = new HashMap<>();
    private final StampedLock lock = new StampedLock();

    public void put(String key, String value) throws InterruptedException {
        long stamp = lock.writeLock();

        try {
            log.info(Thread.currentThread().getName() + " acquired the write lock with stamp " + stamp);
            map.put(key, value);
        } finally {
            lock.unlockWrite(stamp);
            log.info(Thread.currentThread().getName() + " unlocked the write lock with stamp " + stamp);
        }
    }

    public String get(String key) throws InterruptedException {
        long stamp = lock.readLock();
        log.info(Thread.currentThread().getName() + " acquired the read lock with stamp " + stamp);
        try {
            sleep(5000);
            return map.get(key);

        } finally {
            lock.unlockRead(stamp);
            log.info(Thread.currentThread().getName() + " unlocked the read lock with stamp " + stamp);

        }

    }

    protected String readWithOptimisticLock(String key) throws InterruptedException {
        long stamp = lock.tryOptimisticRead();
        String value = map.get(key);

        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                sleep(5000);
                return map.get(key);

            } finally {
                lock.unlock(stamp);
                log.info(Thread.currentThread().getName() + " unlocked the read lock with stamp " + stamp);

            }
        }
        return value;
    }



}

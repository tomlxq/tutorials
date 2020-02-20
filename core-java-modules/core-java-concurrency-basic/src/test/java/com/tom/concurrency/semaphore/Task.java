package com.tom.concurrency.semaphore;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
@Slf4j
public class Task {

    static Semaphore semaphore = new Semaphore(10);

    public void execute() throws InterruptedException {

        log.info("Available permit : " + semaphore.availablePermits());
        log.info("Number of threads waiting to acquire: " +
                semaphore.getQueueLength());

        if (semaphore.tryAcquire()) {
            try {
                // ...
            }
            finally {
                semaphore.release();
            }
        }

    }
}

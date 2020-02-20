/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/11
 */
package com.tom.concurrent.sleepwait;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * Example of wait() and sleep() methods
 */
@Slf4j
public class WaitSleepExample {


    private static final Object LOCK = new Object();

    public static void main(String... args) throws InterruptedException {
        sleepWaitInSynchronizedBlocks();
    }

    private static void sleepWaitInSynchronizedBlocks() throws InterruptedException {
        // called on the thread
        Thread.sleep(1000);
        log.debug("Thread {} is woken after sleeping for 1 second",Thread.currentThread().getName() );

        synchronized (LOCK) {
            // called on the object, synchronization required
            LOCK.wait(1000);
            log.debug("Object {} is woken after waiting for 1 second", LOCK );
        }
    }

}

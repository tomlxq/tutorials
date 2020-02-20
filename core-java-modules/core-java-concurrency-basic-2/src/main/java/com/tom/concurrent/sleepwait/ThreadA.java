package com.tom.concurrent.sleepwait;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/11
 */
@Slf4j
public class ThreadA {


    private static final ThreadB b = new ThreadB();

    public static void main(String... args) throws InterruptedException {
        b.start();

        synchronized (b) {
            while (b.sum == 0) {
                log.debug("Waiting for ThreadB to complete...");
                //For wait(), the waking up process is a bit more complicated.
                // We can wake the thread by calling either the notify() or notifyAll() methods on the monitor that is being waited on.
                b.wait();
            }

            log.debug("ThreadB has completed. Sum from that thread is: " + b.sum);
        }
    }
}

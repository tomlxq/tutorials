package com.tom.concurrent.sleepwait;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/11
 */


/***
 * Example of waking up a waiting thread
 */
public class ThreadB extends Thread {
    int sum;

    @Override
    public void run() {
        synchronized (this) {
            int i = 0;
            while (i < 100000) {
                sum += i;
                i++;
            }
            //  wake up the waiting thread – by calling notify() on the monitor
            notify();
        }
    }
}

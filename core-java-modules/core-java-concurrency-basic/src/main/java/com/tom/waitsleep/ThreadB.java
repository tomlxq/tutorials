package com.tom.waitsleep;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/14
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
            notify();
        }
    }
}

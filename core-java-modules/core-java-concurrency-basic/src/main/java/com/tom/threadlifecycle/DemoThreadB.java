package com.tom.threadlifecycle;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
public class DemoThreadB implements Runnable {
    @Override
    public void run() {
        commonResource();
    }

    public static synchronized void commonResource() {
        while(true) {
            // Infinite loop to mimic heavy processing
            // 't1' won't leave this method
            // when 't2' try to enters this
        }
    }
}

package com.tom.concurrency.executorservice;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class Task implements Runnable {
    @Override
    public void run() {
        // task details
        System.out.println("execute task asynchronous "+Thread.currentThread().getName());
    }
}

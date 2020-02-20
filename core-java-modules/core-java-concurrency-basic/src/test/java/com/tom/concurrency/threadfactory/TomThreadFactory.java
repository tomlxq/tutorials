package com.tom.concurrency.threadfactory;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
@Slf4j
public class TomThreadFactory implements ThreadFactory {
    private int threadId;
    private String name;

    public TomThreadFactory(String name) {
        threadId = 1;
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread_" + threadId);
        log.info("created new thread with id : " + threadId +
                " and name : " + t.getName());
        threadId++;
        return t;
    }
}

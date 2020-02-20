package com.tom.threadrunnable;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/13
 */

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleRunnable implements Runnable {

    private String message;

    public SimpleRunnable(String message) {
        this.message=message;
    }

    // standard logger, constructor

    @Override
    public void run() {
        log.info(message);
    }
}

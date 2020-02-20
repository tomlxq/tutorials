package com.tom.threadrunnable;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/13
 */
@Slf4j
public class SimpleThread extends Thread {

    private String message;

    public SimpleThread(String message) {
        this.message = message;
    }

    // standard logger, constructor

    @Override
    public void run() {
        log.info(message);
    }
}

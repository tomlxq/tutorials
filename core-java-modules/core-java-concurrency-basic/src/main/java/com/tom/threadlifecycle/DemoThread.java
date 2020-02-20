package com.tom.threadlifecycle;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted", e);
        }
    }
}

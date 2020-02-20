package com.tom.threadlifecycle;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
@Slf4j
public class DemoThreadWS implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread interrupted", e);
        }

        log.info("{}",WaitingState.t1.getState());
    }
}

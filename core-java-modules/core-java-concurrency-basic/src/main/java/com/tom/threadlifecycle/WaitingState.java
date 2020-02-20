package com.tom.threadlifecycle;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
@Slf4j
    public class WaitingState implements Runnable {
        public static Thread t1;

   @Override
        public void run() {
            Thread t2 = new Thread(new DemoThreadWS());
            t2.start();

            try {
                t2.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread interrupted", e);
            }
        }
    }


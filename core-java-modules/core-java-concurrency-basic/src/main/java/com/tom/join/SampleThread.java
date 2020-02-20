package com.tom.join;

import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/14
 */
@Slf4j
 public    class SampleThread extends Thread {
        public int processingCount = 0;

        SampleThread(int processingCount) {
            this.processingCount = processingCount;
            log.info("Thread Created");
        }

        @Override
        public void run() {
            log.info("Thread " + this.getName() + " started");
            while (processingCount > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.info("Thread " + this.getName() + " interrupted");
                }
                processingCount--;
            }
            log.info("Thread " + this.getName() + " exiting");
        }
    }


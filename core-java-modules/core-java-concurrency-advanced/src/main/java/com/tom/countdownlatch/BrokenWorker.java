package com.tom.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */
public class BrokenWorker implements Runnable {
    private List<String> outputScraper;
    private CountDownLatch countDownLatch;

    public BrokenWorker(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        if (true) {
            throw new RuntimeException("Oh dear, I'm a BrokenWorker");
        }
        countDownLatch.countDown();
        outputScraper.add("Counted down");
    }
}

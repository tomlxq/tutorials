package com.tom.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */
public class WaitingWorker implements Runnable {

    private List<String> outputScraper;
    private CountDownLatch readyThreadCounter;
    private CountDownLatch callingThreadBlocker;
    private CountDownLatch completedThreadCounter;

    public WaitingWorker(
            List<String> outputScraper,
            CountDownLatch readyThreadCounter,
            CountDownLatch callingThreadBlocker,
            CountDownLatch completedThreadCounter) {

        this.outputScraper = outputScraper;
        this.readyThreadCounter = readyThreadCounter;
        this.callingThreadBlocker = callingThreadBlocker;
        this.completedThreadCounter = completedThreadCounter;
    }

    @Override
    public void run() {
        readyThreadCounter.countDown();
        try {
            callingThreadBlocker.await();
            doSomeWork();
            outputScraper.add("Counted down");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            completedThreadCounter.countDown();
        }
    }

    private void doSomeWork()  {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
    }
}

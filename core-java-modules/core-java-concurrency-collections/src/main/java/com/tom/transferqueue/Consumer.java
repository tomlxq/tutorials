package com.tom.transferqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;
@Slf4j
public class Consumer implements Runnable {

    private final TransferQueue<String> transferQueue;
    private final String name;
    final int numberOfMessagesToConsume;
    final AtomicInteger numberOfConsumedMessages = new AtomicInteger();

    Consumer(TransferQueue<String> transferQueue, String name, int numberOfMessagesToConsume) {
        this.transferQueue = transferQueue;
        this.name = name;
        this.numberOfMessagesToConsume = numberOfMessagesToConsume;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfMessagesToConsume; i++) {
            try {
                log.debug("Consumer: " + name + " is waiting to take element...");
                String element = transferQueue.take();
                longProcessing(element);
                log.debug("Consumer: " + name + " received element: " + element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void longProcessing(String element) throws InterruptedException {
        numberOfConsumedMessages.incrementAndGet();
        Thread.sleep(500);
    }
}
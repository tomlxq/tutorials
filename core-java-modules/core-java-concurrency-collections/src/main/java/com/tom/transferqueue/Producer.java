package com.tom.transferqueue;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;
@Slf4j
public class Producer implements Runnable {
    private final TransferQueue<String> transferQueue;
    private final String name;
    final Integer numberOfMessagesToProduce;
    final AtomicInteger numberOfProducedMessages = new AtomicInteger();

    Producer(TransferQueue<String> transferQueue, String name, Integer numberOfMessagesToProduce) {
        this.transferQueue = transferQueue;
        this.name = name;
        this.numberOfMessagesToProduce = numberOfMessagesToProduce;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfMessagesToProduce; i++) {
            try {
                log.debug("Producer: " + name + " is waiting to transfer...");
                boolean added = transferQueue.tryTransfer("A" + i, 4000, TimeUnit.MILLISECONDS);
                if (added) {
                    numberOfProducedMessages.incrementAndGet();
                    log.debug("Producer: " + name + " transferred element: A" + i);
                } else {
                    log.debug("can not add an element due to the timeout");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
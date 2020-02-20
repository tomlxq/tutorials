package com.tom.waitnotify;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/13
 */
@Slf4j
public class Receiver implements Runnable {
    private Data load;

    public Receiver(Data load) {
        this.load=load;
    }
    public void run() {
        for (String receivedMessage = load.receive();
             !"End".equals(receivedMessage);
             receivedMessage = load.receive()) {

            System.out.println(receivedMessage);

            // ...
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread interrupted", e);
            }
        }
    }
}

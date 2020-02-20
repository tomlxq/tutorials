package com.tom.waitnotify;

import lombok.extern.slf4j.Slf4j;

/**
 * The Sender is supposed to send a data packet to the Receiver
 * The Receiver cannot process the data packet until the Sender is finished sending it
 * Similarly, the Sender mustn't attempt to send another packet unless the Receiver has already processed the previous packet
 *
 * @author TomLuo
 * @date 2020/2/13
 */
@Slf4j
public class Data {
    private String packet;

    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                log.error("Thread interrupted", e);
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                log.error("Thread interrupted", e);
            }
        }
        transfer = true;

        notifyAll();
        return packet;
    }
}

package com.tom.concurrent.waitandnotify;

import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/5/15
 */
public class NetworkUnitTest {
    @Test
    public void givenSenderAndReceiverd() throws InterruptedException {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
        sender.join();
        receiver.join();
    }
}

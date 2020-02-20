package com.tom.waitnotify;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/13
 */
public class DataTest {
    @Test
    public void name() throws IOException {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
        System.in.read();
    }
}
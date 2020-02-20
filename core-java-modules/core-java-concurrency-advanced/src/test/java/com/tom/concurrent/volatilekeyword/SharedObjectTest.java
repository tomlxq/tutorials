package com.tom.concurrent.volatilekeyword;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/10
 */
class SharedObjectTest {

    @Test
    void getCount() throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(3);
        SharedObject sharedObject = new SharedObject();

        IntStream.range(0, 1000)
                .forEach(count ->
                        service.submit(sharedObject::incrementCount));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, sharedObject.getCount());
    }

    @Test
    public void whenOneThreadWrites_thenVolatileReadsFromMainMemory() throws InterruptedException {
        SharedObject sharedObject = new SharedObject();

        Thread writer = new Thread(() -> sharedObject.incrementCount());
        writer.start();
        Thread.sleep(100);

        Thread readerOne = new Thread(() -> {
            int valueReadByThread2 = sharedObject.getCount();
            assertEquals(1, valueReadByThread2);
        });
        readerOne.start();

        Thread readerTwo = new Thread(() -> {
            int valueReadByThread3 = sharedObject.getCount();
            assertEquals(1, valueReadByThread3);
        });
        readerTwo.start();

    }

    @Test
    public void whenTwoThreadWrites_thenVolatileReadsFromMainMemory() throws InterruptedException {
        SharedObject sharedObject = new SharedObject();
        Thread writerOne = new Thread(() -> sharedObject.incrementCount());
        writerOne.start();
        Thread.sleep(100);

        Thread writerTwo = new Thread(() -> sharedObject.incrementCount());
        writerTwo.start();
        Thread.sleep(100);

        Thread readerOne = new Thread(() -> {
            int valueReadByThread2 = sharedObject.getCount();
            assertEquals(2, valueReadByThread2);
        });
        readerOne.start();

        Thread readerTwo = new Thread(() -> {
            int valueReadByThread3 = sharedObject.getCount();
            assertEquals(2, valueReadByThread3);
        });
        readerTwo.start();

    }
}
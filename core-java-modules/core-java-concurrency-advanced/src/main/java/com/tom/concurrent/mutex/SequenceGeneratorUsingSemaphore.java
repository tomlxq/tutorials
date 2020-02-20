package com.tom.concurrent.mutex;

import java.util.concurrent.Semaphore;

/**
 * 与ReentrantLock一样，Semaphore类也在Java 1.5中引入。
 *
 * 在使用互斥锁的情况下，只有一个线程可以访问临界区，而信号量允许固定数量的线程访问临界区。 因此，我们还可以通过将信号量中允许的线程数设置为一个来实现互斥量。
 *
 * @author TomLuo
 * @date 2020/2/14
 */
public class SequenceGeneratorUsingSemaphore extends SequenceGenerator {

    private Semaphore mutex = new Semaphore(1);

    @Override
    public int getNextSequence() {
        try {
            mutex.acquire();
            return super.getNextSequence();
        } catch (InterruptedException e) {
            // exception handling code
            return super.getNextSequence();
        } finally {
            mutex.release();
        }

    }
}
package com.tom.concurrent.mutex;

import java.util.concurrent.locks.ReentrantLock;

/**
 * The ReentrantLock class was introduced in Java 1.5. It provides more flexibility and control than the synchronized keyword approach.
 *
 * @author TomLuo
 * @date 2020/2/14
 */
public class SequenceGeneratorUsingReentrantLock extends SequenceGenerator {

    private ReentrantLock mutex = new ReentrantLock();

    @Override
    public int getNextSequence() {
        try {
            mutex.lock();
            return super.getNextSequence();
        } finally {
            mutex.unlock();
        }
    }
}

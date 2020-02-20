package com.tom.concurrent.mutex;

/**
 * Every object in Java has an intrinsic lock associated with it. The synchronized method and the synchronized block use this intrinsic lock to restrict the access of the critical section to only one thread at a time.
 *
 * @author TomLuo
 * @date 2020/2/14
 */
public class SequenceGeneratorUsingSynchronizedMethod extends SequenceGenerator {

    @Override
    public synchronized int getNextSequence() {
        return super.getNextSequence();
    }

}
package com.tom.concurrent.mutex;

import com.google.common.util.concurrent.Monitor;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/14
 */
public class SequenceGeneratorUsingMonitor extends SequenceGenerator {

    private Monitor mutex = new Monitor();

    @Override
    public int getNextSequence() {
        mutex.enter();
        try {
            return super.getNextSequence();
        } finally {
            mutex.leave();
        }
    }

}

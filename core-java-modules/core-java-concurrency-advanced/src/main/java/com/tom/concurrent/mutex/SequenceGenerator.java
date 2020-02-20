package com.tom.concurrent.mutex;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/14
 */
public class SequenceGenerator {

    private int currentValue = 0;

    public int getNextSequence() {
        currentValue = currentValue + 1;
        return currentValue;
    }

}
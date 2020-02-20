package com.tom.runnablecallable;

import java.util.concurrent.Callable;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/13
 */
public class FactorialTask implements Callable<Integer> {
    int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        if(number < 0) {
            throw new InvalidParameterException("Number should be positive");
        }
        int fact = 1;
        // ...
        for (int count = number; count > 1; count--) {
            fact = fact * count;
        }

        return fact;
    }
}
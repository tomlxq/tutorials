/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
package com.tom.concurrent.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class SquareCalculator {

    private final ExecutorService executor;

    SquareCalculator(ExecutorService executor) {
        this.executor = executor;
    }

    Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }
}

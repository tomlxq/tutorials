

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */

package com.tom.concurrent.future;

import java.util.concurrent.RecursiveTask;

public class FactorialSquareCalculator extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 1L;

    final private Integer n;

    FactorialSquareCalculator(Integer n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        FactorialSquareCalculator calculator = new FactorialSquareCalculator(n - 1);
//By calling fork(), a non-blocking method, we ask ForkJoinPool to initiate the execution of this subtask.
        calculator.fork();
//he join() method will return the result from that calculation, to which we add the square of the number we are currently visiting.
        return n * n + calculator.join();
    }
}



/**
 * Stateless Implementations
 *
 * @author TomLuo
 * @date 2020/2/16
 */
package com.tom.concurrent.threadsafety.mathutils;

import java.math.BigInteger;

public class MathUtils {
    /**
     *  factorial（）方法是无状态确定性函数。 给定特定的输入，它将始终产生相同的输出。
     * 该方法既不依赖外部状态，也不维护状态。 因此，它被认为是线程安全的，并且可以同时被多个线程安全地调用。
     * 所有线程都可以安全地调用factorial（）方法，并且将获得预期的结果，而不会彼此干扰，
     * 并且不会更改该方法为其他线程生成的输出。
     * 因此，无状态实现是实现线程安全的最简单方法。
     * @param number
     * @return
     */
    public static BigInteger factorial(int number) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= number; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}

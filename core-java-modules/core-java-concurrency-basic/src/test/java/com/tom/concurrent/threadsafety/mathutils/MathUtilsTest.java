package com.tom.concurrent.threadsafety.mathutils;

import org.junit.Test;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
public class MathUtilsTest {

    @Test
    public void factorial() throws InterruptedException {
        new Thread(() -> {
            System.out.println(MathUtils.factorial(10));
        }).start();
        new Thread(() -> {
            System.out.println(MathUtils.factorial(5));
        }).start();
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void whenCalledFactorialMethod_thenCorrect() {
        assertThat(MathUtils.factorial(2)).isEqualTo(new BigInteger("2"));
    }
}
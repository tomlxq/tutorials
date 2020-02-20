package com.com.threadlocalrandom;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertTrue;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
@Slf4j
public class ThreadLocalRandomBenchMarkerTest {

    @Test
    public void randomValuesUsingRandom() throws Exception {

        ChainedOptionsBuilder options = new OptionsBuilder().include(ThreadLocalRandomBenchMarker.class.getSimpleName())
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .jvmArgs("-server");

        for (Integer i : ImmutableList.of(1, 2, 8, 32)) {
            new Runner(
                    options
                            .threads(i)
                            .build())
                    .run();
        }
    }

    @Test
    public void randomValuesUsingRandom2() throws Exception {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<Integer>> callables = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            callables.add(() -> {
                return random.nextInt();
            });
        }
        executor.invokeAll(callables);
    }

    @Test
    public void randomValuesUsingRandom3() throws Exception {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            callables.add(() -> {
                return ThreadLocalRandom.current().nextInt();
            });
        }
        executor.invokeAll(callables);
    }

    /**
     * 生成一个随机有界的int值，即一个介于给定下限和上限之间的值。
     */
    @Test
    public void givenUsingThreadLocalRandom_whenGeneratingRandomIntBounded_thenCorrect() {
        int leftLimit = 1;
        int rightLimit = 100;
        int generatedInt = ThreadLocalRandom.current().nextInt(leftLimit, rightLimit);

        assertTrue(generatedInt < rightLimit && generatedInt >= leftLimit);
    }

    /**
     * 根据Oracle文档，我们只需要调用ThreadLocalRandom.current（）方法，
     * 它将为当前线程返回ThreadLocalRandom的实例。
     * 然后，我们可以通过调用该类的可用实例方法来生成随机值。
     * <p>
     * 让我们生成一个没有任何限制的随机整数值：
     */
    @Test
    public void givenUsingThreadLocalRandom_whenGeneratingRandomIntUnbounded_thenCorrect() {
        int generatedInt = ThreadLocalRandom.current().nextInt();

        assertTrue(generatedInt < Integer.MAX_VALUE && generatedInt >= Integer.MIN_VALUE);
    }

    @Test
    public void givenUsingThreadLocalRandom_whenGeneratingRandomLongBounded_thenCorrect() {
        long leftLimit = 1L;
        long rightLimit = 100L;
        long generatedLong = ThreadLocalRandom.current().nextLong(leftLimit, rightLimit);

        assertTrue(generatedLong < rightLimit && generatedLong >= leftLimit);
    }

    @Test
    public void givenUsingThreadLocalRandom_whenGeneratingRandomLongUnbounded_thenCorrect() {
        long generatedInt = ThreadLocalRandom.current().nextLong();

        assertTrue(generatedInt < Long.MAX_VALUE && generatedInt >= Long.MIN_VALUE);
    }

    @Test
    public void givenUsingThreadLocalRandom_whenGeneratingRandomDoubleBounded_thenCorrect() {
        double leftLimit = 1D;
        double rightLimit = 100D;
        double generatedInt = ThreadLocalRandom.current().nextDouble(leftLimit, rightLimit);

        assertTrue(generatedInt < rightLimit && generatedInt >= leftLimit);
    }

    @Test
    public void givenUsingThreadLocalRandom_whenGeneratingRandomDoubleUnbounded_thenCorrect() {
        double generatedInt = ThreadLocalRandom.current().nextDouble();

        assertTrue(generatedInt < Double.MAX_VALUE && generatedInt >= Double.MIN_VALUE);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void givenUsingThreadLocalRandom_whenSettingSeed_thenThrowUnsupportedOperationException() {
        ThreadLocalRandom.current().setSeed(0l);
    }

    /**
     * Java 8还添加了nextGaussian（）方法来生成下一个正态分布的值，该值与生成器的序列的平均值为0.0，标准差为1.0。
     */
    @Test
    public void givenUsingThreadLocalRandom_nextGaussian() {
        double generatedInt = ThreadLocalRandom.current().nextGaussian();

        log.info("{}", generatedInt);

    }
}
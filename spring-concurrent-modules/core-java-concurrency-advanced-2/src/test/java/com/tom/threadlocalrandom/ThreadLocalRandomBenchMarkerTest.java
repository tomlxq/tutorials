package com.tom.threadlocalrandom;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/5/17
 */
public class ThreadLocalRandomBenchMarkerTest {
    @Test
    public void randomAndThreadLocalRandom() throws RunnerException {
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
}
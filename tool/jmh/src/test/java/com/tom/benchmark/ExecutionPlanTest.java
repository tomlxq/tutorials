package com.tom.benchmark;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.nio.charset.Charset;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
public class ExecutionPlanTest {

    /**
     * 启动基准测试过程的主类
     * @throws Exception
     */
    @Test
    public void test_benchMurmur3_128() throws Exception {

        ChainedOptionsBuilder options = new OptionsBuilder().include(ExecutionPlanBenchMarker.class.getSimpleName())
                .forks(1).warmupForks(1).mode(Mode.Throughput)
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
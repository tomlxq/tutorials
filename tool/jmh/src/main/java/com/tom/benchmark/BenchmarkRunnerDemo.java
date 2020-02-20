package com.tom.benchmark;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

import java.nio.charset.Charset;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
public class BenchmarkRunnerDemo  {
    /**
     * 利用@Benchmark注释（在任何公共类中）创建一个简单的基准
     * @Fork
     * value the value parameter controls how many times the benchmark will be executed
     * warmups parameter controls how many times a benchmark will dry run before results are collected
     */
    @Benchmark
    @Fork(value = 1, warmups = 2)
    @Warmup(iterations = 5)
    @BenchmarkMode(Mode.Throughput)
    public void init() {
        // Do nothing
    }

    /**
     * 启动基准测试过程的主类
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}

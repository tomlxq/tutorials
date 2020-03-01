package com.tom.enummap;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class EnumMapBenchmarkLiveTest {

    @State(Scope.Thread)
    public static class BenchmarkState {
        EnumMap<DummyEnum, String> enumMap = new EnumMap<>(DummyEnum.class);
        HashMap<DummyEnum, String> hashMap = new HashMap<>();
        TreeMap<DummyEnum, String> treeMap = new TreeMap<>();
        int len = DummyEnum.values().length;
        Random random = new Random();
        int randomIndex;

        @Setup(Level.Trial)
        public void setUp() {
            DummyEnum[] values = DummyEnum.values();
            for (int i = 0; i < len; i++) {
                enumMap.put(values[i], values[i].toString());
                hashMap.put(values[i], values[i].toString());
                treeMap.put(values[i], values[i].toString());
            }
        }

        @Setup(Level.Invocation)
        public void additionalSetup() {
            randomIndex = random.nextInt(len);
        }

    }

    @Benchmark
    public int benchmark01_EnumMapPut(BenchmarkState s) {
        s.enumMap.put(DummyEnum.values()[s.randomIndex], DummyEnum.values()[s.randomIndex].toString());
        return ++s.randomIndex;
    }

    @Benchmark
    public int benchmark01_HashMapPut(BenchmarkState s) {
        s.hashMap.put(DummyEnum.values()[s.randomIndex], DummyEnum.values()[s.randomIndex].toString());
        return ++s.randomIndex;
    }

    @Benchmark
    public int benchmark01_TreeMapPut(BenchmarkState s) {
        s.treeMap.put(DummyEnum.values()[s.randomIndex], DummyEnum.values()[s.randomIndex].toString());
        return ++s.randomIndex;
    }

    @Benchmark
    public int benchmark02_EnumMapGet(BenchmarkState s) {
        s.enumMap.get(DummyEnum.values()[s.randomIndex]);
        return ++s.randomIndex;
    }

    @Benchmark
    public int benchmark02_HashMapGet(BenchmarkState s) {
        s.hashMap.get(DummyEnum.values()[s.randomIndex]);
        return ++s.randomIndex;
    }

    @Benchmark
    public int benchmark02_TreeMapGet(BenchmarkState s) {
        s.treeMap.get(DummyEnum.values()[s.randomIndex]);
        return ++s.randomIndex;
    }

    @Benchmark
    public int benchmark03_EnumMapContainsKey(BenchmarkState s) {
        s.enumMap.containsKey(DummyEnum.values()[s.randomIndex]);
        return ++s.randomIndex;
    }

    @Benchmark
    public int benchmark03_HashMapContainsKey(BenchmarkState s) {
        s.hashMap.containsKey(DummyEnum.values()[s.randomIndex]);
        return ++s.randomIndex;
    }

    @Benchmark
    public int benchmark03_TreeMapContainsKey(BenchmarkState s) {
        s.treeMap.containsKey(DummyEnum.values()[s.randomIndex]);
        return ++s.randomIndex;
    }

    @Benchmark
    public int benchmark04_EnumMapContainsValue(BenchmarkState s) {
        s.enumMap.containsValue(DummyEnum.values()[s.randomIndex].toString());
        return ++s.randomIndex;
    }

    @Benchmark
    public int benchmark04_HashMapContainsValue(BenchmarkState s) {
        s.hashMap.containsValue(DummyEnum.values()[s.randomIndex].toString());
        return ++s.randomIndex;
    }

    @Benchmark
    public int benchmark04_TreeMapContainsValue(BenchmarkState s) {
        s.treeMap.containsValue(DummyEnum.values()[s.randomIndex].toString());
        return ++s.randomIndex;
    }

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                //基准测试类
                .include(EnumMapBenchmarkLiveTest.class.getSimpleName())
                //运行基准测试的线程数
                .threads(1)
                //在运行中使用的forks的数量
                .forks(0)
                //第一次基准测试可能失败吗?
                .shouldFailOnError(true)
                //GC应该在测量之间进行吗?
                .shouldDoGC(false)
                //forks的JVM参数
                .jvmArgs("-server")
                .build();
        new Runner(options).run();
    }
}
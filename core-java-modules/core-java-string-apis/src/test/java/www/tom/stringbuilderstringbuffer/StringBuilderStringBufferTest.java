package www.tom.stringbuilderstringbuffer;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * # Warmup: 20 iterations, 1 s each
 * # Measurement: 20 iterations, 1 s each
 * # Timeout: 10 min per iteration
 * # Threads: 1 thread, will synchronize iterations
 * # Benchmark mode: Throughput, ops/time
 *
 * @BenchmarkMode(Mode.Throughput) // 吞吐量
 * @OutputTimeUnit(TimeUnit.MILLISECONDS) // 结果所使用的时间单位
 * @State(Scope.Thread) // 每个测试线程分配一个实例
 * @Fork(2) // Fork进行的数目
 * @Warmup(iterations = 4) // 先预热4轮
 * @Measurement(iterations = 10) // 进行10轮测试
 *
 * @author TomLuo
 * @date 2020/1/22
 */

public class StringBuilderStringBufferTest {
    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(StringBuilderStringBuffer.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
    @State(Scope.Benchmark)
    public static class MyState {
        int iterations = 1000;
        String initial = "abc";
        String suffix = "def";
    }

    @Benchmark
    public StringBuffer benchmarkStringBuffer(MyState state) {
        StringBuffer stringBuffer = new StringBuffer(state.initial);
        for (int i = 0; i < state.iterations; i++) {
            stringBuffer.append(state.suffix);
        }
        return stringBuffer;
    }

    @Benchmark
    public StringBuilder benchmarkStringBuilder(MyState state) {
        StringBuilder stringBuilder = new StringBuilder(state.initial);
        for (int i = 0; i < state.iterations; i++) {
            stringBuilder.append(state.suffix);
        }
        return stringBuilder;
    }
}
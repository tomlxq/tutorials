package com.tom.benchmark;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * 现在，让我们研究如何通过利用State来执行比较琐碎，更具指示性的基准化哈希算法的任务。
 * 假设我们决定通过哈希密码几百次来增加对密码数据库的字典攻击的额外保护。
 *
 * 我们可以使用State对象来探索性能影响：
 *
 * @author TomLuo
 * @date 2020/2/16
 */
@State(Scope.Benchmark)
public class ExecutionPlan {
    /**
     * 字段iterations将与从由所述JMH注释@Param当它传递到基准方法适当的值来填充。
     */
    @Param({ "100", "200", "300", "500", "1000" })
    public int iterations;

    public Hasher murmur3;

    public String password = "4v3rys3kur3p455w0rd";

    /**
     * 每次调用基准测试之前，都会调用@Setup注释方法，并创建一个确保隔离的新Hasher。
     */
    @Setup(Level.Invocation)
    public void setUp() {
        murmur3 = Hashing.murmur3_128().newHasher();
    }


}

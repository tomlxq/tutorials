package com.tom.concurrent.mutex;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Google的Guava库的Monitor类是ReentrantLock类的更好替代方案。 根据其文档，与使用ReentrantLock的代码相比，使用Monitor的代码更具可读性，并且更不易出错。
 * First, we'll add the Maven dependency for Guava:
 * <dependency>
 *     <groupId>com.google.guava</groupId>
 *     <artifactId>guava</artifactId>
 *     <version>28.0-jre</version>
 * </dependency>
 *
 * @author TomLuo
 * @date 2020/2/14
 */
public class SequenceGeneratorUsingMonitorTest {
    @Test
    public void givenUnsafeSequenceGenerator_whenRaceCondition_thenExpectedBehavior() throws Exception {
        int count = 1000;
        Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGeneratorUsingMonitor(), count);
        Assert.assertEquals(count, uniqueSequences.size());
    }

    private Set<Integer> getUniqueSequences(SequenceGeneratorUsingMonitor generator, int count) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Set<Integer> uniqueSequences = new LinkedHashSet<>();
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            futures.add(executor.submit(generator::getNextSequence));
        }

        for (Future<Integer> future : futures) {
            uniqueSequences.add(future.get());
        }

        executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdown();

        return uniqueSequences;
    }
}
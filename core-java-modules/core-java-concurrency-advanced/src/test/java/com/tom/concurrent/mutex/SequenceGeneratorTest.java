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
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/14
 */
public class SequenceGeneratorTest {

    /**
     * Once we execute this test case, we can see that it fails most of the time with the reason similar to:
     * java.lang.AssertionError: expected:<1000> but was:<989>
     *   at org.junit.Assert.fail(Assert.java:88)
     *   at org.junit.Assert.failNotEquals(Assert.java:834)
     *   at org.junit.Assert.assertEquals(Assert.java:645)
     * The uniqueSequences is supposed to have the size equal to the number of times we've executed the getNextSequence method in our test case. However, this is not the case because of the race condition. Obviously, we don't want this behavior.
     * @throws Exception
     */
    @Test
    public void givenUnsafeSequenceGenerator_whenRaceCondition_thenUnexpectedBehavior() throws Exception {
        int count = 1000;
        Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGenerator(), count);
        Assert.assertNotEquals(count, uniqueSequences.size());
    }

    private Set<Integer> getUniqueSequences(SequenceGenerator generator, int count) throws Exception {
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
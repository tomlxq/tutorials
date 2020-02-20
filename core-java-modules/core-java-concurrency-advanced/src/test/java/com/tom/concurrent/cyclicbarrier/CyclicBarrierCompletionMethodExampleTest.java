package com.tom.concurrent.cyclicbarrier;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
public class CyclicBarrierCompletionMethodExampleTest {

    @Test
    public void countTrips() {
        CyclicBarrierCompletionMethodExample ex = new CyclicBarrierCompletionMethodExample(5, 3);
        System.out.println("Count : " + ex.countTrips());
    }
}
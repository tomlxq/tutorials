package com.tom.concurrent.cyclicbarrier;

import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/5/17
 */
public class CyclicBarrierDemoTest {
    @Test
    public void testCyclicBarrier() {
        CyclicBarrierDemo play = new CyclicBarrierDemo();
        play.runSimulation(5, 3);
    }
}
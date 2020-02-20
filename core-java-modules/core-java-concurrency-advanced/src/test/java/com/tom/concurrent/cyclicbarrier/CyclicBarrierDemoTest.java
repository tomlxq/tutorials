package com.tom.concurrent.cyclicbarrier;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
public class CyclicBarrierDemoTest {
    /**
     * 用5个线程初始化了循环屏障，每个线程在其计算过程中产生3个整数并将它们存储在结果列表中。
     * 一旦隔离栅被触发，最后一个使隔离栅被触发的线程将执行AggregatorThread中指定的逻辑，即–将线程产生的所有数字相加。
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @Test
    public void test_cyclicBarrier() {
        CyclicBarrierDemo play = new CyclicBarrierDemo();
        play.runSimulation(5, 3);
    }
}
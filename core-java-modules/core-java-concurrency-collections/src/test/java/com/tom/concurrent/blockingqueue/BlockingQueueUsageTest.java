package com.tom.concurrent.blockingqueue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/1
 */
@Slf4j
public class BlockingQueueUsageTest {
    @Test
    public void name() {
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>();
    }

    @Test
    public void test_producer_and_consumer() {
        //队列数
        int BOUND = 10;
        //生产者线程数
        int N_PRODUCERS = 4;
        //返回可用于Java虚拟机的处理器数量
        int N_CONSUMERS = Runtime.getRuntime().availableProcessors();
        log.info("可用于Java虚拟机的处理器数量-消费者数量：{}",N_CONSUMERS);
        int poisonPill = Integer.MAX_VALUE;
        log.info("最大整数值poisonPill：{}",poisonPill);
        //产生者与消费的比值
        int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;
        log.info("产生者与消费的比值poisonPillPerProducer：{}",poisonPillPerProducer);
        int mod = N_CONSUMERS % N_PRODUCERS;
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BOUND);

        for (int i = 1; i < N_PRODUCERS; i++) {
            new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer)).start();
        }

        for (int j = 0; j < N_CONSUMERS; j++) {
            new Thread(new NumbersConsumer(queue, poisonPill)).start();
        }

        new Thread(new NumbersProducer(queue, poisonPill, poisonPillPerProducer + mod)).start();
    }
}
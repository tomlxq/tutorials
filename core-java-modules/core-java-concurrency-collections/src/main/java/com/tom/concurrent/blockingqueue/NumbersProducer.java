package com.tom.concurrent.blockingqueue;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class NumbersProducer implements Runnable {
    /**
     * 队列
     */
    private final BlockingQueue<Integer> numbersQueue;
    private final int poisonPill;
    private final int poisonPillPerProducer;

    NumbersProducer(BlockingQueue<Integer> numbersQueue, int poisonPill, int poisonPillPerProducer) {
        this.numbersQueue = numbersQueue;
        this.poisonPill = poisonPill;
        this.poisonPillPerProducer = poisonPillPerProducer;
    }

    @Override
    public void run() {
        try {
            generateNumbers();
        } catch (InterruptedException e) {
            Thread.currentThread()
                    .interrupt();
        }
    }

    private void generateNumbers() throws InterruptedException {
        //产生100个随机数放，范围为0-100的整数放到队列numbersQueue
        for (int i = 0; i < 100; i++) {
            numbersQueue.put(ThreadLocalRandom.current()
                    .nextInt(100));
        }
        //它还需要毒药消息，以知道执行完成时将什么类型的消息放入队列中。 该消息需要放入poisonPillPerProducer时间队列中。
        for (int j = 0; j < poisonPillPerProducer; j++) {
            numbersQueue.put(poisonPill);
        }
        log.info("{}", JSON.toJSONString(numbersQueue, true));
    }
}
package com.tom.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class NumbersConsumer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final int poisonPill;

    NumbersConsumer(BlockingQueue<Integer> queue, int poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer number = queue.take();
                //从队列中获取整数后，它将检查消息是否为毒药，如果是，则执行线程完成。
                //否则，它将与当前线程的名称一起在标准输出上打印出结果。
                if (number.equals(poisonPill)) {
                    return;
                }
                String result = number.toString();
                System.out.println(Thread.currentThread().getName() + " result: " + result);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
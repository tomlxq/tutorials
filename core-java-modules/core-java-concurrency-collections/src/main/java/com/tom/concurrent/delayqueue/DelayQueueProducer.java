package com.tom.concurrent.delayqueue;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;


public class DelayQueueProducer implements Runnable {
    private BlockingQueue<DelayObject> queue;
    /**
     * 产生的元素数
     */
    private final Integer numberOfElementsToProduce;
    /**
     * 每条消息的延迟（以毫秒为单位）
     */
    private final Integer delayOfEachProducedMessageMilliseconds;

    DelayQueueProducer(BlockingQueue<DelayObject> queue,
                       Integer numberOfElementsToProduce,
                       Integer delayOfEachProducedMessageMilliseconds) {
        this.queue = queue;
        this.numberOfElementsToProduce = numberOfElementsToProduce;
        this.delayOfEachProducedMessageMilliseconds = delayOfEachProducedMessageMilliseconds;
    }

    /**
     * 当调用run（）方法时，它将元素放入队列，并在每次放置后休眠500毫秒
     */
    @Override
    public void run() {
        for (int i = 0; i < numberOfElementsToProduce; i++) {
            DelayObject object
                    = new DelayObject(UUID.randomUUID().toString(), delayOfEachProducedMessageMilliseconds);
            System.out.println("Put object = " + object);
            try {
                queue.put(object);
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
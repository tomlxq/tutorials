package com.tom.concurrent.delayqueue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DelayQueueIntegrationTest {
    @Test
    public void givenDelayQueue_whenProduceElement_thenShouldConsumeAfterGivenDelay() throws InterruptedException {
        //given
        ExecutorService executor = Executors.newFixedThreadPool(2);
        BlockingQueue<DelayObject> queue = new DelayQueue<>();
        int numberOfElementsToProduce = 2;
        int delayOfEachProducedMessageMilliseconds = 500;
        DelayQueueConsumer consumer = new DelayQueueConsumer(queue, numberOfElementsToProduce);
        DelayQueueProducer producer
                = new DelayQueueProducer(queue, numberOfElementsToProduce, delayOfEachProducedMessageMilliseconds);

        //when
        executor.submit(producer);
        executor.submit(consumer);

        //then
        executor.awaitTermination(5, TimeUnit.SECONDS);
        executor.shutdown();
        assertEquals(consumer.numberOfConsumedElements.get(), numberOfElementsToProduce);

    }

    @Test
    public void givenDelayQueue_whenProduceElementWithHugeDelay_thenConsumerWasNotAbleToConsumeMessageInGivenTime() throws InterruptedException {
        //given
        ExecutorService executor = Executors.newFixedThreadPool(2);
        BlockingQueue<DelayObject> queue = new DelayQueue<>();
        int numberOfElementsToProduce = 1;
        //延迟为10秒
        int delayOfEachProducedMessageMilliseconds = 10_000;
        DelayQueueConsumer consumer = new DelayQueueConsumer(queue, numberOfElementsToProduce);
        DelayQueueProducer producer
                = new DelayQueueProducer(queue, numberOfElementsToProduce, delayOfEachProducedMessageMilliseconds);

        //when
        executor.submit(producer);
        executor.submit(consumer);

        //then producer将在5秒钟后终止。由于DelayQueue的特性，使用方将无法使用队列中的消息，因为该元素尚未过期
        executor.awaitTermination(5, TimeUnit.SECONDS);
        executor.shutdown();
        assertEquals(consumer.numberOfConsumedElements.get(), 0);

    }

    @Test
    public void givenDelayQueue_whenProduceElementWithNegativeDelay_thenConsumeMessageImmediately() throws InterruptedException {
        //given
        ExecutorService executor = Executors.newFixedThreadPool(2);
        BlockingQueue<DelayObject> queue = new DelayQueue<>();
        int numberOfElementsToProduce = 1;
        int delayOfEachProducedMessageMilliseconds = -10_000;
        DelayQueueConsumer consumer = new DelayQueueConsumer(queue, numberOfElementsToProduce);
        DelayQueueProducer producer
                = new DelayQueueProducer(queue, numberOfElementsToProduce, delayOfEachProducedMessageMilliseconds);

        //when
        executor.submit(producer);
        executor.submit(consumer);

        //then
        executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdown();
        assertEquals(consumer.numberOfConsumedElements.get(), 1);

    }
}
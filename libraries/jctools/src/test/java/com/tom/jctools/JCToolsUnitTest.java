package com.tom.jctools;

import org.jctools.queues.SpscArrayQueue;
import org.jctools.queues.SpscChunkedArrayQueue;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class JCToolsUnitTest {

    @Test
    public void givenMultipleProducers_whenSpscQueueUsed_thenNoWarningOccurs() throws InterruptedException {
        //定义单个生产者单个消费者队列，容量为2
        SpscArrayQueue<Integer> queue = new SpscArrayQueue<Integer>(2);

        Thread producer1 = new Thread(() -> {
            //此实现仅对单个生产者线程正确
            queue.offer(1);
        });
        // 使该线程开始执行； Java虚拟机将调用此线程的{@code run}方法。
        producer1.start();
        //等待该线程死亡
        producer1.join();

        Thread producer2 = new Thread(() -> {
            queue.offer(2);
        });
        producer2.start();
        producer2.join();

        Set<Integer> fromQueue = new HashSet<>();
        Thread consumer = new Thread(() -> queue.drain(fromQueue::add));
        consumer.start();
        consumer.join();

        assertThat(fromQueue).containsOnly(1, 2);
    }

    @Test
    public void whenQueueIsFull_thenNoMoreElementsCanBeAdded() throws InterruptedException {
        SpscChunkedArrayQueue<Integer> queue = new SpscChunkedArrayQueue<>(8, 16);
        assertThat(queue.capacity()).isEqualTo(16);

        CountDownLatch startConsuming = new CountDownLatch(1);
        CountDownLatch awakeProducer = new CountDownLatch(1);
        AtomicReference<Throwable> error = new AtomicReference<>();
        Thread producer = new Thread(() -> {
            IntStream.range(0, queue.capacity()).forEach(i -> {
                assertThat(queue.offer(i)).isTrue();
            });
            assertThat(queue.offer(queue.capacity())).isFalse();
            startConsuming.countDown();
            try {
                awakeProducer.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            assertThat(queue.offer(queue.capacity())).isTrue();
        });
        producer.setUncaughtExceptionHandler((t, e) -> {
            error.set(e);
            startConsuming.countDown();
        });
        producer.start();

        startConsuming.await();

        if (error.get() != null) {
            fail("Producer's assertion failed", error.get());
        }

        Set<Integer> fromQueue = new HashSet<>();
        queue.drain(fromQueue::add);
        awakeProducer.countDown();
        producer.join();
        queue.drain(fromQueue::add);

        assertThat(fromQueue).containsAll(IntStream.range(0, 17).boxed().collect(Collectors.toSet()));
    }
}
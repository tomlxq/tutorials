package com.tom.concurrent.threadsafety.thread;

import java.util.Arrays;
import java.util.List;

/**
 * 在面向对象编程（OOP）中，对象实际上需要通过字段维护状态并通过一种或多种方法来实现行为。
 * 如果我们实际上需要维护状态，则可以通过将其字段设置为线程局部来创建不在线程之间共享状态的线程安全类。
 * 通过在Thread类中定义私有字段，我们可以轻松创建其字段为线程局部的类。
 * ThreadA ThreadB在这两种实现中，这些类都有自己的状态，但是不与其他线程共享。 因此，这些类是线程安全的。
 * @author TomLuo
 * @date 2020/2/16
 */
public class ThreadA extends Thread {

    private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Override
    public void run() {
        numbers.forEach(System.out::println);
    }
}
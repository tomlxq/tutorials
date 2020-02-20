/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
package com.tom.concurrent.threadsafety.services;

import lombok.Getter;

@Getter
public class Counter {
    /**
     * 使用volatile关键字，我们指示JVM和编译器将计数器变量存储在主内存中。
     * 这样，我们确保每次JVM读取计数器变量的值时，它实际上都会从主内存而不是从CPU缓存读取它。
     * 同样，每次JVM写入计数器变量时，该值也将写入主内存。
     */
    private volatile int counter;

    public Counter() {
        this.counter = 0;
    }

    public synchronized void incrementCounter() {
        counter += 1;
    }


}

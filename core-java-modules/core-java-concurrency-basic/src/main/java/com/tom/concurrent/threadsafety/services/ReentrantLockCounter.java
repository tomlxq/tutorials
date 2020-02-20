

/**
 * 对于固有锁，锁获取模型相当严格：一个线程获取锁，然后执行方法或代码块，最后释放锁，以便其他线程可以获取它并访问该方法。
 * 没有底层机制可以检查排队的线程并优先访问等待时间最长的线程。
 * ReentrantLock实例使我们能够做到这一点，从而防止排队的线程遭受某些类型的资源匮乏：
 *
 * @author TomLuo
 * @date 2020/2/17
 */
package com.tom.concurrent.threadsafety.services;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter {

    private int counter;
    /**
     * ReentrantLock构造函数采用一个可选的fairness布尔参数。
     * 当设置为true时，并且多个线程正在尝试获取锁，JVM将优先考虑等待时间最长的线程并授予对该锁的访问权限。
     */
    private final ReentrantLock reLock = new ReentrantLock(true);

    public ReentrantLockCounter() {
        this.counter = 0;
    }

    public void incrementCounter() {
        reLock.lock();
        try {
            counter += 1;
        } finally {
            reLock.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }
}

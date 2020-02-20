

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */
package com.tom.concurrent.threadsafety.services;

public class ExtrinsicLockCounter {

    private int counter;
    /**
     * 外部锁还提供了在多线程环境中对共享资源的协调访问，但是它使用外部实体来强制对资源的独占访问
     * 我们使用一个普通的Object实例创建一个外部锁。 此实现稍好一些，因为它可以提高锁定级别的安全性。
     * 使用内部锁定，其中同步方法和块依赖于此引用，攻击者可能会通过获取内部锁定并触发拒绝服务（DoS）条件来导致死锁。
     * 与它的内在对应物不同，外在锁使用私有实体，该私有实体无法从外部访问。 这使得攻击者更难获得锁并导致死锁。
     */
    private final Object lock = new Object();

    public ExtrinsicLockCounter() {
        this.counter = 0;
    }

    public void incrementCounter() {
        synchronized (lock) {
            counter += 1;
        }
    }

    public int getCounter() {
        synchronized (lock) {
            return counter;
        }
    }
}

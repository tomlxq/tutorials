

/**
 * 我们通过在方法签名的前面加上synchronized关键字来创建一个同步方法。
 * 由于一次一个线程可以访问一个同步方法，因此一个线程将执行incrementCounter（）方法，而其他线程将执行相同的操作。
 * 任何重叠的执行都不会发生。同步方法依赖于“内在锁”或“监视器锁”的使用。固有锁是与特定类实例关联的隐式内部实体。
 * 在多线程上下文中，术语“监视程序”只是对锁在关联对象上执行的角色的引用，因为它强制对一组指定的方法或语句进行独占访问。
 * 当线程调用同步方法时，它将获取内部锁。线程完成方法执行后，它释放锁，因此允许其他线程获取锁并获得对方法的访问。
 * 我们可以在实例方法，静态方法和语句（已同步的语句）中实现同步。
 *
 * @author TomLuo
 * @date 2020/2/16
 */
package com.tom.concurrent.threadsafety.services;

public class IntrinsicLockCounter {

    private int counter;


    public IntrinsicLockCounter() {
        this.counter = 0;
    }

    public synchronized void incrementCounter() {

        counter += 1;

    }

    public synchronized int getCounter() {

        return counter;

    }
}

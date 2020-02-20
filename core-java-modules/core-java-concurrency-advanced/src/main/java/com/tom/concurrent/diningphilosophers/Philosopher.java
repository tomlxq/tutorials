

/**
 * 哲学家类
 *
 * @author TomLuo
 * @date 2020/2/17
 */
package com.tom.concurrent.diningphilosophers;

public class Philosopher implements Runnable {
    /**
     * 左边的叉，final类，初始化后不能改
     */
    private final Object leftFork;
    /**
     * 右边的叉，final类，初始化后不能改
     */
    private final Object rightFork;

    Philosopher(Object left, Object right) {
        this.leftFork = left;
        this.rightFork = right;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    /**
     * 在这种情况下，每个哲学家都已获取了他的左叉，但无法获取他的右叉，因为他的邻居已经获取了。
     * 这种情况通常称为循环等待，是导致死锁并阻止系统前进的条件之一。
     */
    @Override
    public void run() {
        try {
            while (true) {
                //思考
                doAction(System.nanoTime() + ": Thinking");
                //同步左边叉
                synchronized (leftFork) {
                    //拿起左边的叉
                    doAction(System.nanoTime() + ": Picked up left fork");
                    //同步右边叉
                    synchronized (rightFork) {
                        //拿起右边叉，并吃饭
                        doAction(System.nanoTime() + ": Picked up right fork - eating");
                        //放下右边叉
                        doAction(System.nanoTime() + ": Put down right fork");
                    }
                    //放下左边叉，又开始思考
                    doAction(System.nanoTime() + ": Put down left fork. Returning to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

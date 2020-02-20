package com.tom.concurrent.diningphilosophers;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/18
 */
public class PhilosopherTest {

    @Test
    public void run() throws IOException {
        //该客户端创建5位哲学家作为线程并启动所有这些人
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {

            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];
//所有哲学家都首先伸手去拿左叉，除了首先伸手去拿右叉的人。
            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rightFork, leftFork); // The last philosopher picks up the right fork first
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }

            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
        System.in.read();
    }
}
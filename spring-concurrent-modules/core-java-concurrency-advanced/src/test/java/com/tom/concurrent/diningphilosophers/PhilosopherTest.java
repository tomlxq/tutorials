package com.tom.concurrent.diningphilosophers;

import org.junit.Test;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/5/17
 */
public class PhilosopherTest {
    @Test
    public void testPhilosopher_dead_lock() {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            philosophers[i] = new Philosopher(leftFork, rightFork);

            Thread t
                    = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }

    @Test
    public void testPhilosopher() {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {

            Object leftFork = forks[i];//0 1 2 3 4
            Object rightFork = forks[(i + 1) % forks.length];//1 2 3 4 0

            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rightFork, leftFork); // The last philosopher picks up the right fork first
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }

            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
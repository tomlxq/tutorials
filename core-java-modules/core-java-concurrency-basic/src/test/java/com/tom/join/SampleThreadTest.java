package com.tom.join;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * 当我们在线程上调用join（）方法时，调用线程进入等待状态。 它保持等待状态，直到引用的线程终止。
 *
 * @author TomLuo
 * @date 2020/2/14
 */
@Slf4j
public class SampleThreadTest {

    @Test
    public void givenStartedThread_whenJoinCalled_waitsTillCompletion()
            throws InterruptedException {
        Thread t2 = new SampleThread(1);
        t2.start();
        log.info("Invoking join");
        t2.join();
        log.info("Returned from join");
        assertFalse(t2.isAlive());
    }
    /**
     * 如果引用的线程被中断，join（）方法也可能返回。 在这种情况下，该方法将引发InterruptedException。
     *
     * 最后，如果引用的线程已经终止或尚未启动，则对join（）方法的调用将立即返回。
     */
    @Test
    public void givenStartedThread_whenJoinCalled_waitsTillCompletion2()
            throws InterruptedException {
        Thread t1 = new SampleThread(0);
        t1.join();  //returns immediately
        assertFalse(t1.isAlive());
    }

    @Test
    public void givenStartedThread_whenTimedJoinCalled_waitsUntilTimedout()
            throws InterruptedException {
        Thread t3 = new SampleThread(10);
        t3.start();
        //Waits at most millis milliseconds plus nanos nanoseconds for this thread to die.
        t3.join(1000);
        assertTrue(t3.isAlive());

    }

    /**
     * All actions in a thread happen-before any other thread successfully returns from a join() on that thread.
     * 这意味着当线程t1调用t2.join（）时，由t2完成的所有更改在返回时在t1中可见。
     * 但是，如果我们不调用join（）或使用其他同步机制，则不能保证即使另一个线程已完成，另一个线程的更改对于当前线程也是可见的。
     * @throws InterruptedException
     */
    @Test
    public void givenStartedThread_whenTimedJoinCalled_waitsUntilTimedout2()
            throws InterruptedException {
        SampleThread t4 = new SampleThread(10);
        t4.start();
// not guaranteed to stop even if t4 finishes.
        do {

        } while (t4.processingCount > 0);
    }
}
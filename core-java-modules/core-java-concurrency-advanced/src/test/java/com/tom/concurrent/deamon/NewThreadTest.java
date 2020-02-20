package com.tom.concurrent.deamon;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 用户线程是高优先级线程。 JVM将在终止它之前等待任何用户线程完成其任务。
 *
 * 另一方面，守护程序线程是低优先级线程，其唯一作用是为用户线程提供服务。
 *
 * 由于守护程序线程是为用户线程服务的，并且仅在用户线程运行时才需要，因此它们不会阻止JVM在所有用户线程完成执行后退出。
 *
 * 这就是通常存在于守护程序线程中的无限循环不会引起问题的原因，因为一旦所有用户线程完成执行，包括finally块在内的任何代码都将不会执行。 因此，不建议将守护程序线程用于I / O任务。
 *
 * 但是，此规则也有例外。 守护程序线程中设计不良的代码可能会阻止JVM退出。 例如，在正在运行的守护程序线程上调用Thread.join（）可能会阻止应用程序的关闭。
 *
 * @author TomLuo
 * @date 2020/2/14
 */
public class NewThreadTest {
    @Test(expected = IllegalThreadStateException.class)
    public void whenSetDaemonWhileRunning_thenIllegalThreadStateException() {
        NewThread daemonThread = new NewThread();
        daemonThread.start();
        daemonThread.setDaemon(true);
    }
    @Test
    public void whenCallIsDaemon_thenCorrect() {
        NewThread daemonThread = new NewThread();
        NewThread userThread = new NewThread();
        daemonThread.setDaemon(true);
        daemonThread.start();
        userThread.start();

        assertTrue(daemonThread.isDaemon());
        assertFalse(userThread.isDaemon());
    }
}
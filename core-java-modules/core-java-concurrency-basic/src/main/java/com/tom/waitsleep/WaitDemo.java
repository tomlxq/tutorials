package com.tom.waitsleep;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/14
 */
public class WaitDemo {

    private static Object LOCK = new Object();
    private static ThreadB b = new ThreadB();

    public static void sleepWaitExamples()
            throws InterruptedException {
//当我们使用sleep（）方法时，线程会在指定的时间间隔后启动，除非被中断.
        Thread.sleep(1000);
        System.out.println(
                "Thread '" + Thread.currentThread().getName() +
                        "' is woken after sleeping for 1 second");

        synchronized (LOCK) {
            //我们可以通过在正在等待的监视器上调用notify（）或notifyAll（）方法来唤醒线程。
//要唤醒所有处于等待状态的线程时，请使用notifyAll（）而不是notify（）。 与wait（）方法本身类似，必须从同步上下文中调用notify（）和notifyAll（）。
            LOCK.wait(1000);
            System.out.println("Object '" + LOCK + "' is woken after" +
                    " waiting for 1 second");
        }
    }

    public static void sleepWaitExamples2()
            throws InterruptedException {
        b.start();
        synchronized (b) {
            while (b.sum == 0) {
                System.out.println("Waiting for ThreadB to complete...");
                //然后线程可以唤醒等待的线程–通过在监视器上调用notify（）
                b.wait();
            }

            System.out.println("ThreadB has completed. " +
                    "Sum from that thread is: " + b.sum);
        }
    }
}

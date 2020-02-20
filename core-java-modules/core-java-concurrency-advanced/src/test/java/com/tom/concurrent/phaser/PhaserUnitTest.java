package com.tom.concurrent.phaser;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

import static junit.framework.TestCase.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhaserUnitTest {

    @Test
    public void givenPhaser_whenCoordinateWorksBetweenThreads_thenShouldCoordinateBetweenMultiplePhases() {
        //given
        ExecutorService executorService = Executors.newCachedThreadPool();
        //从主线程创建Phaser实例时，我们将传递1作为参数。 这等效于从当前线程调用register（）方法
        Phaser ph = new Phaser(1);
        //我们可以通过调用getPhase（）方法来获取当前的相数。初始化后的相位等于零。
        assertEquals(0, ph.getPhase());

        //when 三个线程将处理第一阶段
        // 启动三个LongRunningAction操作线程，这些线程将在屏障上等待，直到我们从主线程调用到达AndAndAwaitAdvance（）方法为止。
        executorService.submit(new LongRunningAction("thread-1", ph));
        executorService.submit(new LongRunningAction("thread-2", ph));
        executorService.submit(new LongRunningAction("thread-3", ph));

        //then
        /**
         * 线程通过调用到达方法arriveAndAwaitAdvance（）（这是一种阻塞方法）来表示已到达屏障。当
         * 到达的方数等于注册的方数时，程序将继续执行，并且阶段数将增加。
         *
         * 请记住，我们已将相位器初始化为1，并再调用了register（）3次。
         * 现在，三个动作线程已经宣布它们已经到达障碍，因此还需要再调用一次arriveAndAwaitAdvance（）－来自主线程的一个调用
         */
        ph.arriveAndAwaitAdvance();
        assertEquals(1, ph.getPhase());

        //and 两个线程将处理第二阶段
        executorService.submit(new LongRunningAction("thread-4", ph));
        executorService.submit(new LongRunningAction("thread-5", ph));
        /**
         * 我们可以利用Phaser来实现这一点，因为它允许我们动态配置应该在屏障上等待的线程数。
         * 我们正在启动两个新线程，但是直到从主线程（对前一种情况而言）调用该线程之后，它们才会继续执行：
         *
         */
        ph.arriveAndAwaitAdvance();
        /**
         * 此后，getPhase（）方法将返回等于2的相数。
         */
        assertEquals(2, ph.getPhase());

        //当线程完成其工作时，我们应该调用arriveAndDeregister()方法，以信号通知在该特定阶段不再考虑当前线程。
        //当我们要完成程序时，由于主线程仍在Phaser中注册，因此我们需要调用arriveAndDeregister（）方法。
        // 当注销导致注册方的数量变为零时，移相器终止。 所有对同步方法的调用将不再阻塞，并将立即返回。
        ph.arriveAndDeregister();
    }
}
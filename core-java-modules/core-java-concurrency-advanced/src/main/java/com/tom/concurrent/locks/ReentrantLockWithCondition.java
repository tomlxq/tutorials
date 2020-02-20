

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */
package com.tom.concurrent.locks;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
@Slf4j
public class ReentrantLockWithCondition {

   // private static Logger LOG = LoggerFactory.getLogger(ReentrantLockWithCondition.class);

    private Stack<String> stack = new Stack<>();
    private static final int CAPACITY = 5;

    private ReentrantLock lock = new ReentrantLock();
    private Condition stackEmptyCondition = lock.newCondition();
    private Condition stackFullCondition = lock.newCondition();

    protected void pushToStack(String item) throws InterruptedException {
        try {
            lock.lock();
            if (stack.size() == CAPACITY) {
                log.info(Thread.currentThread().getName() + " wait on stack full");
                stackFullCondition.await();
            }
            log.info("Pushing the item " + item);
            stack.push(item);
            stackEmptyCondition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    protected String popFromStack() throws InterruptedException {
        try {
            lock.lock();
            if (stack.size() == 0) {
                log.info(Thread.currentThread().getName() + " wait on stack empty");
                stackEmptyCondition.await();
            }
            return stack.pop();
        } finally {
            stackFullCondition.signalAll();
            lock.unlock();
        }
    }


}

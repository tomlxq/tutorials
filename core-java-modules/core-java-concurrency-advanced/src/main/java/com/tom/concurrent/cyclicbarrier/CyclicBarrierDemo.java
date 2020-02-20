package com.tom.concurrent.cyclicbarrier;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/16
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private CyclicBarrier cyclicBarrier;
    /**
     * 固定数量的线程执行并将相应的结果存储在列表中
     * 我们有partialResults，它是一个列表，将存储每个工作线程的结果。
     * 请注意，此列表是一个Collections.synchronizedList，因为多个线程将同时写入该列表，并且add（）方法在纯ArrayList上不是线程安全的。
     */
    private List<List<Integer>> partialResults = Collections.synchronizedList(new ArrayList<>());
    private Random random = new Random();
    /**
     * NUM_PARTIAL_RESULTS是每个工作线程将要产生的结果数。用于第个线程产生List<Integer> partialResult列表
     */
    private int NUM_PARTIAL_RESULTS;
    /**
     * NUM_WORKERS是要执行的线程数
     */
    private int NUM_WORKERS;

    protected void runSimulation(int numWorkers, int numberOfPartialResults) {
        NUM_PARTIAL_RESULTS = numberOfPartialResults;
        NUM_WORKERS = numWorkers;

        cyclicBarrier = new CyclicBarrier(NUM_WORKERS, new AggregatorThread());
        System.out.println("Spawning " + NUM_WORKERS + " worker threads to compute " + NUM_PARTIAL_RESULTS + " partial results each");
        //定义线程
        for (int i = 0; i < NUM_WORKERS; i++) {
            Thread worker = new Thread(new NumberCruncherThread());
            worker.setName("Thread " + i);
            worker.start();
        }
    }

    class NumberCruncherThread implements Runnable {

        @Override
        public void run() {
            String thisThreadName = Thread.currentThread().getName();

            List<Integer> partialResult = new ArrayList<>();
            for (int i = 0; i < NUM_PARTIAL_RESULTS; i++) {
                Integer num = random.nextInt(10);
                System.out.println(thisThreadName + ": Crunching some numbers! Final result - " + num);
                partialResult.add(num);
            }
            partialResults.add(partialResult);
            try {
                System.out.println(thisThreadName + " waiting for others to reach barrier.");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  实现在障碍解除后运行的逻辑
     *  当所有线程完成执行其操作时，其中一个AggregatorThread（通常是最后一个使障碍跳开的线程）开始处理由每个线程获取的数据。
     */
    class AggregatorThread implements Runnable {

        @Override
        public void run() {
            String thisThreadName = Thread.currentThread().getName();
            System.out.println(thisThreadName + ": Computing final sum of " + NUM_WORKERS + " workers, having " + NUM_PARTIAL_RESULTS + " results each.");
            int sum = 0;
            for (List<Integer> threadResult : partialResults) {
                System.out.print("Adding ");
                for (Integer partialResult : threadResult) {
                    System.out.print(partialResult + " ");
                    sum += partialResult;
                }
                System.out.println();
            }
            System.out.println(Thread.currentThread().getName() + ": Final result = " + sum);
        }

    }



}

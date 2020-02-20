package com.tom.threadpool;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/13
 */
public class CountingTaskTest {

    @Test
    public void compute() {
        TreeNode tree = new TreeNode(5,
                new TreeNode(3), new TreeNode(2,
                new TreeNode(2), new TreeNode(8)));

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        int sum = forkJoinPool.invoke(new CountingTask(tree));
        Assert.assertEquals(sum,20);
    }
}
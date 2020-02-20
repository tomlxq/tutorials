package com.tom.threadpool;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/13
 */
public  class CountingTask extends RecursiveTask<Integer> {

    private final TreeNode node;

    public CountingTask(TreeNode node) {
        this.node = node;
    }

    /**
     * streams the children set,
     * maps over this stream, creating a new CountingTask for each element,
     * executes each subtask by forking it,
     * collects the results by calling the join method on each forked task,
     * sums the results using the Collectors.summingInt collector.
     * @return
     */
    @Override
    protected Integer compute() {
        return node.value + node.children.stream()
                .map(childNode -> new CountingTask(childNode).fork())
                .collect(Collectors.summingInt(ForkJoinTask::join));
    }
}
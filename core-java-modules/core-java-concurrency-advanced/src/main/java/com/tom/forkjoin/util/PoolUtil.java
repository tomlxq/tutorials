package com.tom.forkjoin.util;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/15
 */


import java.util.concurrent.ForkJoinPool;

public class PoolUtil {

    public static ForkJoinPool forkJoinPool = new ForkJoinPool(2);

}

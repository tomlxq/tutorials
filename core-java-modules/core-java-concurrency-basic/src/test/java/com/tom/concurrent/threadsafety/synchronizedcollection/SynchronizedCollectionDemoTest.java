package com.tom.concurrent.threadsafety.synchronizedcollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 让我们记住，同步的集合在每种方法中都使用内在锁定（稍后我们将介绍内在锁定）。
 * 这意味着该方法一次只能由一个线程访问，而其他线程将被阻塞，直到第一个线程将方法解锁。
 * 因此，由于同步访问的基本逻辑，同步会对性能造成不利影响。
 * @author TomLuo
 * @date 2020/2/16
 */
public class SynchronizedCollectionDemoTest {
    @Test
    public void test_synchronizedCollections() throws Exception {
        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        Thread thread11 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Thread thread12 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
        thread11.start();
        thread12.start();


    }
}
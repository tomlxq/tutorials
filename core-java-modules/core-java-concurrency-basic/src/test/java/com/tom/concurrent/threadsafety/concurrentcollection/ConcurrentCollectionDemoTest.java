package com.tom.concurrent.threadsafety.concurrentcollection;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

/**
 *
 * 除了同步集合，我们还可以使用并发集合来创建线程安全的集合。
 * Java提供了java.util.concurrent包，其中包含多个并发集合，例如ConcurrentHashMap
 * 与同步对象不同，并发集合通过将其数据划分为多个段来实现线程安全。
 * 例如，在ConcurrentHashMap中，多个线程可以获取不同映射段上的锁，因此多个线程可以同时访问Map。
 * 由于并发线程访问的固有优势，并发集合比同步的集合具有更高的性能。
 * 值得一提的是，同步集合和并发集合仅使集合本身具有线程安全性，而不使内容具有线程安全性。
 *
 * @author TomLuo
 * @date 2020/2/16
 */
public class ConcurrentCollectionDemoTest {

    @Test
    public void test_synchronizedCollections() throws Exception {



        Map<String, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("1", "one");
        concurrentMap.put("2", "two");
        concurrentMap.put("3", "three");
    }

}
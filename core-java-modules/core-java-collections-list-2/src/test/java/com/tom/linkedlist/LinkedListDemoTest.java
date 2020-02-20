package com.tom.linkedlist;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/20
 */
@Slf4j
public class LinkedListDemoTest {
    @Test
    public void test_get_synchronized_list() {
        List list = Collections.synchronizedList(new LinkedList(){});
        list.add("Lieutenant");
        list.add("Captain");
        list.add("Major");
    }
    @Test
    public void test_usage() {
        LinkedList list = new LinkedList(){};
        list.add("Lieutenant");
        list.addAll(list);
        list.addFirst("hello");
        list.addLast("world");
        list.add(null);
        log.info("{}", JSON.toJSONString(list,true));
    }
    @Test
    public void test_remove() {
        LinkedList list = new LinkedList(){};
        list.add("Lieutenant");
        list.add("Captain");
        list.add("Major");
        list.add(null);
        list.add("green");
        log.info("{}", JSON.toJSONString(list,true));
        list.removeFirst();
        list.removeLast();
        log.info("{}", JSON.toJSONString(list,true));
        list.removeFirstOccurrence("Captain");
        list.removeLastOccurrence(null);
        log.info("{}", JSON.toJSONString(list,true));
    }
}
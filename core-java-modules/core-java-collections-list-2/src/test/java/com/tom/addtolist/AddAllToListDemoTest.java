package com.tom.addtolist;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/22
 */
@Slf4j
public class AddAllToListDemoTest {
    @Test
    public void test_addAll() {
        List<Integer> list = new ArrayList<>(16);
        list.add(1);
        List<Integer> anotherList = Arrays.asList(5, 12, 9, 3, 15, 88);
        list.addAll(anotherList);
        assertEquals(list, Arrays.asList(1, 5, 12, 9, 3, 15, 88));
        assertEquals(anotherList, Arrays.asList(5, 12, 9, 3, 15, 88));
    }

    @Test
    public void test_with_collections_addAll() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        assertEquals(list, Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    public void test_with_collections_addAll2() {
        List<Integer> list = new ArrayList<>();
        Integer[] otherList = new Integer[]{1, 2, 3, 4, 5};
        Collections.addAll(list, otherList);
        log.info("{}", list);
        assertEquals(list, Arrays.asList(otherList));
    }

    @Test
    public void test_with_java8_stream() {
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> target = new ArrayList<>();
        source.stream().forEachOrdered(target::add);
        assertEquals(target, source);
    }

    @Test
    public void test_with_java8_stream_skip() {
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> target = new ArrayList<>();
        source.stream()
                .skip(1)
                .forEachOrdered(target::add);
        assertEquals(target, Arrays.asList(2, 3, 4, 5, 6));
    }

    @Test
    public void test_with_java8_stream_filter() {
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> target = new ArrayList<>();
        source.stream()
                .filter(i -> i > 4)
                .forEachOrdered(target::add);
        assertEquals(target, Arrays.asList(5, 6));
    }

    @Test
    public void test_with_java8_stream_Optional() {
        List<Integer> source = null;
        List<Integer> target = new ArrayList<>();
        //Optional.ofNullable(source) 判断source是否为非空
        Optional.ofNullable(source).ifPresent(target::addAll);
        assertEquals(new ArrayList<>(), target);
    }
}
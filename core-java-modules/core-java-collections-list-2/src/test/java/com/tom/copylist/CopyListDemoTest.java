package com.tom.copylist;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/22
 */
@Slf4j
public class CopyListDemoTest {
    private List<Flower> list = Arrays.asList(new Flower("guava", 10), new Flower("butterfly", 8));

    @Test
    public void copy_entity() {
        List<Flower> copy = new ArrayList<>(list);
    }

    @Test
    public void copy_integer() {
        List<Integer> list = Arrays.asList(1, 2);
        List<Integer> copy = new ArrayList<>(list);
    }

    @Test
    public void copy_with_addAll() {
        List<Integer> list = Arrays.asList(1, 2);
        List<Integer> copy = new ArrayList<>();
        copy.addAll(list);
    }

    @Test
    public void copy_with_collections_copy_method() {
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Integer> dest = Arrays.asList(4, 5, 6);
        Collections.copy(dest, source);
        Assert.assertEquals(dest, source);
    }

    @Test
    public void copy_with_collections_copy_method_not_same_size() {
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Integer> dest = Arrays.asList(5, 6, 7, 8, 9, 10);
        Collections.copy(dest, source);
        Assert.assertEquals(dest, Arrays.asList(1, 2, 3, 8, 9, 10));
    }

    @Test
    public void java8_copy() {
        List<String> list = Arrays.asList("hello", "world");
        List<String> copy = list.stream().collect(Collectors.toList());
        Assert.assertEquals(copy, list);
    }

    @Test
    public void java8_copy_and_skip() {
        List<String> list = Arrays.asList("hello", "world");
        List<String> copy = list.stream().skip(1)
                .collect(Collectors.toList());
        Assert.assertEquals(copy, Arrays.asList("world"));
    }

    @Test
    public void java8_copy_and_filter_length() {
        List<String> list = Arrays.asList("hello", "world", "this is first message");
        List<String> copy = list.stream()
                .filter(s -> s.length() > 10)
                .collect(Collectors.toList());
        Assert.assertEquals(copy, Arrays.asList("this is first message"));
    }

    @Test
    public void java8_copy_and_property() {
        List<Flower> flowers = list.stream()
                .filter(f -> f.getPetals() > 8)
                .collect(Collectors.toList());
    }

    @Test
    public void java8_copy_and_empty() {
        list = null;
        List<Flower> flowers = Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .collect(Collectors.toList());
        Assert.assertEquals(flowers, new ArrayList<>());
    }

    @Test
    public void java8_copy_and_skip_collect() {
        List<Flower> flowers = Optional.ofNullable(list)
                .map(List::stream).orElseGet(Stream::empty)
                .skip(1)
                .collect(Collectors.toList());
        log.info("{}", flowers);
    }
    @Test
    public void java10_copy() {
        List<Flower> copy = List.copyOf(list);
        log.info("{}", copy);
    }
}
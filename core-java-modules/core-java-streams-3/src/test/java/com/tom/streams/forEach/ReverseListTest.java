package com.tom.streams.forEach;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/3/1
 */
@Slf4j
public class ReverseListTest {
    List<String> list = Arrays.asList("A", "B", "C", "D");


    Consumer<String> removeElement = s -> {
        System.out.println(s + " " + list.size());
        if (s != null && s.equals("A")) {
            list.remove("D");
        }
    };

    @Test
    public void enhanced_for_loop() {
        for (String s : list) {
            System.out.print(s);
        }
        System.out.print(" ");
    }

    @Test
    public void name() {
        Consumer<String> consumer = s -> System.out.println(s);
        // Consumer<String> consumer = s -> {
        //     System.out::println
        // };
        list.forEach(consumer);
        list.stream().forEach(consumer);
    }

    @Test
    public void test_parallelStream() {
        list.forEach(System.out::print);
        System.out.print(" ");
        list.parallelStream().forEach(System.out::print);
    }


    @Test
    public void iterateParallel() {
        list.forEach(System.out::print);
        System.out.print(" ");
        list.parallelStream().forEach(System.out::print);
    }

    @Test
    public void iterateReverse() {
        List<String> myList = new ReverseList();
        myList.addAll(list);
        myList.forEach(System.out::print);
        System.out.print(" ");
        myList.stream().forEach(System.out::print);
    }

    @Test
    public void removeInCollectionForEach() {
        assertThatThrownBy(() -> list.forEach(removeElement)).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    public void removeInStreamForEach() {
        assertThatThrownBy(() -> list.stream().forEach(removeElement)).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    public void change_element_forEach() {
        log.info("{}", list);
        list.forEach(e -> {
            list.set(3, "E");
        });
        log.info("{}", list);
    }
}
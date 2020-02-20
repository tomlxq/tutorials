package com.tom.arraylist;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/20
 */
@Slf4j
public class ArrayListDemoTest {
    List<String> stringsToSearch = null;

    @Before
    public void setUp() throws Exception {
        List<String> list = LongStream.range(0, 16)
                .boxed()
                .map(Long::toHexString)
                .collect(toCollection(ArrayList::new));
        log.info("{}", JSON.toJSONString(list));
        stringsToSearch = new ArrayList<>(list);
    }

    @Test
    public void create_empty_array_list() {
        List<String> list = new ArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void create_array_list_with_capacity() {
        List<String> list = new ArrayList<>(20);
        assertEquals(list.size(), 0);
    }

    @Test
    public void create_array_list_with_collections() {
        Collection<Integer> numbers
                = IntStream.range(0, 10).boxed().collect(toSet());
        List<Integer> list = new ArrayList<>(numbers);
        assertEquals(10, list.size());
        assertTrue(numbers.containsAll(list));
    }

    @Test
    public void insert_element() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(1, 3L);
        assertThat(Arrays.asList(1L, 3L, 2L), equalTo(list));
    }

    @Test
    public void insert_collections() {
        List<Long> list = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        /**
         * 定义整数流LongStream.range(4, 10) 4到9，不包括10
         * toCollection(ArrayList::new) 将4-9插入到新的ArrayList里
         * collectingAndThen(toCollection(ArrayList::new), ys -> list.addAll(0, ys))
         * 将新创建的4-9ArrayList插到前List前面位置
         */
        LongStream.range(4, 10).boxed()
                .collect(collectingAndThen(toCollection(ArrayList::new), ys -> list.addAll(0, ys)));
        assertThat(Arrays.asList(4L, 5L, 6L, 7L, 8L, 9L, 1L, 2L, 3L), equalTo(list));
    }

    @Test
    public void traverse_ArrayList_with_ListIterator() {
        List<Integer> list = new ArrayList<>(
                IntStream.range(0, 10).boxed().collect(toCollection(ArrayList::new))
        );
        ListIterator<Integer> it = list.listIterator(list.size());
        List<Integer> result = new ArrayList<>(list.size());
        while (it.hasPrevious()) {
            result.add(it.previous());
        }
        log.info("{}", JSON.toJSONString(list));
        log.info("{}", JSON.toJSONString(result));
        Collections.reverse(list);
        assertThat(result, equalTo(list));
    }

    @Test
    public void how_to_search() {
        List<String> list = LongStream.range(0, 16)
                .boxed()
                .map(Long::toHexString)
                .collect(toCollection(ArrayList::new));
        log.info("{}", JSON.toJSONString(list));
        List<String> stringsToSearch = new ArrayList<>(list);
        Assert.assertTrue(stringsToSearch.addAll(list));
        ;
    }

    @Test
    public void how_to_search2() {

        assertEquals(10, stringsToSearch.indexOf("a"));
        assertEquals(10, stringsToSearch.lastIndexOf("a"));
    }

    @Test
    public void how_to_search3() {
        Set<String> matchingStrings = new HashSet<>(Arrays.asList("a", "c", "9"));
        List<String> result = stringsToSearch
                .stream()
                .filter(matchingStrings::contains)
                .collect(toCollection(ArrayList::new));
        assertEquals(3, result.size());
    }

    @Test
    public void how_to_search4() {
        Iterator<String> it = stringsToSearch.iterator();
        Set<String> matchingStrings = new HashSet<>(Arrays.asList("a", "c", "9"));

        List<String> result = new ArrayList<>();
        while (it.hasNext()) {
            String s = it.next();
            if (matchingStrings.contains(s)) {
                result.add(s);
            }
        }
        assertEquals(3, result.size());
    }

    @Test
    public void how_to_search5() {
        List<String> copy = new ArrayList<>(stringsToSearch);
        Collections.sort(copy);
        int index = Collections.binarySearch(copy, "f");
        assertThat(index, not(equalTo(-1)));
    }

    @Test
    public void how_to_remove() {
        List<Integer> list = new ArrayList<>(
                IntStream.range(0, 10).boxed().collect(toCollection(ArrayList::new))
        );
        Collections.reverse(list);

        list.remove(0);
        assertThat(list.get(0), equalTo(8));

        list.remove(Integer.valueOf(0));
        assertFalse(list.contains(0));
    }

    @Test
    public void how_to_remove1() {
        Set<String> matchingStrings = new HashSet<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        Iterator<String> it = stringsToSearch.iterator();
        while (it.hasNext()) {
            if (matchingStrings.contains(it.next())) {
                it.remove();
            }
        }
    }
    @Test
    public void how_to_remove2() {
        List<String> matchingStrings = new ArrayList<>(
                Arrays.asList("a", "b", "c", "d", "e", "f").stream().collect(toCollection(ArrayList::new))
        );
        List<String> result = stringsToSearch
                .stream()
                .filter(matchingStrings::contains)
                .collect(toCollection(ArrayList::new));
        assertEquals(6, result.size());



    }
}
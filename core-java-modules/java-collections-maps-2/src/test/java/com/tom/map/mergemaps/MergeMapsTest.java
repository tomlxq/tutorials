package com.tom.map.mergemaps;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/29
 */
public class MergeMapsTest {
    private static Map<String, Employee> map1 = new HashMap<>();
    private static Map<String, Employee> map2 = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        MergeMaps.initialize();
        Employee employee1 = new Employee(1L, "Henry");
        map1.put(employee1.getName(), employee1);
        Employee employee2 = new Employee(22L, "Annie");
        map1.put(employee2.getName(), employee2);
        Employee employee3 = new Employee(8L, "John");
        map1.put(employee3.getName(), employee3);

        Employee employee4 = new Employee(2L, "George");
        map2.put(employee4.getName(), employee4);
        Employee employee5 = new Employee(3L, "Henry");
        map2.put(employee5.getName(), employee5);
    }

    @Test
    public void test_merge() {
        MergeMaps.mergeFunction();
    }
    @Test
    public void test_concat() {
        MergeMaps.streamConcat();
    }
    @Test
    public void test_concat_throw() {
        Stream<Map.Entry<String, Employee>> combined = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream());
        assertThatThrownBy(()->{ Map<String, Employee> result = combined.
                collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));}).isInstanceOf(IllegalStateException.class);
    }
    @Test
    public void test_map_concat() {
        Stream<Map.Entry<String, Employee>> combined = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream());
        Map<String, Employee> result = combined.
                collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (value1, value2) -> new Employee(value2.getId(), value1.getName())
                ));
        result.entrySet().forEach(System.out::println);
    }

    @Test
    public void test_steamOf() {
        MergeMaps.streamOf();
    }

    @Test
    public void test_steamMerge() {
        MergeMaps.streamMerge();
    }

    @Test
    public void test_steamEx() {
        MergeMaps.streamEx();
    }
}
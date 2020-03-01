package com.tom.map.sort;

import com.tom.map.mergemaps.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/29
 */
public class SortHashMapTest {
    private static Map<String, Employee> map = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        SortHashMap.initialize();
        Employee employee1 = new Employee(1L, "Mher");
        map.put(employee1.getName(), employee1);
        Employee employee2 = new Employee(22L, "Annie");
        map.put(employee2.getName(), employee2);
        Employee employee3 = new Employee(8L, "John");
        map.put(employee3.getName(), employee3);
        Employee employee4 = new Employee(2L, "George");
        map.put(employee4.getName(), employee4);
    }

    @Test
    public void treeMapSortByKey() {
        SortHashMap.treeMapSortByKey();
    }

    @Test
    public void arrayListSortByKey() {
        SortHashMap.arrayListSortByKey();
    }

    @Test
    public void arrayListSortByValue() {
        SortHashMap.arrayListSortByValue();
    }

    @Test
    public void treeSetByKey() {
        SortHashMap.treeSetByKey();
    }

    @Test
    public void treeSetByValue() {
        SortHashMap.treeSetByValue();
    }

    @Test
    public void sortStream() {
        SortHashMap.sortStream();
    }

    @Test
    public void sortStreamByValue() {
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }


    @Test
    public void sortGuava() {
        SortHashMap.sortGuava();
    }

}
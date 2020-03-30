package com.tom.map.sort;

import com.google.common.base.Functions;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Ordering;
import com.tom.map.mergemaps.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SortHashMap {

    private static Map<String, Employee> map = new HashMap<>();

    public static void main(String[] args) {

        initialize();

        treeMapSortByKey();

        arrayListSortByValue();
        arrayListSortByKey();

        sortStream();

        sortGuava();

        addDuplicates();

        treeSetByKey();
        treeSetByValue();

    }

    protected static void sortGuava() {
        final Ordering naturalOrdering =
                Ordering.natural().onResultOf(Functions.forMap(map, null));

        System.out.println(ImmutableSortedMap.copyOf(map, naturalOrdering));
    }

    protected static void sortStream() {
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Employee>comparingByKey().reversed())
                .forEach(System.out::println);

        Map<String, Employee> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        result.entrySet().forEach(System.out::println);
    }

    protected static void treeSetByValue() {
        SortedSet<Employee> values = new TreeSet<>(map.values());
        System.out.println(values);
    }

    protected static void treeSetByKey() {
        Employee employee5 = new Employee(1L, "Mher");
        map.put(employee5.getName(), employee5);
        Employee employee6 = new Employee(22L, "Annie");
        map.put(employee6.getName(), employee6);
        SortedSet<String> keysSet = new TreeSet<>(map.keySet());
        keysSet.forEach(System.out::println);
    }

    protected static void treeMapSortByKey() {
        TreeMap<String, Employee> sorted = new TreeMap<>(map);
        sorted.putAll(map);

        sorted.entrySet().forEach(System.out::println);

    }

    protected static void arrayListSortByValue() {
        List<Employee> employeeById = new ArrayList<>(map.values());
        Collections.sort(employeeById);
        employeeById.forEach(System.out::println);
    }

    protected static void arrayListSortByKey() {
        List<String> employeeByKey = new ArrayList<>(map.keySet());
        Collections.sort(employeeByKey);
        System.out.println(employeeByKey);
    }

    protected static void initialize() {
        Employee employee1 = new Employee(1L, "Mher");
        map.put(employee1.getName(), employee1);
        Employee employee2 = new Employee(22L, "Annie");
        map.put(employee2.getName(), employee2);
        Employee employee3 = new Employee(8L, "John");
        map.put(employee3.getName(), employee3);
        Employee employee4 = new Employee(2L, "George");
        map.put(employee4.getName(), employee4);
    }

    private static void addDuplicates() {
        Employee employee5 = new Employee(1L, "Mher");
        map.put(employee5.getName(), employee5);
        Employee employee6 = new Employee(22L, "Annie");
        map.put(employee6.getName(), employee6);
    }
}
package com.tom.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/22
 */
public class ListDemoTest {
    List<String> countries = Arrays.asList("Germany", "Panama", "Australia");


    @Test
    public void base_for() {
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }

    }

    @Test
    public void enhanced_base_for() {
        for (String country : countries) {
            System.out.println(country);
        }
    }

    @Test
    public void test_iterator() {
        Iterator<String> countriesIterator = countries.iterator();
        while (countriesIterator.hasNext()) {
            System.out.println(countriesIterator.next());
        }
    }

    @Test
    public void test_list_iterator() {
        ListIterator<String> listIterator = countries.listIterator();

        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
    @Test
    public void test_list_lambda() {
        countries.forEach(System.out::println);
    }
    @Test
    public void test_list_stream() {
        countries.stream().forEach((c) -> System.out.println(c));
    }
}
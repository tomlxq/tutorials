package com.tom.hashtable;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/26
 */
@Slf4j
public class WordUnitTest {
    Hashtable<Word, String> table = new Hashtable<>();

    @Test
    public void test_put_get_remove() {

        Word word = new Word("cat");
        table.put(word, "an animal");
        String definition = table.get(word);
        definition = table.remove(word);
    }

    @Test
    public void hashcode_and_equal() {
        Word word = new Word("cat");
        table.put(word, "an animal");
        String extracted = table.get(new Word("cat"));
        Assert.assertEquals("an animal", extracted);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iterator_in_hashtable_fail_fast() {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("cat"), "an animal");
        table.put(new Word("dog"), "another animal");
        Iterator<Word> it = table.keySet().iterator();
        table.remove(new Word("dog"));
        while (it.hasNext()) {
            Word key = it.next();
        }

    }

    @Test
    public void enumeration_in_hashtable_not_fail_fast() {
        Hashtable<Word, String> table = new Hashtable<Word, String>();
        table.put(new Word("1"), "one");
        table.put(new Word("2"), "two");
        Enumeration<Word> enumKey = table.keys();
        table.remove(new Word("1"));
        while (enumKey.hasMoreElements()) {
            Word key = enumKey.nextElement();
            log.info("{}", JSON.toJSONString(key, true));
        }
    }

    @Test
    public void unpredictable_iterator_order() {

        Hashtable<Word, String> table = new Hashtable<Word, String>();
        IntStream.rangeClosed(1, 8).forEach(idx -> {
            table.put(new Word(String.valueOf(idx)), "value" + idx);
        });

        Iterator<Map.Entry<Word, String>> it = table.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Word, String> entry = it.next();
            log.info("{}", JSON.toJSONString(entry, true));
        }
    }

    @Test
    public void get_not_found_value_before_java8() {
        Word key = new Word("dog");
        String definition;
        if (table.containsKey(key)) {
            definition = table.get(key);
        } else {
            definition = "not found";
        }
        log.info("{}", definition);
    }

    @Test
    public void get_not_found_value_java8() {
        Word key = new Word("dog");
        String definition = table.getOrDefault(key, "not found");
        log.info("{}", definition);
    }

    @Test
    public void putIfAbsent_before_java8() {
        String definition = "an animal";
        if (!table.containsKey(new Word("cat"))) {
            table.put(new Word("cat"), definition);
        }
    }

    @Test
    public void putIfAbsent_java8() {
        String definition = "an animal";
        table.putIfAbsent(new Word("cat"), definition);
    }

    @Test
    public void remove_before_java8() {

        String cat = table.get(new Word("cat"));
        if (Objects.nonNull(cat) && cat.equals("an animal")) {
            table.remove(new Word("cat"));
        }
    }

    @Test
    public void remove_java8() {
        boolean result = table.remove(new Word("cat"), "an animal");
    }

    @Test
    public void replace_before_java8() {
        String definition = "an animal";
        if (table.containsKey(new Word("cat"))
                && table.get(new Word("cat")).equals("a small domesticated carnivorous mammal")) {
            table.put(new Word("cat"), definition);
        }
    }

    @Test
    public void replace_java8() {
        String definition = "an animal";
        table.replace(new Word("cat"), "a small domesticated carnivorous mammal", definition);
    }

    @Test
    public void computeIfAbsent() {
        table.computeIfAbsent(new Word("cat"), key -> "an animal");
    }

    @Test
    public void computeIfAbsent_equal_method() {
        Word cat = new Word("cat");
        if (!table.containsKey(cat)) {
            String definition = "an animal"; // note that calculations take place inside if block
            table.put(cat, definition);
        }
    }

    @Test
    public void computeIfPresent() {
        Word cat = new Word("cat");
        table.computeIfPresent(cat, (key, value) -> key.getName() + " - " + value);
    }

    @Test
    public void computeIfPresent_equal_method() {
        Word cat = new Word("cat");
        if (table.containsKey(cat)) {
            String concatination = cat.getName() + " - " + table.get(cat);
            table.put(cat, concatination);
        }
    }

    @Test
    public void compute_calculate_repeat_times() {
        String[] animals = {"cat", "dog", "dog", "cat", "bird", "mouse", "mouse"};
        Hashtable<String, Integer> table = new Hashtable<String, Integer>();

        for (String animal : animals) {
            table.compute(animal,
                    (key, value) -> (value == null ? 1 : value + 1));
        }
        log.info("{}", table);
        assertThat(table.values(), hasItems(2, 2, 2, 1));
    }

    @Test
    public void merge_calculate_repeat_times() {
        String[] animals = {"cat", "dog", "dog", "cat", "bird", "mouse", "mouse"};
        Hashtable<String, Integer> table = new Hashtable<String, Integer>();
        for (String animal : animals) {
            table.merge(animal, 1, (oldValue, value) -> (oldValue + value));
        }
        log.info("{}", table);
        assertThat(table.values(), hasItems(2, 2, 2, 1));
    }

    @Test
    public void forEach() {
        table.put(new Word("cat"), "an animal");
        table.put(new Word("dog"), "another animal");
        table.forEach((k, v) -> System.out.println(k.getName() + " - " + v));
    }
    @Test
    public void replaceAll() {
        table.put(new Word("cat"), "an animal");
        table.put(new Word("dog"), "another animal");
        table.replaceAll((k, v) -> k.getName() + " - " + v);
        log.info("{}", table);
    }
}
package com.tom.removefirst;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.contains;


/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/22
 */
public class RemoveFirstDemoTest {
    ArrayList<String> list = new ArrayList<>();
    LinkedList<String> linkedList = new LinkedList<>();

    @Before
    public void setUp() throws Exception {
        list.add("cat");
        list.add("dog");
        list.add("pig");
        list.add("cow");
        list.add("goat");

        linkedList.add("cat");
        linkedList.add("dog");
        linkedList.add("pig");
        linkedList.add("cow");
        linkedList.add("goat");
    }
    @Test
    public void givenList_whenRemoveFirst_thenRemoved() {
        list.remove(0);

        assertThat(list, hasSize(4));
        assertThat(list, not(contains("cat")));
    }

    @Test
    public void givenLinkedList_whenRemoveFirst_thenRemoved() {
        linkedList.removeFirst();

        assertThat(linkedList, hasSize(4));
        assertThat(linkedList, not(contains("cat")));
    }
}
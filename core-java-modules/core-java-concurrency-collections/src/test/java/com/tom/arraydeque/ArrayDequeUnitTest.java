package com.tom.arraydeque;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayDequeUnitTest {

    @Test
    public void whenOffer_addsAtLast() {
        final Deque<String> deque = new ArrayDeque<>();

        deque.offer("first");
        deque.offer("second");

        assertEquals("second", deque.getLast());
    }

    @Test
    public void whenPoll_removesFirst() {
        final Deque<String> deque = new ArrayDeque<>();

        deque.offer("first");
        deque.offer("second");

        assertEquals("first", deque.poll());
    }

    @Test
    public void whenPoll_isNull() {
        final Deque<String> deque = new ArrayDeque<>();
        assertNull(deque.poll());
    }

    @Test
    public void whenPush_addsAtFirst() {
        final Deque<String> deque = new ArrayDeque<>();

        deque.push("first");
        deque.push("second");

        assertEquals("second", deque.getFirst());
    }

    @Test
    public void whenPop_removesLast() {
        final Deque<String> deque = new ArrayDeque<>();

        deque.push("first");
        deque.push("second");

        assertEquals("second", deque.pop());
        final Deque<String> deque2 = new ArrayDeque<>();
        assertThrows(NoSuchElementException.class, () -> {
            deque2.pop();
        });
    }

    @Test
    public void whenPop_NoSuchElementException() {
        final Deque<String> deque = new ArrayDeque<>();
        assertThrows(NoSuchElementException.class, () -> {
            deque.pop();
        });
    }
}
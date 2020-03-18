package com.tom.streams;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PeekUnitTest {

    private StringWriter out;

    @BeforeEach
    void setup() {
        out = new StringWriter();
    }

    @Test
    void givenStringStream_whenCallingPeekOnly_thenNoElementProcessed2() {
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");
        nameStream.peek(System.out::println);
    }

    @Test
    void givenStringStream_whenCallingPeekOnly_thenNoElementProcessed() {
        // given
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");

        // when
        nameStream.peek(out::append);

        // then
        assertThat(out.toString()).isEmpty();
    }

    @Test
    void givenStringStream_whenCallingForEachOnly_thenElementsProcessed() {
        // given
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");

        // when
        nameStream.forEach(out::append);

        // then
        assertThat(out.toString()).isEqualTo("AliceBobChuck");
    }

    @Test
    void givenStringStream_whenCallingPeekAndNoopForEach_thenElementsProcessed() {
        // given
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");

        // when
        nameStream.peek(out::append)
                .forEach(this::noop);

        // then
        assertThat(out.toString()).isEqualTo("AliceBobChuck");
    }

    @Test
    void givenStringStream_whenCallingPeekAndCollect_thenElementsProcessed() {
        // given
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");

        // when
        nameStream.peek(out::append)
                .collect(Collectors.toList());

        // then
        assertThat(out.toString()).isEqualTo("AliceBobChuck");
    }

    @Test
    void givenStringStream_whenCallingPeekAndCollect_thenElementsProcessed2() {
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }

    @Test
    void givenStringStream_whenCallingPeekAndForEach_thenElementsProcessedTwice() {
        // given
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Chuck");

        // when
        nameStream.peek(out::append)
                .forEach(out::append);

        // then
        assertThat(out.toString()).isEqualTo("AliceAliceBobBobChuckChuck");
    }

    @Test
    void givenStringStream_whenCallingPeek_thenElementsProcessedTwice() {
        // given
        Stream<User> userStream = Stream.of(new User("Alice"), new User("Bob"), new User("Chuck"));

        // when
        userStream.peek(u -> u.setName(u.getName().toLowerCase()))
                .map(User::getName)
                .forEach(out::append);

        // then
        assertThat(out.toString()).isEqualTo("alicebobchuck");
    }

    @Data
    @AllArgsConstructor
    private static class User {
        private String name;
    }

    private void noop(String s) {
    }

}

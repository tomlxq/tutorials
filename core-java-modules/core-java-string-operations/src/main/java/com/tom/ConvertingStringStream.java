package com.tom;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Converting String to Stream of chars
 *
 * @author TomLuo
 * @date 2020/1/23
 */
public class ConvertingStringStream {
    /**
     * Conversion Using chars()
     */
    String testString = "String";
    IntStream intStream = testString.chars();
    Stream<Character> characterStream = testString.chars()
            .mapToObj(c -> (char) c);
    /**
     * Conversion Using codePoints()
     */
    IntStream intStream1 = testString.codePoints();
    Stream<Character> characterStream2
            = testString.codePoints().mapToObj(c -> (char) c);
    /**
     * Conversion to a Stream of Single Character Strings
     */
    Stream<String> stringStream = testString.codePoints()
            .mapToObj(c -> String.valueOf((char) c));
}

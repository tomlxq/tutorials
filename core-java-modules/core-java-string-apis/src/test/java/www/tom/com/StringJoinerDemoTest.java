package www.tom.com;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/22
 */
public class StringJoinerDemoTest {
    public static final String PREFIX = "[";
    public static final String SUFFIX = "]";
    @Test
    public void whenAddingElements_thenJoinedElements() {
        StringJoiner joiner = new StringJoiner(",", PREFIX, SUFFIX);
        joiner.add("Red")
                .add("Green")
                .add("Blue");

        assertEquals(joiner.toString(), "[Red,Green,Blue]");
    }

    @Test
    public void whenAddingListElements_thenJoinedListElements() {
        List<String> rgbList = new ArrayList<>();
        rgbList.add("Red");
        rgbList.add("Green");
        rgbList.add("Blue");

        StringJoiner rgbJoiner = new StringJoiner(
                ",", PREFIX, SUFFIX);

        for (String color : rgbList) {
            rgbJoiner.add(color);
        }

        assertEquals(rgbJoiner.toString(), "[Red,Green,Blue]");
    }



    @Test
    public void whenEmptyJoinerWithoutPrefixSuffix_thenEmptyString() {
        StringJoiner joiner = new StringJoiner(",");

        assertEquals(0, joiner.toString().length());
    }

    @Test
    public void whenEmptyJoinerJoinerWithPrefixSuffix_thenPrefixSuffix() {
        StringJoiner joiner = new StringJoiner(
                ",", PREFIX, SUFFIX);

        assertEquals(joiner.toString(), PREFIX + SUFFIX);
    }
    /**
     * The default value is returned only when the StringJoiner is empty.
     */
    @Test
    public void whenEmptyJoinerWithEmptyValue_thenDefaultValue() {
        StringJoiner joiner = new StringJoiner(",");
        joiner.setEmptyValue("default");

        assertEquals(joiner.toString(), "default");
    }


    @Test
    public void whenEmptyJoinerWithPrefixSuffixAndEmptyValue_thenDefaultValue() {
        StringJoiner joiner = new StringJoiner(",", PREFIX, SUFFIX);
        joiner.setEmptyValue("default");

        assertEquals(joiner.toString(), "default");
    }

    /**
     * Note how “-“ is used to concatenate content of cmybJoiner while rgbJoiner still use “,”.
     */
    @Test
    public void whenMergingJoiners_thenReturnMerged() {
        StringJoiner rgbJoiner = new StringJoiner(
                ",", PREFIX, SUFFIX);
        StringJoiner cmybJoiner = new StringJoiner(
                "-", PREFIX, SUFFIX);

        rgbJoiner.add("Red")
                .add("Green")
                .add("Blue");
        cmybJoiner.add("Cyan")
                .add("Magenta")
                .add("Yellow")
                .add("Black");

        rgbJoiner.merge(cmybJoiner);

        assertEquals(
                rgbJoiner.toString(),
                "[Red,Green,Blue,Cyan-Magenta-Yellow-Black]");
    }

    /**
     * Collectors.joining() internally uses StringJoiner to perform the joining operation.
     */
    @Test
    public void whenUsedWithinCollectors_thenJoined() {
        List<String> rgbList = Arrays.asList("Red", "Green", "Blue");
        String commaSeparatedRGB = rgbList.stream()
                .map(color -> color.toString())
                .collect(Collectors.joining(","));

        assertEquals(commaSeparatedRGB, "Red,Green,Blue");
    }
}
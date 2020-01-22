package www.tom.com.concatenatingstrings;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/21
 */
public class ConcatenatingStringsTest {
    @Test
    public void stringBuilderTest() {
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("tom");
        stringBuilder.append(" is");
        stringBuilder.append(" awesome");
        assertEquals("tom is awesome", stringBuilder.toString());
    }

    @Test
    public void additionOperatorTest() {
        String myString = "The " + "quick " + "brown " + "fox...";
        assertEquals("The quick brown fox...", myString);
    }

    @Test
    public void StringConcatTest() {
        String myString = "Both".concat(" fickle")
                .concat(" dwarves")
                .concat(" jinx")
                .concat(" my")
                .concat(" pig")
                .concat(" quiz");
        assertEquals("Both fickle dwarves jinx my pig quiz", myString);
    }

    @Test
    public void stringFormatTest() {
        String myString = String.format("%s %s %.2f %s %s, %s...", "I",
                "ate",
                2.5056302,
                "blueberry",
                "pies",
                "oops");
        assertEquals("I ate 2.51 blueberry pies, oops...", myString);
    }

    /**
     * String. join (Java 8+)
     */
    @Test
    public void stringJoinTest() {
        String[] strings = {"I'm", "running", "out", "of", "pangrams!"};
        String myString = String.join(" ", strings);
        assertEquals("I'm running out of pangrams!", myString);
    }

    /**
     * StringJoiner (Java 8+)
     */
    @Test
    public void stringJoinerTest() {
        StringJoiner fruitJoiner = new StringJoiner(", ");
        fruitJoiner.add("Apples");
        fruitJoiner.add("Oranges");
        fruitJoiner.add("Bananas");
        assertEquals("Apples, Oranges, Bananas", fruitJoiner.toString());
    }

    /**
     * Arrays.toString
     */
    @Test
    public void arraysToStringTest() {
        String[] myFavouriteLanguages = {"Java", "JavaScript", "Python"};
        String toString = Arrays.toString(myFavouriteLanguages);
        assertEquals("[Java, JavaScript, Python]", toString);
    }

    /**
     * Collectors.joining (Java 8+)
     */
    @Test
    public void collectorsJoiningTest() {
        List<String> awesomeAnimals = Arrays.asList("Shark", "Panda", "Armadillo");
        String animalString = awesomeAnimals.stream().collect(Collectors.joining(", "));
        assertEquals("Shark, Panda, Armadillo", animalString);
    }
}
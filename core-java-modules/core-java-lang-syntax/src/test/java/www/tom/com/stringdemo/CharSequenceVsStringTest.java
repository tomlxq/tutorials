package www.tom.com.stringdemo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/20
 */
public class CharSequenceVsStringTest {
    @Test
    public void givenUsingString_whenInstantiatingString_thenWrong() {
        CharSequence firstString = "pizza";
        String secondString = "pizza";

        assertNotEquals(firstString, secondString);
    }

    /**
     * each sum operation creates another instance, increases the amount of data stored and returns the most recently created String
     */
    @Test
    public void givenString_whenAppended_thenUnmodified() {
        String test = "a";
        int firstAddressOfTest = System.identityHashCode(test);
        test += "b";
        int secondAddressOfTest = System.identityHashCode(test);

        assertNotEquals(firstAddressOfTest, secondAddressOfTest);
    }

    /**
     * StringBuilder updates the already created String to hold the new value
     */
    @Test
    public void givenStringBuilder_whenAppended_thenModified() {
        StringBuilder test = new StringBuilder();
        test.append("a");
        int firstAddressOfTest = System.identityHashCode(test);
        test.append("b");
        int secondAddressOfTest = System.identityHashCode(test);

        assertEquals(firstAddressOfTest, secondAddressOfTest);
    }

    @Test
    public void givenIdenticalCharSequences_whenCastToString_thenEqual() {
        CharSequence charSeq1 = "pizza_1";
        CharSequence charSeq2 = "pizza_2";

        assertTrue(charSeq1.toString().compareTo(charSeq2.toString()) < 0);
    }
}
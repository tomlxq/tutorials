package www.tom.com.stringdemo;

import com.google.common.base.CharMatcher;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static www.tom.com.stringdemo.CountOccurrencesChar.useRecursionToCountChars;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/20
 */
public class CountOccurrencesCharTest {
    /**
     * Using Core Java Lib
     */
    @Test
    public void testCount() {
        String someString = "elephant";
        char someChar = 'e';
        int count = 0;

        for (int i = 0; i < someString.length(); i++) {
            if (someString.charAt(i) == someChar) {
                count++;
            }
        }
        assertEquals(2, count);
    }

    /**
     * Using Recursion
     */
    @Test
    public void testCount2() {
        useRecursionToCountChars("elephant", 'e', 0);
    }

    /**
     * Using Regular Expressions
     */
    @Test
    public void testCount3() {
        Pattern pattern = Pattern.compile("[^e]*e");
        Matcher matcher = pattern.matcher("elephant");
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        assertEquals(2, count);
    }

    /**
     * Using Java 8 Features
     */
    @Test
    public void testCount4() {
        String someString = "elephant";
        long count = someString.chars().filter(ch -> ch == 'e').count();
        assertEquals(2, count);

        long count2 = someString.codePoints().filter(ch -> ch == 'e').count();
        assertEquals(2, count2);
    }
    /**
     * Using StringUtils
     */
    @Test
    public void testCount5() {
        int count = StringUtils.countMatches("elephant", "e");
        assertEquals(2, count);
    }
    /**
     * Using Guava
     */    @Test
    public void testCount6() {
        int count = CharMatcher.is('e').countIn("elephant");
        assertEquals(2, count);
    }

    /**
     * Using Spring
     */
    @Test
    public void testCount7() {
        int count = org.springframework.util.StringUtils.countOccurrencesOf("elephant", "e");
        assertEquals(2, count);
    }
}
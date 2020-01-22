package www.tom.com.stringdemo;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/20
 */
public class ComparingStringsTest {
    /**
     * Using “==” Comparison Operator
     * “==” only checks the referential equality of two Strings
     */
    @Test
    public void mistakeComparing() {
        String string1 = "using comparison operator";
        String string2 = "using comparison operator";
        String string3 = new String("using comparison operator");

        assertThat(string1 == string2).isTrue();
        assertThat(string1 == string3).isFalse();
    }

    /**
     * This method compares two Strings character by character, ignoring their address.
     */
    @Test
    public void equalComparing() {
        String string1 = "using equals method";
        String string2 = "using equals method";

        String string3 = "using EQUALS method";
        String string4 = new String("using equals method");

        assertThat(string1.equals(string2)).isTrue();
        assertThat(string1.equals(string4)).isTrue();

        assertThat(string1.equals(null)).isFalse();
        assertThat(string1.equals(string3)).isFalse();
    }

    /**
     * Using equalsIgnoreCase()
     */
    @Test
    public void equalIgnoreCaseComparing() {
        String string1 = "using equals ignore case";
        String string2 = "USING EQUALS IGNORE CASE";

        assertThat(string1.equalsIgnoreCase(string2)).isTrue();
    }

    /**
     * Using compareTo()
     * This method returns 0 if two Strings are equal or if both are null,
     * a negative number if the first String comes before the argument,
     * and a number greater than zero if the first String comes after the argument String.
     */
    @Test
    public void compareTo() {
        String author = "author";
        String book = "book";
        String duplicateBook = "book";

        assertThat(author.compareTo(book))
                .isEqualTo(-1);
        assertThat(book.compareTo(author))
                .isEqualTo(1);
        assertThat(duplicateBook.compareTo(book))
                .isEqualTo(0);
    }

    /**
     * Using compareToIgnoreCase()
     */
    @Test
    public void compareToIgnoreCase() {
        String author = "Author";
        String book = "book";
        String duplicateBook = "BOOK";

        assertThat(author.compareToIgnoreCase(book))
                .isEqualTo(-1);
        assertThat(book.compareToIgnoreCase(author))
                .isEqualTo(1);
        assertThat(duplicateBook.compareToIgnoreCase(book))
                .isEqualTo(0);
    }

    /**
     * String Comparison with Objects Class
     */
    @Test
    public void comparisonWithObjects() {
        String string1 = "using objects equals";
        String string2 = "using objects equals";
        String string3 = new String("using objects equals");

        assertThat(Objects.equals(string1, string2)).isTrue();
        assertThat(Objects.equals(string1, string3)).isTrue();

        assertThat(Objects.equals(null, null)).isTrue();
        assertThat(Objects.equals(null, string1)).isFalse();
    }

    /**
     * String Comparison with Apache Commons
     */
    @Test
    public void comparisonWithApache() {
        assertThat(StringUtils.equals(null, null))
                .isTrue();
        assertThat(StringUtils.equals(null, "equals method"))
                .isFalse();
        assertThat(StringUtils.equals("equals method", "equals method"))
                .isTrue();
        assertThat(StringUtils.equals("equals method", "EQUALS METHOD"))
                .isFalse();

        assertThat(StringUtils.equalsIgnoreCase("equals method", "equals method"))
                .isTrue();
        assertThat(StringUtils.equalsIgnoreCase("equals method", "EQUALS METHOD"))
                .isTrue();
    }

    /**
     * Using equalsAny() and equalsAnyIgnoreCase()
     * he equalsAny() method's first argument is a String and the second is a multi-args type CharSequence.
     * The method returns true if any of the other given Strings match against the first String case sensitively.
     * <p>
     * Otherwise, false is returned:
     */
    @Test
    public void comparisonWithApacheEqualsAny() {
        assertThat(StringUtils.equalsAny(null, null, null))
                .isTrue();
        assertThat(StringUtils.equalsAny("equals any", "equals any", "any"))
                .isTrue();
        assertThat(StringUtils.equalsAny("equals any", null, "equals any"))
                .isTrue();
        assertThat(StringUtils.equalsAny(null, "equals", "any"))
                .isFalse();
        assertThat(StringUtils.equalsAny("equals any", "EQUALS ANY", "ANY"))
                .isFalse();

        assertThat(StringUtils.equalsAnyIgnoreCase("ignore case", "IGNORE CASE", "any")).isTrue();
    }

    /**
     * Using compare() and compareIgnoreCase()
     */
    @Test
    public void compare() {
        assertThat(StringUtils.compare(null, null))
                .isEqualTo(0);
        assertThat(StringUtils.compare(null, "abc"))
                .isEqualTo(-1);
        assertThat(StringUtils.compare("abc", "bbc"))
                .isEqualTo(-1);
        assertThat(StringUtils.compare("bbc", "abc"))
                .isEqualTo(1);

        assertThat(StringUtils.compareIgnoreCase("Abc", "bbc"))
                .isEqualTo(-1);
        assertThat(StringUtils.compareIgnoreCase("bbc", "ABC"))
                .isEqualTo(1);
        assertThat(StringUtils.compareIgnoreCase("abc", "ABC"))
                .isEqualTo(0);
    }
    /**
     * The two methods can also be used with a nullIsLess option.
     * This is a third boolean argument which decides if null values should be considered less or not.
     */
    @Test
    public void compareAddThirdPara() {
        assertThat(StringUtils.compare(null, "abc", true))
                .isEqualTo(-1);
        assertThat(StringUtils.compare(null, "abc", false))
                .isEqualTo(1);
    }
}
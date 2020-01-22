package www.tom.com;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.IllegalFormatCodePointException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html
 *
 * @author TomLuo
 * @date 2020/1/21
 */
@Slf4j
public class StringFormatterTest {
    @Test
    public void stringFormatTest() {
        String greetings = String.format(
                "Hello Folks, welcome to %s !",
                "blue");
       assertEquals(greetings,"Hello Folks, welcome to blue !");
        
    }

    /**
     * General Syntax
     * %[argument_index$][flags][width][.precision]conversion
     * Specifiers argument_index, flag, width, and precision are optional.
     *
     * argument_index part is an integer i – indicating that the ith argument from the argument list should be used here
     * flags is a set of characters used for modifying the output format
     * width is a positive integer which indicates the minimum number of characters to be written to the output
     * precision is an integer usually used to restrict the number of characters, whose specific behavior depends on the conversion
     * is the mandatory part. It's a character indicating how the argument should be formatted. The set of valid conversions for a given argument depends on the argument's data type
     */
    @Test
    public void stringIndexFormatTest() {
        String greetings = String.format(
                "Hello %2$s, welcome to %1$s !",
                "blue",
                "Folks");
        assertEquals(greetings,"Hello Folks, welcome to blue !");
    }

    /**
     * For Date/Time Representation
     * %[argument_index$][flags][width]conversion
     * the first format specifiers tm, indicates month formatted as two digits,
     * te indicates the day of the month and tY indicated Year formatted as four digits.
     */
    @Test
    public void whenFormatSpecifierForCalendar_thenGotExpected() {
            Calendar c = new GregorianCalendar(2017, 11, 10);
            String s = String.format(
                    "The date is: %tm %1$te,%1$tY", c);

            assertEquals("The date is: 12 10,2017", s);

    }

    /**
     * Inside format(), if we want to print ‘%' – we need to escape it by using ‘%%'.
     */
    @Test
    public void whenNoArguments_thenExpected() {
        String s = String.format("John scored 90%% in Fall semester");

        assertEquals("John scored 90% in Fall semester", s);
    }

    /**
     * Used for any argument type. The general conversions are:
     * ‘b’ or ‘B' – for Boolean values
     * ‘h’ or ‘H' – for HashCode
     * ‘s' or ‘S' – for String, if null, it prints “null”, else arg.toString()
     */
    @Test
    public void givenString_whenGeneralConversion_thenConvertedString() {
        String s = String.format("The correct answer is %s", false);
        assertEquals("The correct answer is false", s);

        s = String.format("The correct answer is %b", null);
        assertEquals("The correct answer is false", s);

        s = String.format("The correct answer is %B", true);
        assertEquals("The correct answer is TRUE", s);
    }

    /**
     * Character
     * Used for the basic types which represent Unicode characters:
     * char, Character, byte, Byte, short, and Short.
     * This conversion can also be used for the types int and Integer when the Character.isValidCodePoint(int) returns true for them.
     *
     * It can be written as ‘c’ or ’C’ based on the case we want.
     */
    @Test
    public void givenString_whenCharConversion_thenConvertedString() {
        String s = String.format("The correct answer is %c", 'a');
        assertEquals("The correct answer is a", s);

        s = String.format("The correct answer is %c", null);
        assertEquals("The correct answer is null", s);

        s = String.format("The correct answer is %C", 'b');
        assertEquals("The correct answer is B", s);

        s = String.format("The valid unicode character: %c", 0x0400);
        assertTrue(Character.isValidCodePoint(0x0400));
        assertEquals("The valid unicode character: Ѐ", s);
    }

    @Test(expected = IllegalFormatCodePointException.class)
    public void whenIllegalCodePointForConversion_thenError() {
        String s = String.format("The valid unicode character: %c", 0x11FFFF);
        log.info(s);
        assertFalse(Character.isValidCodePoint(0x11FFFF));
        assertEquals("The valid unicode character: Ā", s);
    }

    /**
     * Numeric – Integral
     * These are used for Java integral types: byte, Byte, short, Short, int and Integer, long, Long, and BigInteger. There are three conversions in this category:
     *
     * ‘d' – for decimal number
     * ‘o' – for octal number
     * ‘X' or ‘x' – for hexadecimal number
     * 5*10^0+2*10^1=25
     * 1*8^0+3*8^1=25
     * 9*16^0+1*16^1=25
     */
    @Test
    public void whenNumericIntegralConversion_thenConvertedString() {
        String s = String.format("The number 25 in decimal = %d", 25);
        assertEquals("The number 25 in decimal = 25", s);

        s = String.format("The number 25 in octal = %o", 25);
        assertEquals("The number 25 in octal = 31", s);

        s = String.format("The number 25 in hexadecimal = %x", 25);
        assertEquals("The number 25 in hexadecimal = 19", s);
    }

    /**
     * Numeric – Floating Point
     * Used for Java floating-point types: float, Float, double, Double, and BigDecimal
     *
     * ‘e' or ‘E' – formatted as a decimal number in computerized scientific notation
     * ‘f' – formatted as a decimal number
     * ‘g' or ‘G' – based on the precision value after rounding, this conversion formats into computerized scientific notation or decimal format
     */
    @Test
    public void whenNumericFloatingConversion_thenConvertedString() {
        String s = String.format(
                "The computerized scientific format of 10000.00 "
                        + "= %e", 10000.00);

        assertEquals(
                "The computerized scientific format of 10000.00 = 1.000000e+04", s);

        String s2 = String.format("The decimal format of 10.019 = %f", 10.019);
        assertEquals("The decimal format of 10.019 = 10.019000", s2);
    }

    /**
     * Other Conversions
     * Date/Time – for Java types which are capable of encoding a date or time: long, Long, Calendar, Date and TemporalAccessor. For this, we need to use prefixed ‘t' or ‘T', as we saw earlier
     * Percent – prints a literal ‘%' (‘\u0025')
     * Line Separator – prints a platform-specific line separator
     */
    @Test
    public void whenLineSeparatorConversion_thenConvertedString() {
        String s = String.format("First Line %nSecond Line");

        assertEquals("First Line \n" + "Second Line", s);
    }

    /**
     * Flags
     * Flags, in general, are used to format the output. Whereas in case of date and time, they are used to specify which part of the date is to be displayed
     */
    @Test
    public void whenSpecifyFlag_thenGotFormattedString() {
        String s = String.format("Without left justified flag: %5d", 25);
        assertEquals("Without left justified flag:    25", s);

        s = String.format("With left justified flag: %-5d", 25);
        assertEquals("With left justified flag: 25   ", s);
    }

    /**
     * Precision
     * For general conversions, precision is just the maximum number of characters to be written to the output.
     * Whereas, for the floating-point conversions the precision is the number of digits after the radix point.
     *
     * The first statement is an example of precision with floating-point numbers,
     * and the second one with general conversions:
     */
    @Test
    public void whenSpecifyPrecision_thenGotExpected() {
        String s = String.format(
                "Output of 25.09878 with Precision 2: %.2f", 25.09878);

        assertEquals("Output of 25.09878 with Precision 2: 25.10", s);

        String s2 = String.format(
                "Output of general conversion type with Precision 2: %.2b", true);

        assertEquals("Output of general conversion type with Precision 2: tr", s2);
    }

    /**
     * Argument Index
     * As mentioned previously, the argument_index is an integer that indicates the position of the argument in the argument list. 1$ indicates the first argument, 2$ the second argument, and so on.
     *
     * Also, there is another way to reference arguments by position, by using the ‘<‘ (‘\u003c') flag, which means the argument from the previous format specifier will be re-used.
     * For example, these two statements would produce the identical output
     */
    @Test
    public void whenSpecifyArgumentIndex_thenGotExpected() {
        Calendar c = Calendar.getInstance();
        String s = String.format("The date is: %tm %1$te,%1$tY", c);
        assertEquals("The date is: 01 21,2020", s);

        s = String.format("The date is: %tm %<te,%<tY", c);
        assertEquals("The date is: 01 21,2020", s);
    }

    /**
     * Using Formatter with Appendable
     * Let's create a StringBuilder instance sb, and create a Formatter using it.
     * Then we'll invoke format() to format a String
     */
    @Test
    public void whenCreateFormatter_thenFormatterWithAppendable() {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("I am writting to a %s Instance.", sb.getClass());

        assertEquals(
                "I am writting to a class java.lang.StringBuilder Instance.",
                sb.toString());
    }
}
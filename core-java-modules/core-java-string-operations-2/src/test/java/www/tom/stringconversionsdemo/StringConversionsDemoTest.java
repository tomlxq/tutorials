package www.tom.stringconversionsdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/22
 */
public class StringConversionsDemoTest {
    /**
     * If we need to convert a String to primitive int or Integer wrapper type,
     * we can use either the parseInt() or valueOf() APIs to
     * get the corresponding int or Integer return value
     */
    @Test
    public void whenConvertedToInt_thenCorrect() {
        String beforeConvStr = "1";
        int afterConvInt = 1;

        assertEquals(Integer.parseInt(beforeConvStr), afterConvInt);
    }

    @Test
    public void whenConvertedToInteger_thenCorrect() {
        String beforeConvStr = "12";
        Integer afterConvInteger = 12;

        assertEquals(Integer.valueOf(beforeConvStr).equals(afterConvInteger), true);
    }
    /**
     * Converting String to long or Long
     */
    @Test
    public void whenConvertedTolong_thenCorrect() {
        String beforeConvStr = "12345";
        long afterConvLongPrimitive = 12345;

        assertEquals(Long.parseLong(beforeConvStr), afterConvLongPrimitive);
    }

    @Test
    public void whenConvertedToLong_thenCorrect() {
        String beforeConvStr = "14567";
        Long afterConvLong = 14567l;

        assertEquals(Long.valueOf(beforeConvStr).equals(afterConvLong), true);
    }
}
package www.tom.com.concatenatingstrings;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/21
 */
@Slf4j
class StringInitializationTest {

    @Test
    void printDeclaredOnlyStringTest() {
        StringInitialization stringInitialization = new StringInitialization();
        String localVarString = null;
        assertEquals(stringInitialization.fieldString, localVarString);
    }

    /**
     * Strings are stored in a pool
     */

    @Test
    void stringsStoredInPoolTest() {
        String literalOne = "blue";
        String literalTwo = "blue";
        assertTrue(literalOne == literalTwo);
        log.info("{}", System.identityHashCode(literalOne));
        log.info("{}", System.identityHashCode(literalTwo));
    }

    /**
     * String Initialization Using new
     */
    @Test
    void stringInitializationUsingNewTest() {
        String newStringOne = new String("blue");
        String newStringTwo = new String("blue");

        assertFalse(newStringOne == newStringTwo);
        log.info("{}", System.identityHashCode(newStringOne));
        log.info("{}", System.identityHashCode(newStringTwo));
    }

    /**
     * the emptyLiteral will be added to the String pool, while the other two go directly onto the heap.
     */
    @Test
    void emptyStringsTest() {
        String emptyLiteral = "";
        String emptyNewString = new String("");
        String emptyNewStringTwo = new String();
        assertFalse(emptyLiteral == emptyNewString);
        assertFalse(emptyLiteral == emptyNewStringTwo);
        assertFalse(emptyNewString == emptyNewStringTwo);
        assertEquals(emptyLiteral, emptyNewString);
        assertEquals(emptyNewString, emptyNewStringTwo);
    }

    /**
     * the JVM specification says that null is the default value for all references, so it's not specifically tied to the String.
     * And actually, the specification doesn't mandate any concrete value encoding for null.
     * public void println(Object x) {
     * String s = String.valueOf(x);
     * synchronized (this) {
     * print(s);
     * newLine();
     * }
     * }
     * <p>
     * public static String valueOf(Object obj) {
     * return (obj == null) ? "null" : obj.toString();
     * }
     */
    @Test
    void printNullTest() {
        String nullValue = null;
        log.info("{}", nullValue);
    }


}
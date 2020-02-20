/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
package com.tom.javaxval;

import java.util.Locale;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class LocaleAwareUnitTest {
    private static Locale previousDefault;

    @BeforeClass
    public static void setupLocale() {
        previousDefault = Locale.getDefault();

        Locale.setDefault(Locale.US);
    }

    @AfterClass
    public static void resetLocale() {
        Locale.setDefault(previousDefault);
    }


}

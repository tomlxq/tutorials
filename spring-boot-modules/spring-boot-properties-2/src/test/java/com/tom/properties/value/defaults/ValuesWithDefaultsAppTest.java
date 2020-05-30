package com.tom.properties.value.defaults;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/5/30
 */
public class ValuesWithDefaultsAppTest {
    ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new AnnotationConfigApplicationContext(ValuesWithDefaultsApp.class);
    }

    @Test
    public void name() {
        final ValuesWithDefaultsApp bean = applicationContext.getBean(ValuesWithDefaultsApp.class);
        final int[] intArrayWithDefaults = bean.getIntArrayWithDefaults();
        final String stringWithDefaultValue = bean.getStringWithDefaultValue();
        final int intWithDefaultValue = bean.getIntWithDefaultValue();
        final String stringWithBlankDefaultValue = bean.getStringWithBlankDefaultValue();
        final boolean booleanWithDefaultValue = bean.isBooleanWithDefaultValue();
        final String spelWithDefaultValue = bean.getSpelWithDefaultValue();
        final String[] stringArrayWithDefaults = bean.getStringArrayWithDefaults();
        // strings
        Assert.isTrue(stringWithDefaultValue.equals("my default value"));
        Assert.isTrue(stringWithBlankDefaultValue.equals(""));

        // other primitives
        Assert.isTrue(booleanWithDefaultValue);
        Assert.isTrue(intWithDefaultValue == 42);

        // arrays
        List<String> stringListValues = Arrays.asList("one", "two", "three");
        Assert.isTrue(Arrays.asList(stringArrayWithDefaults).containsAll(stringListValues));

        List<Integer> intListValues = Arrays.asList(1, 2, 3);
        Assert.isTrue(Arrays.asList(ArrayUtils.toObject(intArrayWithDefaults)).containsAll(intListValues));

        // SpEL
        Assert.isTrue(spelWithDefaultValue.equals("my default system property value"));
    }
}
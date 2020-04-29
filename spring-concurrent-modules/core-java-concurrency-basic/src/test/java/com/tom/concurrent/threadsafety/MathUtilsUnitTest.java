package com.tom.concurrent.threadsafety;

import com.tom.concurrent.threadsafety.mathutils.MathUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigInteger;

public class MathUtilsUnitTest {

    @Test
    public void whenCalledFactorialMethod_thenCorrect() {
        Assertions.assertThat(MathUtils.factorial(2)).isEqualTo(new BigInteger("2"));
    }
}

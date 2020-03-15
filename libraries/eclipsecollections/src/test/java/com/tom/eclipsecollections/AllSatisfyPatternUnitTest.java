package com.tom.eclipsecollections;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AllSatisfyPatternUnitTest {


    @Test
    public void whenAnySatisfiesCondition_thenCorrect() {
        MutableList<Integer> list = FastList.newListWith(1, 8, 5, 41, 31, 17, 23, 38);
        ;
        boolean result = list.allSatisfy(Predicates.greaterThan(0));

        assertTrue(result);
    }
}
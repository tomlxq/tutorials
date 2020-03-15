package com.tom.eclipsecollections;

import org.assertj.core.api.Assertions;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Test;

public class ZipUnitTest {


    @Test
    public void whenZip_thenCorrect() {
        Pair<String, String> pair1 = Tuples.pair("1", "Porsche");
        Pair<String, String> pair2 = Tuples.pair("2", "Volvo");
        Pair<String, String> pair3 = Tuples.pair("3", "Toyota");
        MutableList<Pair<String, String>> expectedPairs = Lists.mutable.of(pair1, pair2, pair3);
        MutableList<String> numbers = Lists.mutable.with("1", "2", "3", "Ignored");
        MutableList<String> cars = Lists.mutable.with("Porsche", "Volvo", "Toyota");
        MutableList<Pair<String, String>> pairs = numbers.zip(cars);

        Assertions.assertThat(pairs).containsExactlyElementsOf(expectedPairs);
    }
}
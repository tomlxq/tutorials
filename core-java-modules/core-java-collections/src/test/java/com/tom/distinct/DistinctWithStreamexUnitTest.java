package com.tom.distinct;

import one.util.streamex.StreamEx;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DistinctWithStreamexUnitTest {
    List<Person> personList;

    @Before
    public void init() {
        personList = PersonDataGenerator.getPersonListWithFakeValues();
    }

    @Test
    public void whenFilterListByName_thenSizeShouldBe4() {
        List<Person> personListFiltered = StreamEx.of(personList).distinct(Person::getName).toList();
        assertTrue(personListFiltered.size() == 4);
    }

    @Test
    public void whenFilterListByAge_thenSizeShouldBe2() {
        List<Person> personListFiltered = StreamEx.of(personList).distinct(Person::getAge).toList();
        assertTrue(personListFiltered.size() == 2);
    }

}
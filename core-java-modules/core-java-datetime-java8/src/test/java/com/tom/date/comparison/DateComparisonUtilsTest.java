package com.tom.date.comparison;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class DateComparisonUtilsTest {
    LocalDate firstDate = LocalDate.of(2019, 8, 10);
    LocalDate secondDate = LocalDate.of(2019, 7, 1);

    @Test
    public void comparingDates() {


        assertThat(firstDate.isAfter(secondDate), is(true));
        assertThat(firstDate.isBefore(secondDate), is(false));
        assertThat(firstDate.isEqual(firstDate), is(true));
        assertThat(firstDate.isEqual(secondDate), is(false));

    }

    /**
     * Comparing Dates Using the Comparable Interface
     */
    @Test
    public void comparingDatesWithComparableInterface() {
        assertThat(firstDate.equals(secondDate), is(false));
        //the comparator value, negative if less, positive if greater
        assertThat(firstDate.compareTo(secondDate), is(1));
        assertThat(secondDate.compareTo(firstDate), is(-1));
    }
}
package com.tom.date.comparison;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import static com.tom.date.comparison.DateComparisonUtils.toDate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 * Comparison in the Old Java Date API
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class OldJavaDateTest {

    Date firstDate = toDate(LocalDateTime.of(2019, 8, 10, 0, 00, 00));
    Date secondDate = toDate(LocalDateTime.of(2019, 8, 15, 0, 00, 00));
    @Test
    public void comparingDate() {
        assertThat(firstDate.after(secondDate), is(false));
        assertThat(firstDate.before(secondDate), is(true));
        assertThat(firstDate.compareTo(secondDate), is(-1));
        assertThat(firstDate.equals(secondDate), is(false));
    }


}

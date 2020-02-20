package com.tom.date.comparison;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class DateTimeComparisonUtilsTest {

    ZonedDateTime timeInNewYork =
            ZonedDateTime.of(2019, 8, 10, 8, 0, 0, 0, ZoneId.of("America/New_York"));
    ZonedDateTime timeInBerlin =
            ZonedDateTime.of(2019, 8, 10, 14, 0, 0, 0, ZoneId.of("Europe/Berlin"));

    @Test
    public void comparingDateTime() {

        assertThat(timeInNewYork.isAfter(timeInBerlin), is(false));
        assertThat(timeInNewYork.isBefore(timeInBerlin), is(false));
        assertThat(timeInNewYork.isEqual(timeInBerlin), is(true));

        assertThat(timeInNewYork.equals(timeInBerlin), is(false));
        assertThat(timeInNewYork.compareTo(timeInBerlin), is(-1));
    }


    ZonedDateTime zonedTimestamp =
            ZonedDateTime.of(2019, 8, 10, 8, 30, 0, 0, ZoneId.of("America/New_York"));
    ZonedDateTime zonedTimestampToCompare =
            ZonedDateTime.of(2019, 8, 10, 14, 0, 0, 0, ZoneId.of("Europe/Berlin"));
    @Test
    public void comparingDateTimeWithHour() {
        assertThat(DateTimeComparisonUtils.
                isSameHour(zonedTimestamp, zonedTimestampToCompare), is(true));
    }
}

package com.tom.datetolocaldate;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import org.joda.time.Instant;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoField.MILLI_OF_SECOND;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/8
 */
@Slf4j
public class DateToLocalDateConverterTest {
    public final long millis = 1556175797428L;

    /**
     * convert the date into milliseconds by simply invoking the getTime() method
     */
    @Test
    public void givenDate_WhenGetTime_ThenMillis() {
        Date date = new Date(millis);
        log.info("{}", millis);
        Assert.assertEquals(millis, date.getTime());
    }

    @Test
    public void givenCalendar_WhenGetTimeInMillis_ThenMillis() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(millis));
        Assert.assertEquals(millis, calendar.getTimeInMillis());
    }
    @Test
    public void givenJava8Instant_WhenGToEpochMillis_ThenMillis() {
        java.time.Instant instant = java.time.Instant.ofEpochMilli(millis);

        Assert.assertEquals(millis, instant.toEpochMilli());
    }
    @Test
    public void givenJodaInstant_WhenGetMillis_ThenMillis() {
       Instant jodaInstant = Instant.ofEpochMilli(millis);
        Assert.assertEquals(millis, jodaInstant.getMillis());
    }
    @Test
    public void givenLocalDateTime_WhenToEpochMillis_ThenMillis() {
        ZoneId id = ZoneId.systemDefault();

        LocalDateTime localDateTime =
                LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(millis), id);

        ZonedDateTime zdt = ZonedDateTime.of(localDateTime, id);

        Assert.assertEquals(millis, zdt.toInstant().toEpochMilli());
    }

}
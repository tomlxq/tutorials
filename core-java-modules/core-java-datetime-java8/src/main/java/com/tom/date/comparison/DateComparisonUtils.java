package com.tom.date.comparison;

import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class DateComparisonUtils {
    public static boolean isSameDay(Date date, Date dateToCompare) {
        return DateUtils.isSameDay(date, dateToCompare);
    }

    public static boolean isSameHour(Date date, Date dateToCompare) {
        return DateUtils.truncatedEquals(date, dateToCompare, Calendar.HOUR);
    }

    public static Date toDate(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static Date toDate(LocalDateTime dateToConvert) {
        return java.util.Date
                .from(dateToConvert.atZone(ZoneId.systemDefault())
                        .toInstant());
    }
}

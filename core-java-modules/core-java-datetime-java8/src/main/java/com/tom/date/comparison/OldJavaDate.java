package com.tom.date.comparison;

import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import static com.tom.date.comparison.DateComparisonUtils.toDate;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class OldJavaDate {
    Date firstDate = toDate(LocalDateTime.of(2019, 8, 10, 0, 00, 00));
    Date secondDate = toDate(LocalDateTime.of(2019, 8, 15, 0, 00, 00));

    public static boolean isSameDay(Date date, Date dateToCompare) {
        return DateUtils.isSameDay(date, dateToCompare);
    }

    public static boolean isSameHour(Date date, Date dateToCompare) {
        return DateUtils.truncatedEquals(date, dateToCompare, Calendar.HOUR);
    }
}

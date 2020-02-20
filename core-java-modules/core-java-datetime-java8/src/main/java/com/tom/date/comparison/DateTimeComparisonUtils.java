package com.tom.date.comparison;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/9
 */
public class DateTimeComparisonUtils {
    public static boolean isSameDay(LocalDateTime timestamp,
                                    LocalDate localDateToCompare) {
        return timestamp.toLocalDate().isEqual(localDateToCompare);
    }

    public static boolean isSameDay(LocalDateTime timestamp,
                                    LocalDateTime timestampToCompare) {
        return timestamp.truncatedTo(DAYS)
                .isEqual(timestampToCompare.truncatedTo(DAYS));
    }
    public static boolean isSameHour(LocalDateTime timestamp,
                                     LocalDateTime timestampToCompare) {
        return timestamp.truncatedTo(HOURS)
                .isEqual(timestampToCompare.truncatedTo(HOURS));
    }
    public static boolean isSameHour(ZonedDateTime zonedTimestamp,
                                     ZonedDateTime zonedTimestampToCompare) {
        return zonedTimestamp.truncatedTo(HOURS)
                .isEqual(zonedTimestampToCompare.truncatedTo(HOURS));
    }
}

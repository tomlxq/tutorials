package com.tom.concurrent.skiplist;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;
@Getter
@AllArgsConstructor
public class Event {
    private final ZonedDateTime eventTime;
    private final String content;
}

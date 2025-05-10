package com.example.demo.utils;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final DateTimeFormatter ISO_OFFSET_DATE_TIME = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    public static OffsetDateTime nowAsOffsetDateTime() {
        return OffsetDateTime.now(ZoneOffset.UTC);
    }

    public static String toIsoOffsetDateTimeString(OffsetDateTime dt) {
        return dt.format(ISO_OFFSET_DATE_TIME);
    }

    public static OffsetDateTime fromIsoOffsetDateTimeString(String dt) {
        return OffsetDateTime.parse(dt, ISO_OFFSET_DATE_TIME);
    }

    public static String nowOffsetDateTimeString() {
        return DateTimeUtils.nowAsOffsetDateTime().format(ISO_OFFSET_DATE_TIME);
    }
}

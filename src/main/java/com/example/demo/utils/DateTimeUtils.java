package com.example.demo.utils;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final DateTimeFormatter ISO_OFFSET_DATE_TIME = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    private static final DateTimeFormatter ISO_LOCAL_DATE_TIME = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public OffsetDateTime nowAsOffsetDateTime() {
        return OffsetDateTime.now();
    }

    public String toIsoOffsetDateTimeString(OffsetDateTime dt) {
        return dt.format(ISO_OFFSET_DATE_TIME);
    }

    public OffsetDateTime fromIsoOffsetDateTimeString(String dt) {
        return OffsetDateTime.parse(dt, ISO_OFFSET_DATE_TIME);
    }

    public String toIsoLocalDateTimeString(OffsetDateTime dt, ZoneId zoneId) {
        return dt.atZoneSameInstant(zoneId).format(ISO_LOCAL_DATE_TIME);
    }

    public static String nowOffsetDateTimeString() {
        return OffsetDateTime.now(ZoneOffset.UTC).format(ISO_OFFSET_DATE_TIME);
    }
}

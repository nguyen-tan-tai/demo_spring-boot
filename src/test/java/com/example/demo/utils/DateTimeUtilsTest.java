package com.example.demo.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class DateTimeUtilsTest {

    @Test
    public void testNowAsOffsetDateTime() {
        DateTimeUtils.nowAsOffsetDateTime();
    }

    @Test
    public void fromIsoOffsetDateTimeString() {
        assertThat(DateTimeUtils.fromIsoOffsetDateTimeString("2025-01-02T03:04:05.123456789Z"))
                .isEqualTo(OffsetDateTime.of(2025, 1, 2, 3, 4, 5, 123456789, ZoneOffset.UTC));
        assertThat(DateTimeUtils.fromIsoOffsetDateTimeString("2024-02-29T03:04:05.123456789+07:00"))
                .isEqualTo(OffsetDateTime.of(2024, 2, 29, 3, 4, 5, 123456789, ZoneOffset.ofHoursMinutes(7, 0)));
    }

    @Test
    public void toIsoLocalDateTimeString() {
        assertThat(DateTimeUtils.toIsoOffsetDateTimeString(OffsetDateTime.of(2025, 1, 2, 3, 4, 5, 123456789, ZoneOffset.UTC)))
                .isEqualTo("2025-01-02T03:04:05.123456789Z");
        assertThat(DateTimeUtils.toIsoOffsetDateTimeString(OffsetDateTime.of(2024, 2, 29, 3, 4, 5, 123456789, ZoneOffset.ofHoursMinutes(7, 0))))
                .isEqualTo("2024-02-29T03:04:05.123456789+07:00");
    }

    @Test
    public void nowOffsetDateTimeString() {
        String dateTimeString = DateTimeUtils.nowOffsetDateTimeString();
        OffsetDateTime zonedDateTime = OffsetDateTime.parse(dateTimeString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        assertThat(dateTimeString).isEqualTo(zonedDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
    }
}

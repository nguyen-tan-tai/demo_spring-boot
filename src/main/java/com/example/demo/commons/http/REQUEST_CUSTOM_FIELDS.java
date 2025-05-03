package com.example.demo.commons.http;

public enum REQUEST_CUSTOM_FIELDS {

    TRACE_ID("dPnKgAfYODYpfqra"),

    REQUEST_TIMESTAMP("STNVZntvR4McbeJP");

    private String value;

    REQUEST_CUSTOM_FIELDS(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

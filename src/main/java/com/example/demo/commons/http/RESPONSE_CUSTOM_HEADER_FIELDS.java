package com.example.demo.commons.http;

public enum RESPONSE_CUSTOM_HEADER_FIELDS {

    PROCESS_TIME("process-time"),

    TRACE_ID("trace-id");

    private String value;

    RESPONSE_CUSTOM_HEADER_FIELDS(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

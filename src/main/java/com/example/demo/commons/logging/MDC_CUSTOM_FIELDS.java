package com.example.demo.commons.logging;

public enum MDC_CUSTOM_FIELDS {

    TRACE_ID("n2NLCOgGZmMoM2ec");

    private String value;

    MDC_CUSTOM_FIELDS(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

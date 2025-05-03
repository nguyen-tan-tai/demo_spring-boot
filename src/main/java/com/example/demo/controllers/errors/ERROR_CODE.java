package com.example.demo.controllers.errors;

public enum ERROR_CODE implements ErrorCode {

    BAD_REQUEST("40000", "BAD_REQUEST"), 
    BAD_REQUEST_VALIDATION("40001", "VALIDATION"), 
    NOT_FOUND("40401", "NOT_FOUND"), 
    SERVER_ERROR("50001", "SERVER_ERROR"),

    ;

    private String code;

    private String description;

    ERROR_CODE(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}

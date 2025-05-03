package com.example.demo.controllers.errors;

import com.example.demo.controllers.BaseResponse;
import com.example.demo.utils.DateTimeUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.List;

public class ErrorResponse extends BaseResponse {

    private ErrorCode errorCode;

    private String traceId;

    private String timestamp;

    private List<ValidationResponse> validations;

    public ErrorResponse(ErrorCode errorCode, String traceId) {
        this.errorCode = errorCode;
        this.traceId = traceId;
        this.timestamp = DateTimeUtils.nowOffsetDateTimeString();
    }

    public ErrorResponse withValidations(List<ValidationResponse> validations) {
        this.validations = validations;
        return this;
    }

    public ErrorResponse withValidation(ValidationResponse validation) {
        this.validations = Arrays.asList(validation);
        return this;
    }

    public ErrorResponse appendValidation(ValidationResponse validation) {
        this.validations.add(validation);
        return this;
    }

    @JsonProperty(value = "code", index = 1)
    public String getErrorCode() {
        return errorCode.getCode();
    }

    @JsonProperty(value = "descriptions", index = 2)
    public String getDescription() {
        return errorCode.getDescription();
    }

    @JsonProperty(value = "traceId", index = 3)
    public String getTraceId() {
        return traceId;
    }

    @JsonProperty(value = "timestamp", index = 4)
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty(value = "validations", index = 5)
    @JsonInclude(Include.NON_EMPTY)
    public List<ValidationResponse> getValidations() {
        return validations;
    }
}

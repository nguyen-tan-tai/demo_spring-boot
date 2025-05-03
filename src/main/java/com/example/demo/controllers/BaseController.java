package com.example.demo.controllers;

import com.example.demo.controllers.errors.ERROR_CODE;
import com.example.demo.controllers.errors.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    @Autowired
    public HttpServletRequest httpRequest;

    public String getTraceId() {
        return (String) this.httpRequest.getAttribute(CUSTOM_REQUEST_ATTRIBUTE.TRACE_ID.getTraceId());
    }

    public ResponseEntity<?> ok() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> ok(BaseResponse response) {
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> ok(BaseListResponse<?> response) {
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> notFound(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> badRequest() {
        ErrorResponse badRequest = new ErrorResponse(ERROR_CODE.BAD_REQUEST, getTraceId());
        return new ResponseEntity<>(badRequest, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> badRequestValidation() {
        ErrorResponse badRequest = new ErrorResponse(ERROR_CODE.BAD_REQUEST, getTraceId());
        return new ResponseEntity<>(badRequest, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> serverError(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse.toJson(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static enum CUSTOM_REQUEST_ATTRIBUTE {

        TRACE_ID("TRACE_ID"),;

        private String traceId;

        CUSTOM_REQUEST_ATTRIBUTE(String traceId) {
            this.traceId = traceId;
        }

        public String getTraceId() {
            return traceId;
        }
    }
}

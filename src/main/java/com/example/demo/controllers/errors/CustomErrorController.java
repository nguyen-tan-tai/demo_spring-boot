package com.example.demo.controllers.errors;

import com.example.demo.controllers.BaseController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class CustomErrorController extends BaseController implements ErrorController {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> handleException(Throwable e) {
        e.printStackTrace();
        return serverError(new ErrorResponse(ERROR_CODE.SERVER_ERROR, this.getTraceId()));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleNotFound(NoResourceFoundException e) {
        return notFound(new ErrorResponse(ERROR_CODE.NOT_FOUND, this.getTraceId()));
    }
}

package com.example.demo.controllers;

public interface BaseValidator<T extends BaseRequest> {

    void validate(T request);
}

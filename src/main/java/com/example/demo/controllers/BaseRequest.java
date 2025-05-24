package com.example.demo.controllers;

import com.example.demo.controllers.errors.ValidationResponse;
import java.util.List;

public interface BaseRequest {

    List<ValidationResponse> getValidate();
}

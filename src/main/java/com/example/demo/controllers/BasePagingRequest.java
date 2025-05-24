package com.example.demo.controllers;

import org.springframework.data.domain.PageRequest;

public interface BasePagingRequest extends BaseRequest {

    int getPage();

    int getPageSize();

    PageRequest toPageable();
}

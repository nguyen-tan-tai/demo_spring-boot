package com.example.demo.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public interface BasePagingRequest extends BaseRequest {

    int getPage();

    int getLimit();

    String getSort();

    Sort getDefaltSort();

    PageRequest toPageable();
}

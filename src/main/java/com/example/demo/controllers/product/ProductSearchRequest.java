package com.example.demo.controllers.product;

import com.example.demo.controllers.BasePagingRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;

public class ProductSearchRequest extends BasePagingRequest {

    private String name;

    public String getName() {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Sort defaultSort() {
        return Sort.by("id").ascending();
    }
}

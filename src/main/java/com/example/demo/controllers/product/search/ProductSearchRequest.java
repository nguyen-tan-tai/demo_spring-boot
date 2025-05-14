package com.example.demo.controllers.product.search;

import com.example.demo.controllers.BasePagingRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;

public class ProductSearchRequest extends BasePagingRequest {

    private String productName;

    public String getProductName() {
        if (StringUtils.isEmpty(productName)) {
            return null;
        }
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    @Override
    public Sort defaultSort() {
        return Sort.by("prdId").ascending();
    }
}

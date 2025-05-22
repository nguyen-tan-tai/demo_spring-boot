package com.example.demo.controllers.product.search;

import com.example.demo.controllers.BasePagingRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class ProductSearchRequest implements BasePagingRequest {

    @Schema(name = "Page ", requiredMode = RequiredMode.NOT_REQUIRED)
    private int page = 1;

    @Schema(name = "Text to search in product name", requiredMode = RequiredMode.NOT_REQUIRED)
    private String productName;

    @Schema(name = "Limit", requiredMode = RequiredMode.NOT_REQUIRED)
    private int limit = 10;

    @Schema(name = "Sort", requiredMode = RequiredMode.NOT_REQUIRED)
    private String sort;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        if (StringUtils.isEmpty(productName)) {
            return null;
        }
        return productName;
    }

    public PageRequest toPageable() {
        if (StringUtils.isAllEmpty(this.sort)) {
            return PageRequest.of(page - 1, limit, getDefaltSort());
        }
        String[] sortTokens = this.sort.split(",");
        Sort s = Sort.unsorted();
        for (String sortToken : sortTokens) {
            String[] parts = sortToken.split(":");
            String field = parts[0];
            String order = parts[1];
            s.and(Sort.by(Direction.fromString(order), field));
        }
        return PageRequest.of(page - 1, limit, s);
    }

    @Override
    public Sort getDefaltSort() {
        return Sort.by("prdId").ascending();
    }
}

package com.example.demo.controllers.product.search;

import com.example.demo.controllers.BasePagingRequest;
import com.example.demo.controllers.errors.ValidationResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class ProductSearchRequest implements BasePagingRequest {

    @Schema(name = "Page", requiredMode = RequiredMode.NOT_REQUIRED, defaultValue = "1", minimum = "1")
    private int page = 1;

    @Schema(name = "Text to search in product name", requiredMode = RequiredMode.NOT_REQUIRED, example = "shirt")
    private String productName;

    @Schema(name = "Page size", requiredMode = RequiredMode.NOT_REQUIRED, defaultValue = "20", example = "20", minimum = "10")
    private int pageSize = 20;

    @Schema(name = "order", requiredMode = RequiredMode.NOT_REQUIRED, example = "order=name:desc,id:asc")
    private String order;

    @Override
    public List<ValidationResponse> getValidate() {
        return new ArrayList<>();
    }

    public static enum SORTABLE_FIELDS {

        ID("prd_id"), NAME("prd_name"),
        ;

        private String value;

        public String getValue() {
            return this.value;
        }

        private SORTABLE_FIELDS(String value) {
            this.value = value;
        }
    }

    private Sort getSortRequestOrDefault() {
        if (StringUtils.isAllEmpty(this.order)) {
            throw new RuntimeException("Not implement");
        }
        String[] sortTokens = this.order.split(",");
        Sort s = Sort.unsorted();
        for (String sortToken : sortTokens) {
            String[] parts = sortToken.split(":");
            String field = parts[0];
            String order = parts[1];
            s.and(Sort.by(Direction.fromString(order), field));
        } ;
        return s;
    }

    public PageRequest toPageable() {
        return PageRequest.of(page - 1, pageSize, this.getSortRequestOrDefault());
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
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
}

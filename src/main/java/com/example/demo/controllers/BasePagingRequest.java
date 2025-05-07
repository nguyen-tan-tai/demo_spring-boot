package com.example.demo.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public abstract class BasePagingRequest {

    /**
     * 1 based
     */
    private int page = 1;

    private int limit = 10;

    /**
     * ?sort=id:asc,name:desc
     */
    private String sort;

    public void setPage(int page) {
        this.page = page;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public abstract Sort defaultSort();

    /**
     * Convert to zero-index
     * 
     * @return PageRequest
     */
    public PageRequest toPageable() {
        if (StringUtils.isAllEmpty(this.sort)) {
            return PageRequest.of(page - 1, limit, defaultSort());
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
}

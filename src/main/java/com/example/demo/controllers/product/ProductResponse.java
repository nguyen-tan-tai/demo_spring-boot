package com.example.demo.controllers.product;

import com.example.demo.controllers.BaseResponse;
import com.example.demo.models.entities.Product;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ProductResponse extends BaseResponse {

    private Product product;

    public ProductResponse(Product product) {
        this.product = product;
    }

    @JsonProperty(value = "id", index = 1)
    public Long getId() {
        return this.product.getId();
    }

    @JsonProperty(value = "name", index = 2)
    public String getName() {
        return this.product.getName();
    }

    @JsonProperty(value = "stock", index = 3)
    public Long getStock() {
        return this.product.getStock();
    }
}

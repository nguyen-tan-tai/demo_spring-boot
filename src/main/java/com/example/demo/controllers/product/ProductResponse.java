package com.example.demo.controllers.product;

import com.example.demo.controllers.BaseResponse;
import com.example.demo.models.entities.Product;
import com.example.demo.utils.DateTimeUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse extends BaseResponse {

    private Product product;

    public ProductResponse(Product product) {
        this.product = product;
    }

    @JsonProperty(value = "id", index = 1)
    public Long getId() {
        return this.product.getPrdId();
    }

    @JsonProperty(value = "name", index = 2)
    public String getName() {
        return this.product.getPrdName();
    }

    @JsonProperty(value = "category", index = 3)
    public String getCategory() {
        return this.product.getCategory().getCatName();
    }

    @JsonProperty(value = "price", index = 4)
    public String getPriceQuote() {
        return this.product.getPriceQuote().getPrice();
    }

    @JsonProperty(value = "updatedAt", index = 5)
    public String getUpdatedAt() {
        return DateTimeUtils.toIsoOffsetDateTimeString(this.product.getUpdatedAt());
    }
}

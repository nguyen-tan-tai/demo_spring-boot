package com.example.demo.controllers.product;

import com.example.demo.controllers.BaseListResponse;
import com.example.demo.models.entities.Product;
import java.util.List;

public class ProductSearchResponse extends BaseListResponse<ProductResponse> {

    private static final long serialVersionUID = 1L;

    public ProductSearchResponse(List<Product> products) {
        for (Product p : products) {
            this.add(new ProductResponse(p));
        }
    }
}

package com.example.demo.controllers.product;

import com.example.demo.controllers.BaseListResponse;
import com.example.demo.models.entities.Product;
import org.springframework.data.domain.Page;

public class ProductSearchResponse extends BaseListResponse<ProductResponse> {

    private static final long serialVersionUID = 1L;

    public ProductSearchResponse(Page<Product> products) {
        for (Product p : products) {
            this.add(new ProductResponse(p));
        }
    }
}

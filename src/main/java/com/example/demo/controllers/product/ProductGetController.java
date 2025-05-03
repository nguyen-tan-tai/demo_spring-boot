package com.example.demo.controllers.product;

import com.example.demo.controllers.BaseController;
import com.example.demo.controllers.BaseResponse;
import com.example.demo.models.entities.Product;
import com.example.demo.models.repositories.ProductRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductGetController extends BaseController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> get(@PathVariable Long productId) {
        Product product = productRepository.findById(productId).get();
        return ok(new GetProductResponse(product));
    }

    public static class GetProductResponse extends BaseResponse {

        private Product product;

        public GetProductResponse(Product product) {
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
}

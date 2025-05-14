package com.example.demo.controllers.product.get;

import com.example.demo.controllers.BaseController;
import com.example.demo.controllers.product.ProductResponse;
import com.example.demo.models.entities.Product;
import com.example.demo.models.repositories.ProductRepository;
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
        return ok(new ProductResponse(product));
    }
}

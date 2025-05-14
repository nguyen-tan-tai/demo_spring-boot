package com.example.demo.controllers.product.search;

import com.example.demo.controllers.BaseController;
import com.example.demo.models.entities.Product;
import com.example.demo.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductSearchController extends BaseController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<?> search(@RequestBody ProductSearchRequest request) {
        Page<Product> products = productRepository.seach(request.getProductName(), request.toPageable());
        return ok(new ProductSearchResponse(products));
    }
}

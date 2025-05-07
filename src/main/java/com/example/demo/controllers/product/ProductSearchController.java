package com.example.demo.controllers.product;

import com.example.demo.controllers.BaseController;
import com.example.demo.models.entities.Product;
import com.example.demo.models.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductSearchController extends BaseController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<?> search(ProductSearchRequest request) {
        List<Product> products = productRepository.searchByNameWithPagination(request.getName(), request.toPageable());
        // List<Product> products = productRepository.findAllByNameContains(request.getName(), request.toPageable());
        return ok(new ProductSearchResponse(products));
    }
}

package com.example.demo.controllers.product.get;

import com.example.demo.commons.exceptions.ResourceNotFoundException;
import com.example.demo.controllers.BaseController;
import com.example.demo.controllers.product.ProductResponse;
import com.example.demo.models.entities.Product;
import com.example.demo.models.repositories.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Catalog Management", description = "Operations related to catalog")
public class ProductGetController extends BaseController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/{productId}")
    @Operation(summary = "Get product")
    @ApiResponse(responseCode = "200", description = "OK", content = {@Content(schema = @Schema(implementation = ProductResponse.class))})
    public ResponseEntity<?> get(@Parameter(description = "Product ID") @PathVariable Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException());
        return ok(new ProductResponse(product));
    }
}

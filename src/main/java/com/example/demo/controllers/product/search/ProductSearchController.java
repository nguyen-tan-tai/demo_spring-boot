package com.example.demo.controllers.product.search;

import com.example.demo.controllers.BaseController;
import com.example.demo.controllers.product.ProductResponse;
import com.example.demo.models.entities.Product;
import com.example.demo.models.repositories.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Catalog Management", description = "Operations related to catalog")
public class ProductSearchController extends BaseController {

    @Autowired
    private ProductSearchRequestValidator validator;

    @Autowired
    private ProductRepository productRepository;

    @Operation(summary = "Search product")
    @ApiResponse(responseCode = "200", description = "OK", content = {@Content(schema = @Schema(implementation = ProductResponse.class))})
    @GetMapping("/products")
    public ResponseEntity<?> search(@ParameterObject @Valid ProductSearchRequest request) {
        validator.validate(request);
        Page<Product> products = productRepository.seach(request.getProductName(), request.toPageable());
        return ok(new ProductSearchResponse(products));
    }
}

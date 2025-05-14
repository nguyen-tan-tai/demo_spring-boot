package com.example.demo.models.repositories;

import com.example.demo.models.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository extends BaseRepository<Product, Long> {

    Page<Product> findAllByPrdNameContains(String prdName, Pageable pageable);

    default Page<Product> seach(String prdName, Pageable pageable) {
        if (prdName == null) {
            return this.findAll(pageable);
        }
        return this.findAllByPrdNameContains(prdName, pageable);
    }
}

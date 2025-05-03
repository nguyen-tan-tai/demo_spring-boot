package com.example.demo.models.repositories;

import com.example.demo.models.entities.Product;

public interface ProductRepository extends BaseRepository<Product, Long> {

    Product findByName(String name);
}

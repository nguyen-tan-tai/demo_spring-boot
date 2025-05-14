package com.example.demo.models.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.models.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testFindById() {
        Product p50 = productRepository.findById(50L).get();
        assertThat(p50.getPrdId()).isEqualTo(50L);
    }

    @Test
    public void testSearchByNameWithPagination() {
        productRepository.searchByNameWithPagination(null, Pageable.ofSize(100));
    }
}

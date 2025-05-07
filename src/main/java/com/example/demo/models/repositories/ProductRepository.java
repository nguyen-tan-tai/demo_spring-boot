package com.example.demo.models.repositories;

import com.example.demo.models.entities.Product;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends BaseRepository<Product, Long> {

    @Query(value = "SELECT p.id, p.name, p.stock FROM product p WHERE (:name IS NULL OR p.name LIKE %:name%)", nativeQuery = true)
    List<Product> searchByNameWithPagination(@Param("name") String name, Pageable pageable);

    List<Product> findAllByNameContains(String name, Pageable pageable);
}

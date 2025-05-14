package com.example.demo.models.repositories;

import com.example.demo.models.entities.Product;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends BaseRepository<Product, Long> {

    @Query(value = "SELECT p.prd_id, p.prd_name, p.prd_cat, p.prd_dept, p.is_active, p.updated_at, "
            + "c.cat_id, c.cat_name, c.updated_at AS c_updated_at, "
            + "q.id, q.price, q.created_at "
            + "FROM products p "
            + "JOIN categories c ON c.cat_id = p.prd_cat "
            + "JOIN price_quotes q ON q.prd_id = p.prd_id "
            + "WHERE (:prd_name IS NULL OR p.prd_name LIKE '%:prd_name%')", nativeQuery = true)
    public List<Product> searchByNameWithPagination(@Param("prd_name") String prdName, Pageable pageable);
}

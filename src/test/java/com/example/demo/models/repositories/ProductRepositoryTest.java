package com.example.demo.models.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.models.entities.Product;
import com.example.demo.utils.DateTimeUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @Sql(value = "ProductRepositoryTest/testFindById.sql")
    public void testFindById() {
        Product p50 = productRepository.findById(50L).get();
        assertThat(p50.getPrdId()).isEqualTo(50L);
        assertThat(p50.getPrdName()).isEqualTo("Costume Amin");
        assertThat(p50.getPrdCat()).isEqualTo(8L);
        assertThat(p50.getPrdDept()).isEqualTo(3);
        assertThat(p50.getIsActive()).isEqualTo(true);
        assertThat(DateTimeUtils.toIsoOffsetDateTimeString(p50.getUpdatedAt())).isEqualTo("2025-05-13T14:24:40.230301Z");
        assertThat(p50.getCategory().getCatId()).isEqualTo(8L);
        assertThat(p50.getPriceQuote().getId()).isEqualTo(4001L);
        assertThat(p50.getPriceQuote().getPrice()).isEqualTo("24.4");

        Product p51 = productRepository.findById(51L).get();
        assertThat(p51.getPrdId()).isEqualTo(51L);
    }

    @Test
    public void testSearchByNameWithPagination() {
        List<Product> list1 = productRepository.searchByNameWithPagination(null, Pageable.ofSize(5));
        assertThat(list1.size()).isEqualTo(5L);
        assertThat(list1.get(0).getPrdId()).isEqualTo(50L);
        assertThat(list1.get(1).getPrdId()).isEqualTo(51L);
        assertThat(list1.get(2).getPrdId()).isEqualTo(52L);
        assertThat(list1.get(3).getPrdId()).isEqualTo(53L);
        assertThat(list1.get(4).getPrdId()).isEqualTo(54L);
    }
}

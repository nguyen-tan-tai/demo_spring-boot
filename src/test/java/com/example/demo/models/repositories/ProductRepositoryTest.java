package com.example.demo.models.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.models.entities.Product;
import com.example.demo.utils.DateTimeUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @Sql(value = {
            "ProductRepositoryTest/testFindById/products.sql",
            "ProductRepositoryTest/testFindById/categories.sql",
            "ProductRepositoryTest/testFindById/price_quotes.sql"
    })
    public void testFindById() {
        Product p50 = productRepository.findById(50L).get();
        assertThat(p50.getPrdId()).isEqualTo(50L);
        assertThat(p50.getPrdName()).isEqualTo("Costume Amin");
        assertThat(p50.getPrdCat()).isEqualTo(8L);
        assertThat(p50.getPrdDept()).isEqualTo(3);
        assertThat(p50.getIsActive()).isEqualTo(true);
        assertThat(DateTimeUtils.toIsoOffsetDateTimeString(p50.getUpdatedAt())).isEqualTo("2025-05-13T14:24:40.230301Z");
        assertThat(p50.getCategory().getCatId()).isEqualTo(8L);
        assertThat(p50.getPriceQuote().getPriceQuoteId()).isEqualTo(4001L);
        assertThat(p50.getPriceQuote().getPrice()).isEqualTo("24.4");

        Product p51 = productRepository.findById(51L).get();
        assertThat(p51.getPrdId()).isEqualTo(51L);
        assertThat(p51.getIsActive()).isEqualTo(false);
        assertThat(p51.getCategory().getCatId()).isEqualTo(4L);
        assertThat(p51.getPriceQuote().getPriceQuoteId()).isEqualTo(4002L);
        assertThat(p51.getPriceQuote().getPrice()).isEqualTo("48.2");
    }

    @Test
    @Sql(value = {
            "ProductRepositoryTest/testSearch/products.sql",
            "ProductRepositoryTest/testSearch/categories.sql",
            "ProductRepositoryTest/testSearch/price_quotes.sql",
    })
    public void testSearch() {
        Page<Product> page1 = productRepository.seach(null, Pageable.ofSize(5).withPage(0));
        List<Product> list1 = page1.getContent();
        assertThat(list1.size()).isEqualTo(5L);
        assertThat(list1.get(0).getPrdId()).isEqualTo(50L);
        assertThat(list1.get(1).getPrdId()).isEqualTo(51L);
        assertThat(list1.get(2).getPrdId()).isEqualTo(52L);
        assertThat(list1.get(3).getPrdId()).isEqualTo(53L);
        assertThat(list1.get(4).getPrdId()).isEqualTo(54L);

        Page<Product> page2 = productRepository.seach(null, Pageable.ofSize(5).withPage(1));
        List<Product> list2 = page2.getContent();
        assertThat(list2.size()).isEqualTo(5L);
        assertThat(list2.get(0).getPrdId()).isEqualTo(55L);
        assertThat(list2.get(1).getPrdId()).isEqualTo(56L);
        assertThat(list2.get(2).getPrdId()).isEqualTo(57L);
        assertThat(list2.get(3).getPrdId()).isEqualTo(58L);
        assertThat(list2.get(4).getPrdId()).isEqualTo(59L);

        Page<Product> searchAnPage = productRepository.seach("an", Pageable.ofSize(1000).withPage(0));
        List<Product> listAn = searchAnPage.getContent();
        assertThat(listAn.size()).isEqualTo(4L);
        assertThat(listAn.get(0).getPrdId()).isEqualTo(60L);
        assertThat(listAn.get(1).getPrdId()).isEqualTo(64L);
        assertThat(listAn.get(2).getPrdId()).isEqualTo(67L);
        assertThat(listAn.get(3).getPrdId()).isEqualTo(75L);

        Page<Product> searchLePage = productRepository.seach("le", Pageable.ofSize(1000).withPage(0));
        List<Product> listLe = searchLePage.getContent();
        assertThat(listLe.size()).isEqualTo(3L);
        assertThat(listLe.get(0).getPrdId()).isEqualTo(51L);
        assertThat(listLe.get(1).getPrdId()).isEqualTo(54L);
        assertThat(listLe.get(2).getPrdId()).isEqualTo(76L);
    }
}

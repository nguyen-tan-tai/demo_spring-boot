package com.example.demo.models.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "price_quotes")
public class PriceQuote extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "pq_id")
    private Long priceQuoteId;

    @Column(name = "prd_id", nullable = false)
    private Long prdId;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "prd_id", nullable = false, insertable = false, updatable = false)
    private Product product;

    public Long getPriceQuoteId() {
        return priceQuoteId;
    }

    public void setPriceQuoteId(Long priceQuoteId) {
        this.priceQuoteId = priceQuoteId;
    }

    public Long getPrdId() {
        return prdId;
    }

    public void setPrdId(Long prdId) {
        this.prdId = prdId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

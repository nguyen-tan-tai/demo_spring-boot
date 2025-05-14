package com.example.demo.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "prd_id")
    private Long prdId;

    @Column(name = "prd_name", length = 255, nullable = false)
    private String prdName;

    @Column(name = "prd_cat", nullable = false)
    private Long prdCat;

    @Column(name = "prd_dept", nullable = false)
    private Integer prdDept;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "prd_cat", referencedColumnName = "cat_id", insertable = false, updatable = false)
    private Category category;

    @OneToOne
    @JoinColumn(name = "prd_id", referencedColumnName = "prd_id", insertable = false, updatable = false)
    private PriceQuote priceQuote;

    public static enum DEPARTMENT {
        MALE(1),
        FEMALE(2),
        UNISEX(3),;

        private Integer value;

        private DEPARTMENT(int i) {
            this.value = i;
        }

        public Integer getValue() {
            return value;
        }

        private static final Map<Integer, DEPARTMENT> ENUM_MAP;
        static {
            Map<Integer, DEPARTMENT> map = new ConcurrentHashMap<Integer, DEPARTMENT>();
            for (DEPARTMENT e : DEPARTMENT.values()) {
                map.put(e.value, e);
            }
            ENUM_MAP = Collections.unmodifiableMap(map);
        }

        public static DEPARTMENT fromValue(Integer value) {
            return ENUM_MAP.get(value);
        }
    }

    public Long getPrdId() {
        return prdId;
    }

    public void setPrdId(Long prdId) {
        this.prdId = prdId;
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public Long getPrdCat() {
        return prdCat;
    }

    public void setPrdCat(Long prdCat) {
        this.prdCat = prdCat;
    }

    public Integer getPrdDept() {
        return prdDept;
    }

    public void setPrdDept(Integer prdDept) {
        this.prdDept = prdDept;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public PriceQuote getPriceQuote() {
        return priceQuote;
    }

    public void setPriceQuote(PriceQuote priceQuote) {
        this.priceQuote = priceQuote;
    }
}

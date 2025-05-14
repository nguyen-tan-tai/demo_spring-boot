package com.example.demo.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long ordId;

    @Column(name = "cust_id", nullable = false)
    private Long custId;

    @Column(name = "status", nullable = false)
    private Integer paymentStatus;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    public static enum ORDER_STATUS {
        PENDING(1),
        ACCEPTED(2),
        PAID(3),
        CANCELLED(3),
        REFUNDED(3),
        ;

        private Integer value;

        private ORDER_STATUS(int i) {
            this.value = i;
        }

        public Integer getValue() {
            return value;
        }

        private static final Map<Integer, ORDER_STATUS> ENUM_MAP;
        static {
            Map<Integer, ORDER_STATUS> map = new ConcurrentHashMap<Integer, ORDER_STATUS>();
            for (ORDER_STATUS e : ORDER_STATUS.values()) {
                map.put(e.value, e);
            }
            ENUM_MAP = Collections.unmodifiableMap(map);
        }

        public static ORDER_STATUS fromValue(Integer value) {
            return ENUM_MAP.get(value);
        }
    }

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

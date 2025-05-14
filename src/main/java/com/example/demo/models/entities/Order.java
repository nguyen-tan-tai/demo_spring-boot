package com.example.demo.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq_generator")
    @SequenceGenerator(name = "orders_seq_generator", sequenceName = "orders_cat_id_seq", allocationSize = 1)
    @Column(name = "order_id")
    private Long ordId;

    @Column(name = "cust_id", nullable = false)
    private Long custId;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    public static enum ORDER_STATUS {
        RECEIVED(0),
        PENDING(1),
        ACCEPTED(2),
        REJECTED(4),
        PAID(5),
        CANCELLED(6),
        REFUNDED(7),
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

    public Integer getStatus() {
        return status;
    }

    public ORDER_STATUS getStatusAsEnum() {
        return ORDER_STATUS.fromValue(this.status);
    }

    public void setStatus(ORDER_STATUS status) {
        this.status = status.getValue();
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

package com.example.demo.controllers.order.place;

import java.util.List;

public class PlaceOrderRequest {

    private List<ItemRequest> items;

    public List<ItemRequest> getItems() {
        return items;
    }

    public void setItems(List<ItemRequest> items) {
        this.items = items;
    }

    public static class ItemRequest {
        private Long prdId;
        private Integer quantity;
        private String referencePrice;

        public Long getPrdId() {
            return prdId;
        }

        public void setPrdId(Long prdId) {
            this.prdId = prdId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getReferencePrice() {
            return referencePrice;
        }

        public void setReferencePrice(String referencePrice) {
            this.referencePrice = referencePrice;
        }
    }
}

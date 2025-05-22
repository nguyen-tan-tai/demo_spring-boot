package com.example.demo.controllers.order.place;

import com.example.demo.models.entities.OrderItem;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlaceOrderRequest {

    private List<ItemRequest> items;

    @Hidden
    public List<OrderItem> getItemsAsOrderItems() {
        if (items == null) {
            return new ArrayList<>();
        }
        return items.stream().map(e -> e.toOrderItem()).collect(Collectors.toList());
    }

    public void setItems(List<ItemRequest> items) {
        this.items = items;
    }

    public static class ItemRequest {

        private Long prdId;
        private Integer quantity;
        private String price;

        public OrderItem toOrderItem() {
            OrderItem od = new OrderItem();
            od.setPrdId(this.prdId);
            od.setQuantity(this.quantity);
            od.setPrice(this.price);
            return od;
        }

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

        public String getPrice() {
            return price;
        }

        public void setReferencePrice(String price) {
            this.price = price;
        }
    }
}

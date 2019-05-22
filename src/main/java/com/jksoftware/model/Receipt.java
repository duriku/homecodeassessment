package com.jksoftware.model;

import com.jksoftware.model.item.OrderItem;
import java.util.List;

public class Receipt {
    private Price total;
    private Price subTotal;
    private List<OrderItem> orderItems;

    public Receipt(final Price total, final Price subTotal, final List<OrderItem> orderItems) {
        this.total = total;
        this.subTotal = subTotal;
        this.orderItems = orderItems;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Price getSubTotal() {
        return subTotal;
    }

    public Price getTotal() {
        return total;
    }
}

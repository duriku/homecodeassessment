package com.jksoftware.model;

import com.jksoftware.model.discount.Discount;
import java.util.List;

import com.jksoftware.model.item.OrderItem;

public class Receipt {
    private Price total;
    private Price subTotal;
    private List<OrderItem> orderItems;
    private List<Discount> appliedDiscounts;

    public Receipt(final Price total, final Price subTotal, final List<OrderItem> orderItems, final List<Discount> appliedDiscounts) {
        this.total = total;
        this.subTotal = subTotal;
        this.orderItems = orderItems;
        this.appliedDiscounts = appliedDiscounts;
    }

    public List<Discount> getAppliedDiscounts() {
        return appliedDiscounts;
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

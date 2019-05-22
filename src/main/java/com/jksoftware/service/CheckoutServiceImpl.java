package com.jksoftware.service;

import static com.google.common.collect.Lists.newArrayList;
import static com.jksoftware.model.Price.ZERO;

import java.util.List;

import com.jksoftware.model.Price;
import com.jksoftware.model.Receipt;
import com.jksoftware.model.discount.Discount;
import com.jksoftware.model.item.OrderItem;
import com.jksoftware.service.impl.CheckoutService;

public class CheckoutServiceImpl implements CheckoutService {

    private List<OrderItem> orderItems;
    private List<Discount> discounts;

    public CheckoutServiceImpl(final List<OrderItem> orderItems, final List<Discount> discounts) {
        assert orderItems != null : "Order Items Cannot be null";
        this.orderItems = orderItems;
        this.discounts = discounts;
    }

    @Override
    public Receipt checkout() {
        final Price subTotal = orderItems.stream()
                .map(orderItem -> orderItem.getCost())
                .reduce((p1, p2) -> p1.add(p2)).orElse(ZERO);
        final Price total = subTotal;

        final Receipt receipt = new Receipt(subTotal, total, orderItems, newArrayList());
        return receipt;
    }
}

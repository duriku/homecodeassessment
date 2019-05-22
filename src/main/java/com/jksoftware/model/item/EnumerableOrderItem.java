package com.jksoftware.model.item;

import com.jksoftware.model.Price;

public class EnumerableOrderItem extends OrderItem {
    private int count;

    public EnumerableOrderItem(final Item item, final int count) {
        this.item = item;
        this.count = count;
    }

    @Override
    public Price getCost() {
        return this.item.getPrice().multiple(this.count);
    }
}

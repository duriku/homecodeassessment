package com.jksoftware.model.item;

import com.jksoftware.model.Price;

public class MeasurableOrderItem extends OrderItem {

    private Double weight;

    public MeasurableOrderItem(final Item item, final Double weight) {
        this.item = item;
        this.weight = weight;
    }

    @Override
    public Price getCost() {
        return this.item.getPrice().multiple(this.weight);
    }
}

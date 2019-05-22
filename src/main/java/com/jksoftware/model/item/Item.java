package com.jksoftware.model.item;

import com.jksoftware.model.Price;

public class Item {
    private String name;
    private Price price;
    private Boolean isMeasurable;

    public Item(final String name, final Price price, final Boolean isMeasurable) {
        this.name = name;
        this.price = price;
        this.isMeasurable = isMeasurable;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public Boolean getMeasurable() {
        return isMeasurable;
    }
}

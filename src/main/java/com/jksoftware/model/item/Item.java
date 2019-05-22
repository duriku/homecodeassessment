package com.jksoftware.model.item;

import com.jksoftware.model.Price;

public class Item {

    private String name;
    private Price price;

    public Item(final String name, final Price price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}

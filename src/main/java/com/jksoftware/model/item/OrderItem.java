package com.jksoftware.model.item;

import com.jksoftware.model.Price;

public abstract class OrderItem {
    protected Item item;

    public abstract Price getCost();
}

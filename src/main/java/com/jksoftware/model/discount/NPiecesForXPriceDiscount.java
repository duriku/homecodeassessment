package com.jksoftware.model.discount;

import com.jksoftware.model.Price;
import com.jksoftware.model.item.Item;

public class NPiecesForXPriceDiscount implements NItemsDiscount {

    private Item discountedItem;
    private String name;
    private Price batchPrice;
    private int numberOfItemsToMatch;

    public NPiecesForXPriceDiscount(final Item discountedItem, final String name,
                                    final int numberOfItemsToMatch, final Price batchPrice) {
        this.discountedItem = discountedItem;
        this.name = name;
        this.batchPrice = batchPrice;
        this.numberOfItemsToMatch = numberOfItemsToMatch;
    }

    @Override
    public Item getDiscountedItem() {
        return discountedItem;
    }

    public Price getDiscountValue() {
        return discountedItem.getPrice().multiple(numberOfItemsToMatch).subtract(batchPrice);
    }

    @Override
    public String getDiscountName() {
        return name;
    }

    @Override
    public int getItemCountForDiscount() {
        return numberOfItemsToMatch;
    }
}

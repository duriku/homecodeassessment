package com.jksoftware.model.discount;

import com.jksoftware.model.Price;
import com.jksoftware.model.item.Item;

public abstract class NPiecesAbstractDiscount implements Discount {

    protected Item discountedItem;
    protected int forItemCount;

    public abstract Price getDiscountValue();

    public abstract String getDiscountName();

    @Override
    public Item getDiscountedItem() {
        return discountedItem;
    }
}

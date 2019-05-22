package com.jksoftware.model.discount;

import com.jksoftware.model.Price;
import com.jksoftware.model.item.Item;

public interface Discount {
    Item getDiscountedItem();
    Price getDiscountValue();
}

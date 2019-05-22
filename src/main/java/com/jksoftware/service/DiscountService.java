package com.jksoftware.service;

import com.jksoftware.model.Price;
import com.jksoftware.model.discount.Discount;
import com.jksoftware.model.item.OrderItem;
import java.util.List;

public interface DiscountService {
	Price calculateDiscount(final List<OrderItem> orderItems, final Discount discount);
}

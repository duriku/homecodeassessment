package com.jksoftware.service.impl;

import com.jksoftware.exception.InvalidDiscountType;
import com.jksoftware.model.Price;
import com.jksoftware.model.discount.Discount;
import com.jksoftware.model.discount.NItemsDiscount;
import com.jksoftware.model.item.EnumerableOrderItem;
import com.jksoftware.model.item.OrderItem;
import com.jksoftware.service.DiscountService;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {
	@Override
	public Price calculateDiscount(final List<OrderItem> orderItems, final Discount discount) {
		if (discount instanceof NItemsDiscount) {
			return calculateNItemsDiscount(orderItems, (NItemsDiscount) discount);
		}
		throw new InvalidDiscountType(discount);
	}

	private Price calculateNItemsDiscount(final List<OrderItem> orderItems, final NItemsDiscount discount) {
		final int itemCountForDiscount = orderItems.stream()
				.filter(e -> e instanceof EnumerableOrderItem)
				.map(e -> (EnumerableOrderItem) e)
				.filter(e -> e.getItem().equals(discount.getDiscountedItem()))
				.map(e -> e.getCount())
				.mapToInt(i -> i)
				.sum();

		int discountApplied = itemCountForDiscount / discount.getItemCountForDiscount();
		return discount.getDiscountValue().multiple(discountApplied);
	}
}

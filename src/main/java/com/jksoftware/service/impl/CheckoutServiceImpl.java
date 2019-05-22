package com.jksoftware.service.impl;

import com.jksoftware.model.Price;
import static com.jksoftware.model.Price.ZERO;
import com.jksoftware.model.Receipt;
import com.jksoftware.model.discount.Discount;
import com.jksoftware.model.item.OrderItem;
import com.jksoftware.service.CheckoutService;
import com.jksoftware.service.DiscountService;
import java.util.List;
import static java.util.Objects.isNull;
import java.util.stream.Collectors;

public class CheckoutServiceImpl implements CheckoutService {

	private DiscountService discountService = new DiscountServiceImpl();
	private List<OrderItem> orderItems;
	private List<Discount> discounts;

	public CheckoutServiceImpl(final List<OrderItem> orderItems, final List<Discount> discounts) {
		assert orderItems != null : "Order Items Cannot be null";
		this.orderItems = orderItems;
		this.discounts = discounts;
	}

	@Override
	public Receipt checkout() {
		final Price subTotal = orderItems.stream()
				.map(OrderItem::getCost)
				.reduce(Price::add).orElse(ZERO);
		final Price totalSavingsOnDiscounts = calculateDiscounts();
		final Price total = subTotal.subtract(totalSavingsOnDiscounts);
		return new Receipt(total, subTotal, orderItems);
	}

	private Price calculateDiscounts() {
		if (isNull(this.discounts)) {
			return ZERO;
		}

		final List<Price> savedDiscountsOnProducts = this.discounts.stream()
				.map(discount -> discountService.calculateDiscount(this.orderItems, discount))
				.collect(Collectors.toList());
		return savedDiscountsOnProducts
				.stream()
				.reduce(Price::add).orElse(ZERO);
	}
}

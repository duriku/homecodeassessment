package com.jksoftware.service.impl;

import static com.google.common.collect.Lists.newArrayList;
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
				.map(orderItem -> orderItem.getCost())
				.reduce((p1, p2) -> p1.add(p2)).orElse(ZERO);
		final Price totalSavingsOnDiscounts = calculateDiscounts();
		final Price total = subTotal.subtract(totalSavingsOnDiscounts);
		final Receipt receipt = new Receipt(total, subTotal, orderItems, newArrayList());
		return receipt;
	}

	private Price calculateDiscounts() {
		if (isNull(this.discounts)) {
			return ZERO;
		}

		// TODO: INCLUDE ITEM INTO DISCOUNT RESPONSE FOR PRINTING
		final List<Price> savedDiscountsOnProducts = this.discounts.stream()
				.map(discount -> discountService.calculateDiscount(this.orderItems, discount))
				.collect(Collectors.toList());
		final Price totalSavingsOnDiscounts = savedDiscountsOnProducts
				.stream()
				.reduce((e1, e2) -> e1.add(e2)).orElse(ZERO);

		return totalSavingsOnDiscounts;
	}
}

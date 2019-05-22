package com.jksoftware.service;

import com.jksoftware.model.Receipt;
import com.jksoftware.model.discount.Discount;
import com.jksoftware.model.item.OrderItem;
import com.jksoftware.service.impl.CheckoutService;
import java.util.List;

public class CheckoutServiceImpl implements CheckoutService {

	public CheckoutServiceImpl(final List<OrderItem> orderItems, final List<Discount> discounts) {

	}

	@Override
	public Receipt checkout() {
		throw new RuntimeException("Not implemented");
	}
}

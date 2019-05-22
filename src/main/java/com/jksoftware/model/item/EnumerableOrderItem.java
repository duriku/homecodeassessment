package com.jksoftware.model.item;

import com.jksoftware.model.Price;

public class EnumerableOrderItem extends OrderItem {
	private int count;

	@Override
	public Price getCost() {
		return null;
	}
}

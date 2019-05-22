package com.jksoftware.model.item;

import com.jksoftware.model.Price;

public abstract class OrderItem {

	private Item item;

	public abstract Price getCost();
}

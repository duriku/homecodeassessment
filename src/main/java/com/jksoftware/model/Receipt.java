package com.jksoftware.model;

import com.jksoftware.model.item.OrderItem;
import java.util.List;

public class Receipt {
	private Price total;
	private Price subTotal;
	private List<List> appliedDiscounts;
	private List<OrderItem> orderItems;

	public List<List> getAppliedDiscounts() {
		return appliedDiscounts;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public Price getSubTotal() {
		return subTotal;
	}

	public Price getTotal() {
		return total;
	}
}

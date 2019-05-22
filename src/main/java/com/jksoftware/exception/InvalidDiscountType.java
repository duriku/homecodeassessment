package com.jksoftware.exception;

import com.jksoftware.model.discount.Discount;

public class InvalidDiscountType extends RuntimeException {

	private transient Discount discount;

	public InvalidDiscountType(final Discount discount) {
		this.discount = discount;
	}
}

package com.jksoftware.model.discount;

import com.jksoftware.model.Price;

public class NPiecesForMPieceDiscount extends NPiecesAbstractDiscount {

	public Price getDiscountValue() {
		return discountedItem.getPrice().muiltiple(forItemCount);
	}

	@Override
	public String getDiscountName() {
		return null;
	}
}

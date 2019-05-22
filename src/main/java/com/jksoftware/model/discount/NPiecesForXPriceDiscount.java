package com.jksoftware.model.discount;

import com.jksoftware.model.Price;
import com.jksoftware.model.item.Item;

public class NPiecesForXPriceDiscount implements NItemsDiscount {
	private Item discountedItem;
	private Price batchPrice;
	private int numberOfItemsToMatch;

	public NPiecesForXPriceDiscount(final Item discountedItem,
									final int numberOfItemsToMatch,
									final Price batchPrice) {
		this.discountedItem = discountedItem;
		this.batchPrice = batchPrice;
		this.numberOfItemsToMatch = numberOfItemsToMatch;
	}

	public Price getDiscountValue() {
		return discountedItem.getPrice().multiple(numberOfItemsToMatch).subtract(batchPrice);
	}

	@Override
	public Item getDiscountedItem() {
		return discountedItem;
	}

	@Override
	public int getItemCountForDiscount() {
		return numberOfItemsToMatch;
	}
}

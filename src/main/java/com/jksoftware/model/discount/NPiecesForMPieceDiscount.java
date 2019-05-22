package com.jksoftware.model.discount;

import com.jksoftware.model.Price;
import com.jksoftware.model.item.Item;

public class NPiecesForMPieceDiscount implements NItemsDiscount {
	private Item discountedItem;
	private int count;
	private int numberOfItemsToMatch;

	public NPiecesForMPieceDiscount(final Item discountedItem,
									final int numberOfItemsToMatch,
									final int count) {
		this.discountedItem = discountedItem;
		this.count = count;
		this.numberOfItemsToMatch = numberOfItemsToMatch;
	}

	public Price getDiscountValue() {
		return discountedItem.getPrice().multiple(numberOfItemsToMatch - count);
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

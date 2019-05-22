package com.jksoftware.model.discount;

import com.jksoftware.model.Price;
import com.jksoftware.model.item.Item;

public class NPiecesForMPieceDiscount implements NItemsDiscount {

	private Item discountedItem;
	private String name;
	private int count;
	private int numberOfItemsToMatch;

	public NPiecesForMPieceDiscount(final Item discountedItem, final String name,
									final int numberOfItemsToMatch, final int count) {
		this.discountedItem = discountedItem;
		this.name = name;
		this.count = count;
		this.numberOfItemsToMatch = numberOfItemsToMatch;
	}

	@Override
	public Item getDiscountedItem() {
		return discountedItem;
	}

	public Price getDiscountValue() {
		return discountedItem.getPrice().multiple(numberOfItemsToMatch - count);
	}

	@Override
	public int getItemCountForDiscount() {
		return numberOfItemsToMatch;
	}
}

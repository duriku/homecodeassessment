package com.jksoftware.helper;

import static com.jksoftware.helper.TestDataProvider.ITEMS.COCA_COLA;
import static com.jksoftware.helper.TestDataProvider.ITEMS.DORITOS;
import com.jksoftware.model.Price;
import com.jksoftware.model.discount.NItemsDiscount;
import com.jksoftware.model.discount.NPiecesForMPieceDiscount;
import com.jksoftware.model.discount.NPiecesForXPriceDiscount;
import com.jksoftware.model.item.Item;

public class TestDataProvider {
	public static class ITEMS {
		public static final Item COCA_COLA = new Item("Coca Cola 2L", new Price("3"));
		public static final Item PEPSI_COLA = new Item("Pepsi 2L", new Price("2.5"));
		public static final Item DORITOS = new Item("Doritos", new Price("1.00"));
		public static final Item BANANAS = new Item("Bananas", new Price("1.50"));
		public static final Item KIWIS = new Item("Bananas", new Price("2.00"));
	}

	public static class DISCOUNTS {
		public static final NItemsDiscount THREE_COKE_FOR_TWO = new NPiecesForMPieceDiscount(COCA_COLA,
				"Three Coke for two", 3, 2);

		public static final NItemsDiscount FIVE_DORITOS_FOR_THREE_POUNDS = new NPiecesForXPriceDiscount(DORITOS,
				"Five Doritos for three pounds", 5, new Price("3.00"));

	}

}

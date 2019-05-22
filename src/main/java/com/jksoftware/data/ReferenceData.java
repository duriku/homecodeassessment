package com.jksoftware.data;

import static com.jksoftware.data.ReferenceData.ITEMS.*;
import com.jksoftware.model.Price;
import com.jksoftware.model.discount.NItemsDiscount;
import com.jksoftware.model.discount.NPiecesForMPieceDiscount;
import com.jksoftware.model.discount.NPiecesForXPriceDiscount;
import com.jksoftware.model.item.Item;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.HashMap;
import java.util.Map;

public class ReferenceData {
	public static class ITEMS {
		public static final Item COCA_COLA = new Item("Coca Cola 2L", new Price("3"), FALSE);
		public static final Item PEPSI_COLA = new Item("Pepsi 2L", new Price("2.5"), FALSE);
		public static final Item DORITOS = new Item("Doritos", new Price("1.00"), FALSE);
		public static final Item BANANAS = new Item("Bananas", new Price("1.50"), TRUE);
		public static final Item KIWIS = new Item("Bananas", new Price("2.00"), TRUE);
	}

	public static Map<String, Item> ITEMS_MAP = initItemsMap();

	public static class DISCOUNTS {
		public static final NItemsDiscount THREE_COKE_FOR_TWO = new NPiecesForMPieceDiscount(COCA_COLA,
				3, 2);
		public static final NItemsDiscount FIVE_DORITOS_FOR_THREE_POUNDS = new NPiecesForXPriceDiscount(DORITOS,
				5, new Price("3.00"));
	}

	private static Map<String, Item> initItemsMap() {
		final Map<String, Item> itemsMap = new HashMap<>();
		itemsMap.put("COCA_COLA", COCA_COLA);
		itemsMap.put("PEPSI_COLA", PEPSI_COLA);
		itemsMap.put("DORITOS", DORITOS);
		itemsMap.put("BANANAS", BANANAS);
		itemsMap.put("KIWIS", KIWIS);
		return itemsMap;

	}
}

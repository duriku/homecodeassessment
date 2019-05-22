package com.jksoftware;

import static com.jksoftware.data.ReferenceData.ITEMS_MAP;
import com.jksoftware.model.Receipt;
import com.jksoftware.model.item.EnumerableOrderItem;
import com.jksoftware.model.item.Item;
import com.jksoftware.model.item.MeasurableOrderItem;
import com.jksoftware.model.item.OrderItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.String.format;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

class CommandLineShoppingWizard {

	private static final String CHECKOUT = "checkout";

	private BufferedReader reader;

	CommandLineShoppingWizard() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
	}

	List<OrderItem> readOrdersFromTheUser() {
		final List<OrderItem> orderItems = new ArrayList<>();

		String input;
		do {
			System.out.println("Type a product name from the list or type 'checkout' once you are done: ");
			input = readLine();
			final Item item = ITEMS_MAP.get(input.toUpperCase());
			if (nonNull(item) && !input.equalsIgnoreCase(CHECKOUT)) {
				int amount = getAmountFromConsole();
				addItemToOrders(orderItems, item, amount);
			}
		}
		while (!input.equalsIgnoreCase(CHECKOUT));

		return orderItems;
	}

	void printReceipt(final Receipt receipt) {
		System.out.println("Recipe");
		receipt.getOrderItems().forEach(this::printOrder);
		System.out.println(format("Total without discounts %s", receipt.getSubTotal()));
		System.out.println(format("Total after applied discounts %s", receipt.getTotal()));
	}

	private void printOrder(final OrderItem orderItem) {
		if (orderItem instanceof MeasurableOrderItem) {
			printMeasurableOrderItem((MeasurableOrderItem) orderItem);
		} else if (orderItem instanceof EnumerableOrderItem) {
			printEnumerableOrderItem((EnumerableOrderItem) orderItem);
		}
	}

	private void printEnumerableOrderItem(final EnumerableOrderItem orderItem) {
		System.out.println(format("%d X %s   %s", orderItem.getCount(),
				orderItem.getItem().getName(), orderItem.getCost()));
	}

	private void printMeasurableOrderItem(final MeasurableOrderItem orderItem) {
		System.out.println(format("%sg of %s   %s", orderItem.getWeight().toString(),
				orderItem.getItem().getName(), orderItem.getCost()));
	}

	private void addItemToOrders(final List<OrderItem> orderItems, final Item item, final int amount) {
		if (isNull(item) || amount == 0) {
			return;
		}

		if (item.getMeasurable()) {
			orderItems.add(new MeasurableOrderItem(item, (amount / 1000d)));
		} else {
			orderItems.add(new EnumerableOrderItem(item, amount));
		}
	}

	private int getAmountFromConsole() {
		int amount = 0;
		do {
			System.out.println("Type how much you want from it (for fruits provide it in grams)");

			try {
				amount = Integer.parseInt(readLine());
			} catch (NumberFormatException ex) {
				System.out.println("Invalid Amount, please provide an integer!");
			}
		} while (amount == 0);
		return amount;
	}

	private String readLine() {
		String name = null;
		try {
			name = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return name;
	}

}

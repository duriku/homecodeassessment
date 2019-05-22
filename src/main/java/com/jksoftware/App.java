package com.jksoftware;

import static com.google.common.collect.Lists.newArrayList;
import static com.jksoftware.Constants.BANNER;
import static com.jksoftware.data.ReferenceData.DISCOUNTS.FIVE_DORITOS_FOR_THREE_POUNDS;
import static com.jksoftware.data.ReferenceData.DISCOUNTS.THREE_COKE_FOR_TWO;
import com.jksoftware.model.Receipt;
import com.jksoftware.model.discount.Discount;
import com.jksoftware.model.item.OrderItem;
import com.jksoftware.service.impl.CheckoutServiceImpl;
import java.util.List;

public class App {
	public static void main(String[] args) {
		printBanner();

		final CommandLineShoppingWizard commandLineShoppingWizard = new CommandLineShoppingWizard();
		final List<OrderItem> orders = commandLineShoppingWizard.readOrdersFromTheUser();

		final List<Discount> discounts = newArrayList(THREE_COKE_FOR_TWO, FIVE_DORITOS_FOR_THREE_POUNDS);
		final CheckoutServiceImpl checkoutService = new CheckoutServiceImpl(orders, discounts);
		final Receipt receipt = checkoutService.checkout();
		commandLineShoppingWizard.printReceipt(receipt);
	}

	private static void printBanner() {
		System.out.println(BANNER);
	}

}

package com.jksoftware.service;

import static com.google.common.collect.Lists.newArrayList;
import static com.jksoftware.data.ReferenceData.DISCOUNTS.FIVE_DORITOS_FOR_THREE_POUNDS;
import static com.jksoftware.data.ReferenceData.DISCOUNTS.THREE_COKE_FOR_TWO;
import static com.jksoftware.data.ReferenceData.ITEMS.*;
import com.jksoftware.model.Receipt;
import com.jksoftware.model.item.EnumerableOrderItem;
import com.jksoftware.model.item.MeasurableOrderItem;
import com.jksoftware.model.item.OrderItem;
import com.jksoftware.service.impl.CheckoutServiceImpl;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class CheckoutServiceTest {

	@Test
	public void testCheckoutEmptyOrder() {
		final CheckoutService checkoutService = new CheckoutServiceImpl(newArrayList(), null);
		final Receipt receipt = checkoutService.checkout();
		assertPrice(receipt, "£0.00", "£0.00");
	}

	@Test
	public void testCheckoutSingleEnumerableOrder() {
		final List<OrderItem> enumerableOrderItems = newArrayList(new EnumerableOrderItem(COCA_COLA, 2));

		final CheckoutService checkoutService = new CheckoutServiceImpl(enumerableOrderItems, null);
		final Receipt receipt = checkoutService.checkout();
		assertPrice(receipt, "£6.00", "£6.00");
	}

	@Test
	public void testCheckoutSingleMeasurableOrder() {
		final List<OrderItem> enumerableOrderItems = newArrayList(new MeasurableOrderItem(BANANAS, 0.4));

		final CheckoutService checkoutService = new CheckoutServiceImpl(enumerableOrderItems, null);
		final Receipt receipt = checkoutService.checkout();
		assertPrice(receipt, "£0.60", "£0.60");
	}

	@Test
	public void testCheckoutSingleEnumerableOrderAndSingleMeasurableOrder() {
		final List<OrderItem> enumerableOrderItems = newArrayList(
				new EnumerableOrderItem(COCA_COLA, 2),
				new MeasurableOrderItem(BANANAS, 0.4));

		final CheckoutService checkoutService = new CheckoutServiceImpl(enumerableOrderItems, null);
		final Receipt receipt = checkoutService.checkout();
		assertPrice(receipt, "£6.60", "£6.60");
	}

	@Test
	public void testCheckoutMultipleEnumerableOrderAndMultipleMeasurableOrder() {
		final List<OrderItem> enumerableOrderItems = newArrayList(
				new EnumerableOrderItem(COCA_COLA, 2),
				new MeasurableOrderItem(PEPSI_COLA, 0.4),
				new EnumerableOrderItem(COCA_COLA, 2),
				new MeasurableOrderItem(KIWIS, 0.8)
		);

		final CheckoutService checkoutService = new CheckoutServiceImpl(enumerableOrderItems, null);
		final Receipt receipt = checkoutService.checkout();
		assertPrice(receipt, "£14.60", "£14.60");
	}

	@Test
	public void testCheckoutSingleEnumerableOrderWithNForMDiscount() {
		final List<OrderItem> enumerableOrderItems = newArrayList(
				new EnumerableOrderItem(COCA_COLA, 7)
		);

		final CheckoutService checkoutService = new CheckoutServiceImpl(enumerableOrderItems, newArrayList(THREE_COKE_FOR_TWO));
		final Receipt receipt = checkoutService.checkout();
		assertPrice(receipt, "£21.00", "£15.00");
	}

	@Test
	public void testCheckoutSingleEnumerableOrderWithNForXPriceDiscount() {
		final List<OrderItem> enumerableOrderItems = newArrayList(
				new EnumerableOrderItem(DORITOS, 6)
		);

		final CheckoutService checkoutService = new CheckoutServiceImpl(enumerableOrderItems, newArrayList(FIVE_DORITOS_FOR_THREE_POUNDS));
		final Receipt receipt = checkoutService.checkout();
		assertPrice(receipt, "£6.00", "£4.00");
	}

	@Test
	public void testCheckoutMultipleOrdersWithMultipleDiscount() {
		final List<OrderItem> enumerableOrderItems = newArrayList(
				new EnumerableOrderItem(COCA_COLA, 7),
				new MeasurableOrderItem(PEPSI_COLA, 0.4),
				new EnumerableOrderItem(COCA_COLA, 2),
				new EnumerableOrderItem(DORITOS, 6),
				new MeasurableOrderItem(KIWIS, 0.8)
		);

		final CheckoutService checkoutService = new CheckoutServiceImpl(enumerableOrderItems,
				newArrayList(THREE_COKE_FOR_TWO, FIVE_DORITOS_FOR_THREE_POUNDS));
		final Receipt receipt = checkoutService.checkout();
		assertPrice(receipt, "£35.60", "£24.60");
	}

	private void assertPrice(final Receipt receipt, final String subTotal, final String total) {
		assertThat(receipt, notNullValue());
		assertThat(receipt.getSubTotal().toString(), is(subTotal));
		assertThat(receipt.getTotal().toString(), is(total));
	}
}
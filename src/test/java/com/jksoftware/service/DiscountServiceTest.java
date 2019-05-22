package com.jksoftware.service;


import static com.google.common.collect.Lists.newArrayList;
import static com.jksoftware.helper.TestDataProvider.DISCOUNTS.FIVE_DORITOS_FOR_THREE_POUNDS;
import static com.jksoftware.helper.TestDataProvider.DISCOUNTS.THREE_COKE_FOR_TWO;
import static com.jksoftware.helper.TestDataProvider.ITEMS.*;
import com.jksoftware.model.Price;
import com.jksoftware.model.item.EnumerableOrderItem;
import com.jksoftware.model.item.OrderItem;
import com.jksoftware.service.impl.DiscountServiceImpl;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class DiscountServiceTest {

	private DiscountService discountService = new DiscountServiceImpl();
	private List<OrderItem> orderItems = newArrayList(
			new EnumerableOrderItem(COCA_COLA, 2),
			new EnumerableOrderItem(PEPSI_COLA, 5),
			new EnumerableOrderItem(COCA_COLA, 5),
			new EnumerableOrderItem(DORITOS, 12)
	);

	@Test
	public void testNPiecesForMPiecesDiscount() {
		final Price totalDiscount = discountService.calculateDiscount(orderItems, THREE_COKE_FOR_TWO);
		assertThat(totalDiscount.toString(), is("£6.00"));
	}

	@Test
	public void testNPiecesForXPriceDiscount() {
		final Price totalDiscount = discountService.calculateDiscount(orderItems, FIVE_DORITOS_FOR_THREE_POUNDS);
		assertThat(totalDiscount.toString(), is("£4.00"));
	}

	@Test
	public void testNPiecesForMPiecesDiscountForEmptyBasket() {
		orderItems = newArrayList();
		final Price totalDiscount = discountService.calculateDiscount(orderItems, THREE_COKE_FOR_TWO);
		assertThat(totalDiscount.toString(), is("£0.00"));
	}

	@Test
	public void testNPiecesForXPriceDiscountForEmptyBasket() {
		orderItems = newArrayList();
		final Price totalDiscount = discountService.calculateDiscount(orderItems, FIVE_DORITOS_FOR_THREE_POUNDS);
		assertThat(totalDiscount.toString(), is("£0.00"));
	}

}
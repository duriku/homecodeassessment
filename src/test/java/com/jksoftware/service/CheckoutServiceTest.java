package com.jksoftware.service;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import com.jksoftware.model.Price;
import com.jksoftware.model.Receipt;
import com.jksoftware.model.item.EnumerableOrderItem;
import com.jksoftware.model.item.Item;
import com.jksoftware.model.item.MeasurableOrderItem;
import com.jksoftware.model.item.OrderItem;
import com.jksoftware.service.impl.CheckoutService;
import org.junit.Test;

public class CheckoutServiceTest {

    private static final Item COCA_COLA = new Item("Coca Cola 2L", new Price("3"));
    private static final Item PEPSI_COLA = new Item("Pepsi 2L", new Price("2.5"));
    private static final Item BANANAS = new Item("Bananas", new Price("1.50"));
    private static final Item KIWIS = new Item("Bananas", new Price("2.00"));

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
    public void testCheckoutSingleEnumerableOrderWithDiscount() {
        final List<OrderItem> enumerableOrderItems = newArrayList(
                new EnumerableOrderItem(COCA_COLA, 7)
        );
        final CheckoutService checkoutService = new CheckoutServiceImpl(enumerableOrderItems, null);

        final Receipt receipt = checkoutService.checkout();
        assertPrice(receipt, "£14.60", "£14.60");
    }

    private void assertPrice(final Receipt receipt, final String subTotal, final String total) {
        assertThat(receipt, notNullValue());
        assertThat(receipt.getSubTotal().toString(), is(subTotal));
        assertThat(receipt.getTotal().toString(), is(total));
    }
}
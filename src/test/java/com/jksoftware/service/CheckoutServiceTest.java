package com.jksoftware.service;

import com.jksoftware.service.impl.CheckoutService;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class CheckoutServiceTest {

	CheckoutService checkoutService = new CheckoutServiceImpl();

	@Test
	public void testCheckout() {
		assertThat(checkoutService.checkout(), is(0));
	}

}
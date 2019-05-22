package com.jksoftware;

import com.jksoftware.service.CheckoutServiceImpl;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		final CheckoutServiceImpl checkoutService = new CheckoutServiceImpl(null, null);
		checkoutService.checkout();
	}
}

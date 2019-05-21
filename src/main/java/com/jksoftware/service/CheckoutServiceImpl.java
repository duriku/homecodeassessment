package com.jksoftware.service;

import com.jksoftware.service.impl.CheckoutService;

public class CheckoutServiceImpl implements CheckoutService {

	public int checkout() {
		System.out.println("Checkout called");
		return 0;
	}
}

package com.jksoftware.model;

import java.math.BigDecimal;
import static java.text.MessageFormat.format;

public class Price {

	private BigDecimal value;

	public Price add(final Price to){
		this.value = this.value.add(to.value);
		return this;
	}

	public Price muiltiple(final int times){
		this.value = this.value.multiply(new BigDecimal(times));
		return this;
	}

	public BigDecimal getValue() {
		return value;
	}

	@Override
	public String toString() {
		return format("£ %s", value.toString());
	}
}

package com.jksoftware.model;

import static java.lang.String.format;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Price {

    public static final Price ZERO = new Price("0");

    private BigDecimal value;

    public Price(final BigDecimal value) {
        this.value = value;
    }

    public Price(final String value) {
        this.value = new BigDecimal(value);
    }

    public Price add(final Price to) {
        return new Price(this.value.add(to.value));
    }

    public Price subtract(final Price to) {
        return new Price(this.value.subtract(to.value));
    }

    public Price multiple(final int times) {
        return new Price(this.value.multiply(new BigDecimal(times)));
    }

    public Price multiple(final Double times) {
        return new Price(this.value.multiply(new BigDecimal(times)));
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return format("£%s", value.setScale(2, RoundingMode.HALF_UP).toString());
    }
}

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

    public static Price add(final Price p1, final Price p2) {
        return new Price(p1.getValue().add(p2.getValue()));
    }

    public Price add(final Price to) {
        this.value = this.value.add(to.value);
        return this;
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

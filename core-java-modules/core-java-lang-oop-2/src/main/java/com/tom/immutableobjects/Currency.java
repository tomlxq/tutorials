package com.tom.immutableobjects;



/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/6
 */
// 4. Immutability in Java
public final class Currency {

    private final String value;

    private Currency(String currencyValue) {
        value = currencyValue;
    }

    public String getValue() {
        return value;
    }

    public static Currency of(String value) {
        return new Currency(value);
    }
}

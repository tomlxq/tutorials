package com.tom.immutableobjects;



/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/6
 */
// 4. Immutability in Java
public final class Money {
    private final double amount;
    private final Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }
}

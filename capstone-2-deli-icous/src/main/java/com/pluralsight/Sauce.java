package com.pluralsight;

public class Sauce implements Topping{
    SaucesType sauceType;

    public Sauce(SaucesType sauceType) {
        this.sauceType = sauceType;
    }

    public SaucesType getSauceType() {
        return sauceType;
    }
}

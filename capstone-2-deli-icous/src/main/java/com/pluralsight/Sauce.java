package com.pluralsight;

public class Sauce extends Topping{
    SaucesType sauceType;

    public Sauce(SaucesType sauceType) {
        this.sauceType = sauceType;
    }

    public SaucesType getSauceType() {
        return sauceType;
    }
}

package com.pluralsight;

public class RegularTopping extends Topping {
    ToppingType toppingType;

    public RegularTopping(ToppingType toppingType) {
        this.toppingType = toppingType;
    }

    public ToppingType getToppingType() {
        return toppingType;
    }
}

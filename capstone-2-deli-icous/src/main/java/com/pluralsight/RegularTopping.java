package com.pluralsight;

public class RegularTopping implements Topping {
    ToppingType toppingType;



    public RegularTopping(ToppingType toppingType) {
        this.toppingType = toppingType;
    }

    public ToppingType getToppingType() {
        return toppingType;
    }
}

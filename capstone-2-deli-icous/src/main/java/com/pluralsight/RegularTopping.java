package com.pluralsight;

import enums.ToppingType;
import interfaces.Topping;

public class RegularTopping implements Topping {
    ToppingType toppingType;



    public RegularTopping(ToppingType toppingType) {
        this.toppingType = toppingType;
    }

    public ToppingType getToppingType() {
        return toppingType;
    }
}

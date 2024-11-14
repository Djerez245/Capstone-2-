package com.pluralsight;

import com.pluralsight.enums.SaucesType;
import com.pluralsight.interfaces.Topping;

public class Sauce implements Topping {
    SaucesType sauceType;

    public Sauce(SaucesType sauceType) {
        this.sauceType = sauceType;
    }

    public SaucesType getSauceType() {
        return sauceType;
    }
}

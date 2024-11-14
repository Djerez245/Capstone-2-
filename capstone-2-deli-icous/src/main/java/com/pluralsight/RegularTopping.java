package com.pluralsight;

import com.pluralsight.enums.ToppingType;
import com.pluralsight.interfaces.Topping;

public class RegularTopping implements Topping {
    ToppingType toppingType;



    public RegularTopping(ToppingType toppingType) {
        this.toppingType = toppingType;
    }

    public ToppingType getToppingType() {
        return toppingType;
    }
}

package com.pluralsight;

import enums.BreadSize;
import interfaces.Priceable;
import interfaces.Topping;

public abstract class PremiumToppings implements Priceable, Topping {
    protected BreadSize breadSize;
    protected boolean extraTopping;
    protected double toppingPrice;

    public PremiumToppings(BreadSize breadSize, boolean extraTopping) {
        this.breadSize = breadSize;
        this.extraTopping = extraTopping;
    }

    public BreadSize getBreadSize() {
        return breadSize;
    }

    public boolean isExtraTopping() {
        return extraTopping;
    }

}

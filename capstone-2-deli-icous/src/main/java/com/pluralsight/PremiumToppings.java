package com.pluralsight;

public abstract class PremiumToppings implements Priceable, Topping {
    BreadSize breadSize;
    boolean extraTopping;
    double toppingPrice;

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

package com.pluralsight;

import com.pluralsight.enums.BreadSize;
import com.pluralsight.interfaces.Priceable;
import com.pluralsight.interfaces.Topping;

public abstract class PremiumToppings implements Priceable, Topping {
    protected BreadSize breadSize;
    protected boolean extraTopping;
    protected double toppingPrice;

    public PremiumToppings(BreadSize breadSize, boolean extraTopping) {
        this.breadSize = breadSize;
        this.extraTopping = extraTopping;
    }

}

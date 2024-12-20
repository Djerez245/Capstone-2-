package com.pluralsight;

import com.pluralsight.enums.BreadSize;
import com.pluralsight.enums.CheeseType;
import com.pluralsight.interfaces.Priceable;
import com.pluralsight.interfaces.Topping;

public class Cheese extends PremiumToppings implements Priceable, Topping {
    protected CheeseType cheeseType;

    public Cheese(BreadSize breadSize, boolean extraTopping, CheeseType cheeseType) {
        super(breadSize, extraTopping);
        this.cheeseType = cheeseType;
    }

    public CheeseType getCheeseType() {
        return cheeseType;
    }

    public void setCheeseType(CheeseType cheeseType) {
        this.cheeseType = cheeseType;
    }

    @Override
    public double getPrice() {
        if (cheeseType == CheeseType.NOCHEESE){
            toppingPrice += 0;
        }
        if (BreadSize.SMALL == breadSize) {
            toppingPrice = .75;
            if (extraTopping) {
                toppingPrice += .3;
            }
        }
        if (BreadSize.MEDIUM == breadSize) {
            toppingPrice = 1.5;
            if (extraTopping) {
                toppingPrice += .6;
            }
        }
        if (BreadSize.LARGE == breadSize) {
            toppingPrice = 2.25;
            if (extraTopping) {
                toppingPrice += .9;
            }
        }
        return toppingPrice;
    }

    @Override
    public String toStringTopping() {
        return String.format("Cheese: %-10s$%.2f", cheeseType, getPrice());
    }
}

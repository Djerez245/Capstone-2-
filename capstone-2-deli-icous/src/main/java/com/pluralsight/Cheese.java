package com.pluralsight;

public class Cheese extends PremiumToppings implements Priceable{
    protected CheeseType cheeseType;

    public Cheese(BreadSize breadSize, boolean extraTopping, CheeseType cheeseType) {
        super(breadSize, extraTopping);
        this.cheeseType = cheeseType;
    }

    public CheeseType getCheeseType() {
        return cheeseType;
    }

    @Override
    public double getPrice() {
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
}

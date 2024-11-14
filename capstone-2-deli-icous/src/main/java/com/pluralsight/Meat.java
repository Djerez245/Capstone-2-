package com.pluralsight;

import enums.BreadSize;
import enums.MeatType;
import interfaces.Priceable;
import interfaces.Topping;

public class Meat extends PremiumToppings implements Priceable, Topping {
    protected MeatType meatType;

    public Meat(BreadSize breadSize, boolean extraTopping, MeatType meatType) {
        super(breadSize, extraTopping);
        this.meatType = meatType;
    }

    public MeatType getMeatType() {
        return meatType;
    }

    public void setMeatType(MeatType meatType) {
        this.meatType = meatType;
    }

    @Override
    public double getPrice() {
        if (meatType == MeatType.NOMEAT){
            toppingPrice += 0;
        }
        if (BreadSize.SMALL == breadSize){
            toppingPrice = 1.00;
            if (extraTopping){
                toppingPrice += .5;
            }
        }
        if (BreadSize.MEDIUM == breadSize) {
            toppingPrice = 2.00;
            if (extraTopping) {
                toppingPrice += 1.00;
            }
        }
        if (BreadSize.LARGE == breadSize) {
            toppingPrice = 3.00;
            if (extraTopping) {
                toppingPrice += 1.5;
            }
        }
        return toppingPrice;
    }
}

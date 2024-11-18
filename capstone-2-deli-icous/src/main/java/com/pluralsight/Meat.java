package com.pluralsight;

import com.pluralsight.enums.BreadSize;
import com.pluralsight.enums.MeatType;
import com.pluralsight.interfaces.Item;
import com.pluralsight.interfaces.Priceable;
import com.pluralsight.interfaces.Topping;

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

        if (meatType == MeatType.NOMEAT) {
            toppingPrice += 0;
        }
        if (BreadSize.SMALL == breadSize) {
            toppingPrice = 1.00;
            if (extraTopping) {
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

    private int countMeats() {
        Order order = new Order();
        int meatCount = 0;
        for (Item meat : order.items) {
            if (meat != null && meatType != MeatType.NOMEAT) {
                meatCount++;
            }
        }
        return meatCount;
    }

    @Override
    public String toStringTopping() {
        return String.format("Cheese: %-10s$%.2f", meatType.name(), getPrice());
    }
}


package com.pluralsight;

public class Meat extends PremiumToppings implements Priceable {
    protected MeatType meatType;

    public Meat(BreadSize breadSize, boolean extraTopping, MeatType meatType) {
        super(breadSize, extraTopping);
        this.meatType = meatType;
    }

    public MeatType getMeatType() {
        return meatType;
    }

    @Override
    public double getPrice() {
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

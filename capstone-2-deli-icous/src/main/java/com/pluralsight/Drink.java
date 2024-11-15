package com.pluralsight;

import com.pluralsight.enums.DrinkSize;
import com.pluralsight.enums.DrinkType;
import com.pluralsight.interfaces.Item;

public class Drink implements Item {
    protected DrinkSize drinkSize;
    protected double drinkPrice;
    protected DrinkType drinkType;

    public Drink(DrinkType drinkType, DrinkSize drinkSize) {
        this.drinkType = drinkType;
        this.drinkSize = drinkSize;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    @Override
    public double getPrice() {
        if (DrinkSize.SMALL == drinkSize){
            drinkPrice = 2.00;
        }
        else if (DrinkSize.MEDIUM == drinkSize){
            drinkPrice = 2.5;
        }
        else if (DrinkSize.LARGE == drinkSize){
            drinkPrice = 3.00;
        }
        else {
            drinkPrice = 0.0;
        }
        return drinkPrice;
    }

    @Override
    public String toStringForItems() {
        return String.format("%s, %s: $%.2f", drinkType, drinkSize, getPrice());
    }
}

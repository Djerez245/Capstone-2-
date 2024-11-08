package com.pluralsight;

public class Drink implements Priceable{
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
        }if (DrinkSize.MEDIUM == drinkSize){
            drinkPrice = 2.5;
        }
        if (DrinkSize.LARGE == drinkSize){
            drinkPrice = 3.00;
        }
        else {
            drinkPrice = 0.0;
        }
        return drinkPrice;
    }
}

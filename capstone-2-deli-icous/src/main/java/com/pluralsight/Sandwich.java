package com.pluralsight;

import com.pluralsight.enums.BreadSize;
import com.pluralsight.enums.BreadType;
import com.pluralsight.interfaces.Item;
import com.pluralsight.interfaces.Topping;

import java.util.ArrayList;

public class Sandwich implements Item {
    protected BreadType breadType;
    protected BreadSize sandwichSize;
    protected ArrayList<Topping> topping;
    protected boolean isToasted;
    protected double sandwichPrice;


    public Sandwich(BreadType breadType, BreadSize sandwichSize, boolean isToasted) {
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
        this.isToasted = isToasted;
        topping = new ArrayList<>();
    }

    public BreadSize getSandwichSize() {
        return sandwichSize;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public void setSandwichSize(BreadSize sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public ArrayList<Topping> getTopping() {
        return topping;
    }

    @Override
    public double getPrice() {
        if (BreadSize.SMALL == sandwichSize) {
            sandwichPrice = 5.5;
        }
        if (BreadSize.MEDIUM == sandwichSize) {
            sandwichPrice = 7.00;
        }
        if (BreadSize.LARGE == sandwichSize) {
            sandwichPrice = 8.5;
        }
        return sandwichPrice;
    }

    public void addTopping(Topping toppings) {
        topping.add(toppings);
    }


    @Override
    public String toStringForItems() {
        return String.format("Bread:%s\nSandwich size:%s\nToasted:%s:\nSandwich price: $%.2f", breadType, sandwichSize, isToasted, getPrice());
    }
}

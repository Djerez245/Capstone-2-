package com.pluralsight;

import enums.BreadSize;
import enums.BreadType;
import interfaces.Item;
import interfaces.Topping;

import java.util.ArrayList;

public class Sandwich implements Item {
    protected BreadType breadType;
    protected BreadSize sandwichSize;
    protected ArrayList<Topping> topping;
    protected boolean isToasted;
    protected double sandwichPrice;

    Order o;

    public Sandwich(BreadType breadType, BreadSize sandwichSize, boolean isToasted) {
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
        this.isToasted = isToasted;
        topping = new ArrayList<>();
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public BreadSize getSandwichSize() {
        return sandwichSize;
    }

    public ArrayList<Topping> getTopping() {
        return topping;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public double getSandwichPrice() {
        return sandwichPrice;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public void setSandwichSize(BreadSize sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public void setTopping(ArrayList<Topping> topping) {
        this.topping = topping;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public void setSandwichPrice(double sandwichPrice) {
        this.sandwichPrice = sandwichPrice;
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
    public String toStringForCsv() {
        return String.format("Bread:%s\nSandwich size:%s\nToasted:%s:\nSandwich price: $%.2f", breadType, sandwichSize, isToasted, getPrice());
    }
}

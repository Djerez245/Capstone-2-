package com.pluralsight;

public class Chips implements Priceable {
    private double price;
    public ChipsType chipsType;

    public Chips(ChipsType chipsType) {
        this.chipsType = chipsType;
    }

    public ChipsType getChipsType() {
        return chipsType;
    }

    @Override
    public double getPrice() {
        price = 1.50;
        return price;
    }
}

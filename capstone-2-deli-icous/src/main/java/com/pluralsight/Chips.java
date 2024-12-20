package com.pluralsight;

import com.pluralsight.enums.ChipsType;
import com.pluralsight.interfaces.Item;

public class Chips implements Item {
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


    @Override
    public String toStringForItems() {
        return String.format("%s: $%.2f", chipsType, getPrice());
    }
}

package com.pluralsight;

import enums.BreadSize;
import enums.BreadType;

public class Philly extends Sandwich {

    public Philly(BreadType breadType, BreadSize sandwichSize, boolean isToasted) {
        super(breadType, sandwichSize, isToasted);
    }

    @Override
    public void setBreadType(BreadType breadType) {
        super.setBreadType(BreadType.WHITE);
    }

    @Override
    public void setSandwichSize(BreadSize sandwichSize) {
        super.setSandwichSize(BreadSize.MEDIUM);
    }

    @Override
    public void setToasted(boolean toasted) {
        super.setToasted(true);
    }
}

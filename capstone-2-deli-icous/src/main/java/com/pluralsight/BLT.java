package com.pluralsight;

import com.pluralsight.enums.*;


public class BLT extends Sandwich{
    public BLT(BreadType breadType, BreadSize sandwichSize, boolean isToasted) {
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

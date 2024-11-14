package com.pluralsight;

import com.pluralsight.enums.DrinkSize;
import com.pluralsight.enums.DrinkType;

public class CreateADrink {
    DrinkSize selectedDrinkSize;
    DrinkType selectedDrinkType;

    public CreateADrink() {
    }

    public DrinkSize getSelectedDrinkSize() {
        return selectedDrinkSize;
    }

    public DrinkType getSelectedDrinkType() {
        return selectedDrinkType;
    }


    public void chooseDrink(int drinkSizeInput, int drinkTypeInput){

        if (drinkSizeInput >= 0 && drinkSizeInput < DrinkSize.values().length) {
            selectedDrinkSize = DrinkSize.values()[drinkSizeInput];

            if (drinkTypeInput >= 0 && drinkTypeInput < DrinkType.values().length) {
                selectedDrinkType = DrinkType.values()[drinkTypeInput];

                System.out.println("\n" + DrinkType.values()[drinkTypeInput] + " SELECTED\n");
                System.out.println();
            } else {
                System.out.println("Invalid drink type selection. Please try again.");
            }
        } else {
            System.out.println("Invalid drink size selection. Please try again.");
        }
    }

}

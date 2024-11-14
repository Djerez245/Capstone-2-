package com.pluralsight;

import enums.DrinkSize;
import enums.DrinkType;

public class CreateADrink {
    public CreateADrink() {

    }

    UserInterfaceMethodsV2 user = new UserInterfaceMethodsV2();

    public void chooseDrink(int drinkSizeInput, int drinkTypeInput){
        if (drinkSizeInput >= 0 && drinkSizeInput < DrinkSize.values().length) {
            DrinkSize selectedDrinkSize = DrinkSize.values()[drinkSizeInput];

            if (drinkTypeInput >= 0 && drinkTypeInput < DrinkType.values().length) {
                DrinkType selectedDrinkType = DrinkType.values()[drinkTypeInput];
                Drink d = new Drink(selectedDrinkType, selectedDrinkSize);
                user.order.addItem(d);
                System.out.println("\n" + DrinkType.values()[drinkTypeInput] + " SELECTED\n");
            } else {
                System.out.println("Invalid drink type selection. Please try again.");
            }
        } else {
            System.out.println("Invalid drink size selection. Please try again.");
        }
    }

}

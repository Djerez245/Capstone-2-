package com.pluralsight;

import enums.*;

public class MakingASandwich extends UserInterfaceMethodsV2 {
    private BreadType userBreadType;
    private BreadSize userBreadSize;

    public MakingASandwich() {
    }

    public BreadType getUserBreadType() {
        return userBreadType;
    }

    public BreadSize getUserBreadSize() {
        return userBreadSize;
    }

    public void addRegularToppingToSandwich(Sandwich s) {
        boolean addingToppings = true;
        while (addingToppings) {
            try {
                // Display available toppings and get user input
                int toppingInput = getIntInput(whatToppings());

                // Check if the input is valid
                if (toppingInput >= 0 && toppingInput < ToppingType.values().length) {
                    ToppingType selectedTopping = ToppingType.values()[toppingInput];

                    s.addTopping(new RegularTopping(selectedTopping));

                    System.out.println("\n" + ToppingType.values()[toppingInput] + " added to the sandwich!\n");

                } else if (toppingInput == 9) {
                    addingToppings = false;
                    System.out.println("\nNo more toppings will be added.");
                } else {
                    System.out.println("Invalid topping selection. Please try again.");
                    addingToppings = false;
                }

            } catch (Exception e) {
                System.out.println("An error occurred while adding a topping: " + e.getMessage());
            }

            String moreToppingInput = getStringInput(moreToppings());

            if (moreToppingInput.equalsIgnoreCase("no")) {
                addingToppings = false;

                System.out.println("\nNo more toppings will be added.\n");

            } else if (moreToppingInput.equalsIgnoreCase("yes")) {
                System.out.println("\nAdding another topping...\n");

            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public void addSauce(Sandwich s) {
        boolean addingSauce = true;
        while (addingSauce) {
            int sauceType = getIntInput(displaySauces());
            if (sauceType == 0) {
                addingSauce = false;
            }
            if (sauceType >= 0 && sauceType < SaucesType.values().length) {
                SaucesType selectedSauce = SaucesType.values()[sauceType];
                Sauce sauce = new Sauce(selectedSauce);
                s.addTopping(sauce);
                System.out.println("\n" + SaucesType.values()[sauceType] + " SELECTED\n");
            } else {
                System.out.println("Invalid sauce selection. No sauce will be added.");
            }

            String moreSauceInput = getStringInput(moreSauce());

            if (moreSauceInput.equalsIgnoreCase("no")) {
                addingSauce = false;

                System.out.println("\nNo more sauce will be added.\n");

            } else if (moreSauceInput.equalsIgnoreCase("yes")) {
                System.out.println("\nAdding another Sauce...\n");
                addingSauce = true;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public void chooseBreadType(int breadTypeInput) {
        if (breadTypeInput >= 0 && breadTypeInput < BreadType.values().length) {
            userBreadType = BreadType.values()[breadTypeInput];  // Set instance variable
            System.out.println("\n" + userBreadType + " SELECTED!\n");
        } else {
            System.out.println("Invalid bread type selection. Defaulting to WHITE.");
            userBreadType = BreadType.WHITE;  // Default value
        }
    }

    // Method to choose bread size
    public void chooseBreadSize(int breadSizeInput) {
        if (breadSizeInput >= 0 && breadSizeInput < BreadSize.values().length) {
            userBreadSize = BreadSize.values()[breadSizeInput];  // Set instance variable
            System.out.println("\n" + userBreadSize + " SELECTED!\n");
        } else {
            System.out.println("Invalid bread size selection. Defaulting to MEDIUM.");
            userBreadSize = BreadSize.MEDIUM;  // Default value
        }
    }

    public void chooseMeatType(int meatTypeInput, Sandwich s, boolean userExtraMeat){
        int meatInput = getIntInput(displayMeats());
        // getting user input to add meat and cheese
        String extraMeat = getStringInput(askForExtraMeat());

        // Adding meat with extra option
        if (meatInput == 6) {
            System.out.println("NO MEAT SELECTED");
        } else if (meatInput >= 0 && meatInput < 5 && meatInput < MeatType.values().length) {
            MeatType userMeatType = MeatType.values()[meatInput];
            System.out.println("\n" + MeatType.values()[meatInput] + " SELECTED\n");
            userExtraMeat = extraMeat.equalsIgnoreCase("yes");
            s.addTopping(new Meat(s.getSandwichSize(), userExtraMeat, userMeatType));
        } else {
            System.out.println("\nInvalid meat selection. Defaulting to CHICKEN.\n");
            MeatType userMeatType = MeatType.CHICKEN;
        }
    }

    public void chooseCheeseType(int cheeseType, Sandwich s, boolean userExtraCheese) {

    }

}

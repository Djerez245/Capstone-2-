package com.pluralsight;

import com.pluralsight.enums.*;

import static com.pluralsight.DisplayScreens.*;

public class MakingASandwich {
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

    UserInterfaceMethods user = new UserInterfaceMethods();


    public void addRegularToppingToSandwich(Sandwich s) {
        boolean addingToppings = true;
        while (addingToppings) {
            try {
                // Display available toppings and get user input
                int toppingInput = user.getIntInput(whatToppings());

                // Check if the input is valid
                if (toppingInput >= 0 && toppingInput < ToppingType.values().length) {
                    ToppingType selectedTopping = ToppingType.values()[toppingInput];
                    s.addTopping(new RegularTopping(selectedTopping));

                    System.out.println("\n" + selectedTopping + " added to the sandwich!\n");

                    // if the user enters 9 no more toppings will be added
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

            String moreToppingInput = user.getStringInput(moreToppings());

            if (moreToppingInput.equalsIgnoreCase("no")) {
                addingToppings = false;

                System.out.println("\nNo more toppings will be added.\n");

                // if the user enters yes the loop starts over
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
            int sauceType = user.getIntInput(displaySauces());
            if (sauceType == 6) {
                addingSauce = false;

                // checks the users input and adds the sauce to the toppings
            } else if (sauceType >= 0 && sauceType < SaucesType.values().length) {
                SaucesType selectedSauce = SaucesType.values()[sauceType];
                Sauce sauce = new Sauce(selectedSauce);
                s.addTopping(sauce);
                System.out.println("\n" + selectedSauce + " SELECTED\n");
                String moreSauceInput = user.getStringInput(moreSauce());

                if (moreSauceInput.equalsIgnoreCase("no")) {
                    addingSauce = false;

                    System.out.println("\nNo more sauce will be added.\n");

                } else if (moreSauceInput.equalsIgnoreCase("yes")) {
                    System.out.println("\nAdding another Sauce...\n");
                } else {
                    System.out.println("Invalid input");
                }
            } else {
                System.out.println("Invalid sauce selection. No sauce will be added.");
            }


        }
    }

    public void chooseBreadType(int breadTypeInput) {

        // checks user inputs and assigns the variable
        if (breadTypeInput >= 0 && breadTypeInput < BreadType.values().length) {
            userBreadType = BreadType.values()[breadTypeInput];
            System.out.println("\n" + userBreadType + " SELECTED!\n");
        } else {
            // if the users is invalid I default the bread type to white bread
            System.out.println("Invalid bread type selection. Defaulting to WHITE.");
            userBreadType = BreadType.WHITE;  // Default value
        }
    }

    // Method to choose bread size
    public void chooseBreadSize(int breadSizeInput) {
        // checks user inputs and assigns the variable
        if (breadSizeInput >= 0 && breadSizeInput < BreadSize.values().length) {
            userBreadSize = BreadSize.values()[breadSizeInput];
            System.out.println("\n" + userBreadSize + " SELECTED!\n");
        } else {
            // if the users is invalid I default the bread size to medium
            System.out.println("Invalid bread size selection. Defaulting to MEDIUM.");
            userBreadSize = BreadSize.MEDIUM;  // Default value
        }
    }

    public void chooseMeatType(int meatTypeInput, Sandwich s) {
        // Adding meat with extra option
        if (meatTypeInput == 6) {
            System.out.println("NO MEAT SELECTED");
        } else if (meatTypeInput < MeatType.values().length) {
            MeatType userMeatType = MeatType.values()[meatTypeInput];
            System.out.println("\n" + userMeatType + " SELECTED\n");

            String extraMeatString = user.getStringInput(askForExtraMeat());

            boolean extraMeat = extraMeatString.equalsIgnoreCase("yes");
            s.addTopping(new Meat(s.getSandwichSize(), extraMeat, userMeatType));
        } else {
            System.out.println("\nInvalid meat selection. Defaulting to CHICKEN.\n");
            MeatType userMeatType = MeatType.CHICKEN;
        }
    }

    public void chooseCheeseType(int cheeseInput, Sandwich s) {
        // Adding cheese with extra option
        CheeseType userCheeseType;
        if (cheeseInput == 4) {
            System.out.println("\nNO CHEESE SELECTED\n");
        } else if (cheeseInput >= 0 && cheeseInput < CheeseType.values().length) {
            userCheeseType = CheeseType.values()[cheeseInput];
            System.out.println("\n" + userCheeseType + " SELECTED\n");
            String extraCheeseString = user.getStringInput(askForExtraCheese());
            boolean extraCheese = extraCheeseString.equalsIgnoreCase("yes");
            Cheese c = new Cheese(s.getSandwichSize(), extraCheese, userCheeseType);
            s.addTopping(c);
        } else {
            System.out.println("Invalid cheese selection. Defaulting to CHEDDAR.");
            userCheeseType = CheeseType.CHEDDAR;
        }
    }
}





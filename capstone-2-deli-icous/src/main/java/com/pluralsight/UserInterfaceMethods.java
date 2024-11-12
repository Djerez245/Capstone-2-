package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterfaceMethods extends DisplayScreens {

    Scanner scanner = new Scanner(System.in);
    Sandwich sandwich;
    PremiumToppings premiumToppings;
    RegularTopping regularTopping;
    Meat meat;
    Cheese cheese;
    Order order = new Order();
    Chips chips;

    public int getIntInput(String displayScreen) {
        System.out.println(displayScreen);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public void addToppingToSandwich() {
        boolean addingToppings = true;
        while (addingToppings) {

            // Display available toppings and get user input
            int toppingInput = getIntInput(whatToppings());

            // Check if the input is valid
            if (toppingInput >= 0 && toppingInput < ToppingType.values().length) {
                ToppingType selectedTopping = ToppingType.values()[toppingInput];

                // Create a new RegularTopping with the selected topping type
                RegularTopping t = new RegularTopping(selectedTopping);
                sandwich.addTopping(t);
            } else if (toppingInput == 9) {  // Exit code
                addingToppings = false;
            } else {
                System.out.println("Invalid topping selection. Please try again.");
            }
        }
    }


    // adding sandwich and toppings
    public void addSandwich() {
        try {
            // getting user input to create a sandwich
            int breadTypeInput = getIntInput(displaySelectBreadType());
            int breadSizeInput = getIntInput(displaySelectBreadSize());
            int meatInput = getIntInput(displayMeats());

            // getting user input to add meat and cheese
            askForExtraMeat();
            String extraMeat = scanner.nextLine();

            int cheeseInput = getIntInput(displayCheese());

            askForExtraCheese();
            String extraCheese = scanner.nextLine();

            addToppingToSandwich();

            int sauceType = getIntInput(displaySauces());

            toastedOrNo();
            String toasted = scanner.nextLine();

            // Setting sandwich bread type and size with exception handling
            if (breadTypeInput >= 0 && breadTypeInput < BreadType.values().length) {
                sandwich.breadType = BreadType.values()[breadTypeInput];
                System.out.println(BreadType.values()[breadTypeInput] + " SELECTED!");
            } else {
                System.out.println("Invalid bread type selection. Defaulting to WHITE.");
                sandwich.breadType = BreadType.WHITE;
            }

            if (breadSizeInput >= 0 && breadSizeInput < BreadSize.values().length) {
                sandwich.sandwichSize = BreadSize.values()[breadSizeInput];
                System.out.println(BreadSize.values()[breadSizeInput] + " SANDWICH SIZE SELECTED!");
            } else {
                System.out.println("Invalid bread size selection. Defaulting to MEDIUM.");
                sandwich.sandwichSize = BreadSize.MEDIUM;
            }

            sandwich.isToasted = toasted.equalsIgnoreCase("yes");

            // Create and add sandwich to order
            Sandwich s = new Sandwich(sandwich.getBreadType(), sandwich.getSandwichSize(), sandwich.isToasted);
            order.addSandwich(s);

            // Adding meat with extra option
            if (meatInput >= 0 && meatInput < MeatType.values().length) {
                meat.meatType = MeatType.values()[meatInput];
                System.out.println(MeatType.values()[meatInput] + " SELECTED");
            } else {
                System.out.println("Invalid meat selection. Defaulting to CHICKEN.");
                meat.meatType = MeatType.CHICKEN;
            }

            premiumToppings.extraTopping = extraMeat.equalsIgnoreCase("yes");
            Meat m = new Meat(premiumToppings.getBreadSize(), premiumToppings.isExtraTopping(), meat.getMeatType());
            sandwich.addTopping(m);

            // Adding cheese with extra option
            if (cheeseInput >= 0 && cheeseInput < CheeseType.values().length) {
                cheese.cheeseType = CheeseType.values()[cheeseInput];
                System.out.println(CheeseType.values()[cheeseInput] + " SELECTED");
            } else {
                System.out.println("Invalid cheese selection. Defaulting to CHEDDAR.");
                cheese.cheeseType = CheeseType.CHEDDAR;
            }

            premiumToppings.extraTopping = extraCheese.equalsIgnoreCase("yes");
            Cheese c = new Cheese(premiumToppings.getBreadSize(), premiumToppings.isExtraTopping(), cheese.getCheeseType());
            sandwich.addTopping(c);

            // Adding sauce to sandwich
            boolean addingSauce = true;
            while (addingSauce) {
                if (sauceType >= 0 && sauceType < SaucesType.values().length) {
                    SaucesType selectedSauce = SaucesType.values()[sauceType];
                    Sauce sauce = new Sauce(selectedSauce);
                    sandwich.addTopping(sauce);
                    System.out.println(SaucesType.values()[sauceType] + " SELECTED");
                }
                if (sauceType == 0) {
                    addingSauce = false;
                } else {
                    System.out.println("Invalid sauce selection. No sauce will be added.");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please enter a number where expected.");
            scanner.nextLine(); // Clear invalid input
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid selection. Please select a valid option.");
        } catch (NullPointerException e) {
            System.out.println("Error: Missing sandwich or order details.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: ");
        }
    }


    public void addDrink() {
        boolean addingDrinks = true;
        while (addingDrinks) {
            try {
                int drinkSizeInput = getIntInput(whatDrinkSize());
                int drinkTypeInput = getIntInput(drinkType());

                // Check if drinkSizeInput and drinkTypeInput are valid indices
                if (drinkSizeInput >= 0 && drinkSizeInput < DrinkSize.values().length) {
                    DrinkSize selectedDrinkSize = DrinkSize.values()[drinkSizeInput];

                    if (drinkTypeInput >= 0 && drinkTypeInput < DrinkType.values().length) {
                        DrinkType selectedDrinkType = DrinkType.values()[drinkTypeInput];
                        Drink d = new Drink(selectedDrinkType, selectedDrinkSize);
                        order.addDrink(d);
                        System.out.println("DRINK ADDED");
                    } else {
                        System.out.println("Invalid drink type selection. Please try again.");
                    }
                } else {
                    System.out.println("Invalid drink size selection. Please try again.");
                }
                if (drinkSizeInput == 0) {
                    addingDrinks = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Selection invalid. Please select a valid option.");
            } catch (NullPointerException e) {
                System.out.println("Sorry we do not have that drink.");
            } catch (Exception e) {
                System.out.println("An error occurred while adding your drink.");
                throw new RuntimeException(e); // Optionally re-throw if needed
            }
        }
    }


    public void addChips() {
        boolean addingChips = true;
        while (addingChips) {
            try {
                int chipsInput = getIntInput(typeOfChips());

                if (chipsInput >= 0 && chipsInput < ChipsType.values().length) {
                    ChipsType selectedChipsType = ChipsType.values()[chipsInput];
                    Chips ch = new Chips(selectedChipsType);
                    order.addChip(ch);
                } else {
                    System.out.println("Invalid chip type. Please try again.");
                    continue;
                }
                moreChips();
                String moreChips = scanner.nextLine();

                if (moreChips.equalsIgnoreCase("no")) {
                    addingChips = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}


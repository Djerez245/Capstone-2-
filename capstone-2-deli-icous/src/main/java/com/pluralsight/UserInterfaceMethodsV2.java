package com.pluralsight;

import enums.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterfaceMethodsV2 extends DisplayScreensV2 {

    Scanner scanner = new Scanner(System.in);

    Order order = new Order();
    PrintReceipt receipt = new PrintReceipt();


    public int getIntInput(String displayScreen) {
        System.out.println(displayScreen);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public String getStringInput(String displayScreen){
        System.out.println(displayScreen);
        String input = scanner.nextLine();
        // scanner.nextLine();
        return input;
    }

    // adding sandwich and toppings
    public void addSandwich() {
        MakingASandwich makeSandwich = new MakingASandwich();
        int selectSandwich = getIntInput(chooseSandwich());
        if (selectSandwich == 1) {
            addBlt();
        }
        if (selectSandwich == 2) {
            System.out.println("not done yet");
        }
        if (selectSandwich == 3) {

            boolean addingSandwich = true;
            while (addingSandwich) {
                try {
                    // getting user input to create a sandwich
                    int breadTypeInput = getIntInput(displaySelectBreadType());
                    int breadSizeInput = getIntInput(displaySelectBreadSize());

                    String toastedString = getStringInput(toastedOrNo());
                    boolean toasted = toastedString.equalsIgnoreCase("yes");


                    makeSandwich.chooseBreadType(breadTypeInput);
                    makeSandwich.chooseBreadSize(breadSizeInput);

                    BreadType userBreadType = makeSandwich.getUserBreadType();
                    BreadSize userBreadSize = makeSandwich.getUserBreadSize();

                    // Create and add sandwich to order
                    Sandwich s = new Sandwich(userBreadType, userBreadSize, toasted);

                    makeSandwich.addRegularToppingToSandwich(s);

                    int meatInput = getIntInput(displayMeats());

                    // getting user input to add meat and cheese


                    // Adding meat with extra option
                    makeSandwich.chooseMeatType(meatInput, s);

                    int cheeseInput = getIntInput(displayCheese());

                    String extraCheeseString = getStringInput(askForExtraCheese());
                    boolean extraCheese = extraCheeseString.equalsIgnoreCase("yes");

                    // Adding cheese with extra option
                   makeSandwich.chooseCheeseType(cheeseInput,s, extraCheese);
                    // Adding sauce to sandwich
                    makeSandwich.addSauce(s);
                    order.addItem(s);
                    System.out.println("\nSANDWICH ADDED\n");

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
                String anotherSandwichInput = getStringInput(anotherSandwich());

                if (anotherSandwichInput.equalsIgnoreCase("no")) {
                    addingSandwich = false;

                    System.out.println("\nNo more sandwiches will be added.\n");

                } else if (anotherSandwichInput.equalsIgnoreCase("yes")) {
                    System.out.println("\nAdding another sandwich...\n");

                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }

    public void addDrink() {
        boolean addingDrinks = true;
        while (addingDrinks) {
            try {
                int drinkSizeInput = getIntInput(whatDrinkSize());
                if (drinkSizeInput == 3) {
                    addingDrinks = false;
                    continue;
                }
                int drinkTypeInput = getIntInput(drinkType());

                // Check if drinkSizeInput and drinkTypeInput are valid
                if (drinkSizeInput >= 0 && drinkSizeInput < DrinkSize.values().length) {
                    DrinkSize selectedDrinkSize = DrinkSize.values()[drinkSizeInput];

                    if (drinkTypeInput >= 0 && drinkTypeInput < DrinkType.values().length) {
                        DrinkType selectedDrinkType = DrinkType.values()[drinkTypeInput];
                        Drink d = new Drink(selectedDrinkType, selectedDrinkSize);
                        order.addItem(d);
                        System.out.println("\n" + DrinkType.values()[drinkTypeInput] + " SELECTED\n");
                    } else {
                        System.out.println("Invalid drink type selection. Please try again.");
                    }
                } else {
                    System.out.println("Invalid drink size selection. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (NullPointerException e) {
                System.out.println("Sorry, we do not have that drink.");
            } catch (Exception e) {
                System.out.println("An error occurred while adding your drink.");
            }

            // After adding a drink, ask if they want to add more

            String moreDrinkInput = getStringInput(moreDrink());

            if (moreDrinkInput.equalsIgnoreCase("no")) {
                addingDrinks = false;

                System.out.println("\nNo more drinks will be added.\n");

            } else if (moreDrinkInput.equalsIgnoreCase("yes")) {
                System.out.println("\nAdding another drink...\n");

            } else {
                System.out.println("Invalid input");
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
                    order.addItem(ch);
                    System.out.println("\n" + ChipsType.values()[chipsInput] + " SELECTED");
                } else {
                    System.out.println("Invalid chip type. Please try again.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }

            String moreChipsInput = getStringInput(moreChips());
            if (moreChipsInput.equalsIgnoreCase("no")) {
                addingChips = false;
                System.out.println("\nNo more chips will be added.\n");

            } else if (moreChipsInput.equalsIgnoreCase("yes")) {
                // Continue the loop to add more chips
                System.out.println("\nAdding more chips...\n");

            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public void checkout(Order o) {

        int checkoutInput = getIntInput(displayCheckout());
        if (checkoutInput == 0) {
            try {
                receipt.printReceiptToFile(o);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NullPointerException nullPointerException) {
                System.out.println("Sorry your order is empty");
            }
        }
        try {
            if (checkoutInput == 1) {
                order.removeOrder(o);
            }
        } catch (NullPointerException nullPointerException) {
            System.out.println("Sorry your order is empty");
        }

    }

    public void addBlt() {
        MakingASandwich makeSandwich = new MakingASandwich();

        BreadType userBreadType = BreadType.WHITE;
        BreadSize userBreadSize = BreadSize.MEDIUM;

        System.out.println("THE BLT COME WITH WHITE BREAD IS THAT OK?");
        String breadType = scanner.nextLine();

        if (breadType.equalsIgnoreCase("yes")) {
            System.out.println("\nOK YOUR BREAD IS WHITE\n");
        }
        if (breadType.equalsIgnoreCase("no")) {
            int userBreadTypeInput = getIntInput(displaySelectBreadType());
            if (userBreadTypeInput >= 0 && userBreadTypeInput < BreadType.values().length) {
                userBreadType = BreadType.values()[userBreadTypeInput];
                System.out.println("\n" + BreadType.values()[userBreadTypeInput] + " SELECTED!\n");
            } else {
                // If user input is invalid, keep the default value (White bread)
                System.out.println("Invalid choice. Defaulting to White Bread.");
            }
        }
        System.out.println("THE BLT COME ON 8 INCH BREAD IS THAT OK?");
        String breadSize = scanner.nextLine();

        // Handle user input for bread size
        int userBreadSizeInput = getIntInput(displaySelectBreadSize());
        if (breadSize.equalsIgnoreCase("yes")) {
            System.out.println("\nOK, YOUR BREAD SIZE IS MEDIUM\n");
        }
        if (breadSize.equalsIgnoreCase("no")) {
            if (userBreadSizeInput >= 0 && userBreadSizeInput < BreadSize.values().length) {
                userBreadSize = BreadSize.values()[userBreadSizeInput];
                System.out.println("\n" + BreadSize.values()[userBreadSizeInput] + " SANDWICH SIZE SELECTED!\n");
            } else {
                System.out.println("Invalid choice. Defaulting to MEDIUM.");
            }
        }
        Sandwich b = new Sandwich(userBreadType, userBreadSize, true);

        System.out.println("IS BACON OK?");
        String meat = scanner.nextLine();
        if (meat.equalsIgnoreCase("yes")){
            b.addTopping(new Meat(userBreadSize, true, MeatType.BACON));
            System.out.println("\nOK ADDING BACON.....\n");
        }
        if (meat.equalsIgnoreCase("no")){
            int meatInput = getIntInput(displayMeats());

            String extraMeat = getStringInput(askForExtraMeat());

            MeatType userMeatType;
            if (meatInput == 6) {
                System.out.println("NO MEAT SELECTED");
            } else if (meatInput >= 0 && meatInput < 5 && meatInput < MeatType.values().length) {
                userMeatType = MeatType.values()[meatInput];
                System.out.println("\n" + MeatType.values()[meatInput] + " SELECTED\n");
                boolean userExtraMeat;
                userExtraMeat = extraMeat.equalsIgnoreCase("yes");
                b.addTopping(new Meat(b.getSandwichSize(), userExtraMeat, userMeatType));
            } else {
                System.out.println("\nInvalid meat selection. Defaulting to CHICKEN.\n");
                userMeatType = MeatType.CHICKEN;
            }
        }

        System.out.println("THE BLT COMES WITH LETTUCE AND TOMATO IS THAT OK?");
        String topping = scanner.nextLine();
        if (topping.equalsIgnoreCase("yes")) {
            b.addTopping(new RegularTopping(ToppingType.TOMATOES));
            System.out.println("OK ADDING LETTUCE AND TOMATOES.....\n");
        } else {
            makeSandwich.addRegularToppingToSandwich(b);
        }

        System.out.println("IS CHEDDAR CHEESE OK?");
        String cheese = scanner.nextLine();
        if (cheese.equalsIgnoreCase("yes")) {
            b.addTopping(new Cheese(userBreadSize, true, CheeseType.CHEDDAR));
            System.out.println("\nOK ADDING CHEDDER\n");
        }
        if (cheese.equalsIgnoreCase("no")) {
            int cheeseInput = getIntInput(displayCheese());
            String extraCheese = getStringInput(askForExtraCheese());
            CheeseType userCheeseType;
            if (cheeseInput == 4) {
                System.out.println("\nNO CHEESE SELECTED\n");
            } else if (cheeseInput >= 0 && cheeseInput < CheeseType.values().length) {
                userCheeseType = CheeseType.values()[cheeseInput];
                System.out.println("\n" + CheeseType.values()[cheeseInput] + "SELECTED\n");
                boolean userExtraCheese;
                userExtraCheese = extraCheese.equalsIgnoreCase("yes");
                Cheese c = new Cheese(b.getSandwichSize(), userExtraCheese, userCheeseType);
                b.addTopping(c);
            } else {
                System.out.println("Invalid cheese selection. Defaulting to CHEDDAR.");
                userCheeseType = CheeseType.CHEDDAR;
            }
        }
        System.out.println("IS RANCH OK?");
        String sauce = scanner.nextLine();
        if (sauce.equalsIgnoreCase("yes")){
            b.addTopping(new Sauce(SaucesType.RANCH));
            System.out.println("\nOK ADDING RANCH....\n");
        }
        if (sauce.equalsIgnoreCase("no")){
            makeSandwich.addSauce(b);
        }
        order.addItem(b);
        System.out.println("\nSANDWICH ADDED\n");
    }

}


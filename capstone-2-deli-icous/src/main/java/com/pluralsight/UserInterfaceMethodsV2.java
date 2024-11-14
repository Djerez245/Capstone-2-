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

    public String getStringInput(String displayScreen) {
        System.out.println(displayScreen);
        String input = scanner.nextLine();
        return input;
    }

    // adding sandwich and toppings
    public void addSandwich() {
        MakingASandwich makeSandwich = new MakingASandwich();
        int selectSandwich = getIntInput(chooseSandwich());
        if (selectSandwich == 1) {
            makeSandwich.addBlt();
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

                    // user can select their Bread Type and Size
                    makeSandwich.chooseBreadType(breadTypeInput);
                    makeSandwich.chooseBreadSize(breadSizeInput);
                    BreadType userBreadType = makeSandwich.getUserBreadType();
                    BreadSize userBreadSize = makeSandwich.getUserBreadSize();

                    // Create and add sandwich to order
                    Sandwich s = new Sandwich(userBreadType, userBreadSize, toasted);

                    // getting user input to add meat and cheese
                    makeSandwich.addRegularToppingToSandwich(s);
                    int meatInput = getIntInput(displayMeats());

                    // Adding meat with extra option
                    makeSandwich.chooseMeatType(meatInput, s);

                    // Adding cheese with extra option
                    int cheeseInput = getIntInput(displayCheese());
                    makeSandwich.chooseCheeseType(cheeseInput, s);
                    // Adding sauce to sandwich
                    makeSandwich.addSauce(s);
                    order.addItem(s);
                    System.out.println("\nSANDWICH ADDED\n");

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input type. Please enter a number where expected.");
                    scanner.nextLine();
                }  catch (NullPointerException e) {
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
        CreateADrink newDrink = new CreateADrink();
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
                newDrink.chooseDrink(drinkSizeInput, drinkTypeInput);

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

}

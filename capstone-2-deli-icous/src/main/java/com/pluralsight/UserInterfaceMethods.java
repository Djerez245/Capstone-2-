package com.pluralsight;

import enums.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterfaceMethods extends DisplayScreens {

    Scanner scanner = new Scanner(System.in);

    Order order = new Order();
    PrintReceipt receipt = new PrintReceipt();

    public int getIntInput(String displayScreen) {
        System.out.println(displayScreen);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
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
            moreToppings();
            String moreToppingInput = scanner.nextLine();

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
            moreSauce();
            String moreSauceInput = scanner.nextLine();

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



    // adding sandwich and toppings
    public void addSandwich() {
        boolean addingSandwich = true;
        while (addingSandwich) {
            try {
                // getting user input to create a sandwich
                int breadTypeInput = getIntInput(displaySelectBreadType());
                int breadSizeInput = getIntInput(displaySelectBreadSize());

                toastedOrNo();
                String toasted = scanner.nextLine();

                BreadType userBreadType;
                BreadSize userBreadSize;
                boolean userToasted;

                // Setting sandwich bread type and size with exception handling
                if (breadTypeInput >= 0 && breadTypeInput < BreadType.values().length) {
                    userBreadType = BreadType.values()[breadTypeInput];
                    System.out.println("\n" + BreadType.values()[breadTypeInput] + " SELECTED!\n");
                } else {
                    System.out.println("Invalid bread type selection. Defaulting to WHITE.");
                    userBreadType = BreadType.WHITE;
                }

                if (breadSizeInput >= 0 && breadSizeInput < BreadSize.values().length) {
                    userBreadSize = BreadSize.values()[breadSizeInput];
                    System.out.println("\n" + BreadSize.values()[breadSizeInput] + " SANDWICH SIZE SELECTED!\n");
                } else {
                    System.out.println("Invalid bread size selection. Defaulting to MEDIUM.");
                    userBreadSize = BreadSize.MEDIUM;
                }
                userToasted = toasted.equalsIgnoreCase("yes");

                // Create and add sandwich to order
                Sandwich s = new Sandwich(userBreadType, userBreadSize, userToasted);

                addRegularToppingToSandwich(s);

                int meatInput = getIntInput(displayMeats());

                // getting user input to add meat and cheese
                askForExtraMeat();
                String extraMeat = scanner.nextLine();

                // Adding meat with extra option
                MeatType userMeatType;
                if (meatInput == 6) {
                    System.out.println("NO MEAT SELECTED");
                }
                else if (meatInput >= 0 && meatInput < 5 && meatInput < MeatType.values().length) {
                    userMeatType = MeatType.values()[meatInput];
                    System.out.println("\n" + MeatType.values()[meatInput] + " SELECTED\n");
                    boolean userExtraMeat;
                    userExtraMeat = extraMeat.equalsIgnoreCase("yes");
                    s.addTopping(new Meat(s.getSandwichSize(), userExtraMeat, userMeatType));
                }

                else {
                    System.out.println("\nInvalid meat selection. Defaulting to CHICKEN.\n");
                    userMeatType = MeatType.CHICKEN;
                }


                int cheeseInput = getIntInput(displayCheese());

                askForExtraCheese();
                String extraCheese = scanner.nextLine();

                // Adding cheese with extra option
                CheeseType userCheeseType;
                if (cheeseInput == 4){
                    System.out.println("\nNO CHEESE SELECTED\n");
                }
                else if (cheeseInput >= 0 && cheeseInput < CheeseType.values().length) {
                    userCheeseType = CheeseType.values()[cheeseInput];
                    System.out.println("\n" + CheeseType.values()[cheeseInput] + "SELECTED\n");
                    boolean userExtraCheese;
                    userExtraCheese = extraCheese.equalsIgnoreCase("yes");
                    Cheese c = new Cheese(s.getSandwichSize(), userExtraCheese, userCheeseType);
                    s.addTopping(c);
                }

                else {
                    System.out.println("Invalid cheese selection. Defaulting to CHEDDAR.");
                    userCheeseType = CheeseType.CHEDDAR;
                }


                // Adding sauce to sandwich
                addSauce(s);
                order.addItem(s);
                System.out.println(order.items);
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
            anotherSandwich();
            String anotherSandwichInput = scanner.nextLine();
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
            moreDrink();
            String moreDrinkInput = scanner.nextLine();

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
            moreChips();
            String moreChipsInput = scanner.nextLine();
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
                } catch (NullPointerException nullPointerException){
                    System.out.println("Sorry your order is empty");
                }
            }
            try{
            if (checkoutInput == 1) {
                order.removeOrder(o);
            }
            }catch (NullPointerException nullPointerException){
            System.out.println("Sorry your order is empty");
        }

        }
}


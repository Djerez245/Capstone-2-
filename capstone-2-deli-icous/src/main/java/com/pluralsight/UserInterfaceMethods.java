package com.pluralsight;

import com.pluralsight.enums.*;
import com.pluralsight.interfaces.Item;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterfaceMethods extends DisplayScreens {

    Scanner scanner = new Scanner(System.in);

    Order order = new Order();
    PrintReceipt receipt = new PrintReceipt();


    // method to get int from user input
    public int getIntInput(String displayScreen) {
        System.out.println(displayScreen);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
    // getting user input as a string
    public String getStringInput(String displayScreen) {
        System.out.println(displayScreen);
        String input = scanner.nextLine();
        return input;
    }

    // adding sandwich and toppings
    public void addSandwich() {
        MakingASandwich makeSandwich = new MakingASandwich();

        // if the user enters 1 I bring them to the method to add a BLT to their order
        int selectSandwich = getIntInput(chooseSandwich());
        if (selectSandwich == 1) {
            addBlt();
        }
        // if the user enters 2 I bring them to the method to add a philly to their order
        if (selectSandwich == 2) {
            addPhilly();
        }
        // if the user enters 3 I continue to add a build your own sandwich
        if (selectSandwich == 3) {
            boolean addingSandwich = true;
            while (addingSandwich) {
                try {
                    // getting user input to create a sandwich
                    int breadTypeInput = getIntInput(displaySelectBreadType());
                    int breadSizeInput = getIntInput(displaySelectBreadSize());

                    // getting value from user as a string and turning it into a boolean
                    String toastedString = getStringInput(toastedOrNo());
                    boolean toasted = toastedString.equalsIgnoreCase("yes");

                    // user can select their Bread Type and Size
                    makeSandwich.chooseBreadType(breadTypeInput); // logic to take the users input and get the correct bread type and size
                    makeSandwich.chooseBreadSize(breadSizeInput);
                    BreadType userBreadType = makeSandwich.getUserBreadType(); // here I use getters to get the bread type and size so I can add them to the sandwich
                    BreadSize userBreadSize = makeSandwich.getUserBreadSize();

                    // Create and add sandwich to order
                    Sandwich s = new Sandwich(userBreadType, userBreadSize, toasted);

                    // getting user input to add meat and cheese
                    makeSandwich.addRegularToppingToSandwich(s); // gets users toppings and adds them to the sandwich

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
                } catch (NullPointerException e) {
                    System.out.println("Error: Missing sandwich or order details.");
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred: ");
                }
                // asking user if they would like another sandwich if yes the loop restarts
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
                // asking user for their drink size
                int drinkSizeInput = getIntInput(whatDrinkSize());
                // gives user an option to go back if they change their mind on getting a drink
                if (drinkSizeInput == 3) {
                    addingDrinks = false;
                    continue;
                }
                // asking user for their drink type
                int drinkTypeInput = getIntInput(drinkType());


                // Check if drinkSizeInput and drinkTypeInput are valid
                newDrink.chooseDrink(drinkSizeInput, drinkTypeInput);
                DrinkSize userDrinkSize = newDrink.getSelectedDrinkSize();
                DrinkType userDrinkType = newDrink.getSelectedDrinkType();
                Drink d = new Drink(userDrinkType, userDrinkSize);
                order.addItem(d);

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



    public void addBlt() {
        MakingASandwich makeSandwich = new MakingASandwich();
        BreadType userBreadType = BreadType.WHITE;
        BreadSize userBreadSize = BreadSize.MEDIUM;
        whatComesOnBLT();
        String changeSandwich = getStringInput("WOULD YOU LIKE TO KEEP THE SANDWICH THE SAME?");

        if (changeSandwich.equalsIgnoreCase("yes")) {
            // if user wants to keep the sandwich the same I add the items for the  user
            Sandwich b = new Sandwich(userBreadType, userBreadSize, true);
            b.addTopping(new Meat(userBreadSize, true, MeatType.BACON));
            b.addTopping(new RegularTopping(ToppingType.TOMATOES));
            b.addTopping(new RegularTopping(ToppingType.LETTUCE));
            b.addTopping(new Cheese(userBreadSize, true, CheeseType.CHEDDAR));
            b.addTopping(new Sauce(SaucesType.RANCH));
            order.addItem(b);

            System.out.println("\nSANDWICH ADDED\n");
        } else {
            // goes through the sandwich asking the user what they want to change if they say yes they can change what they want
            String breadType = getStringInput("THE BLT COME WITH WHITE BREAD IS THAT OK?");

            if (breadType.equalsIgnoreCase("yes")) {
                System.out.println("\nOK YOUR BREAD IS WHITE\n");
            } else {
                int userBreadTypeInput = getIntInput(displaySelectBreadType());
                makeSandwich.chooseBreadType(userBreadTypeInput);
            }
            String breadSize = getStringInput("THE BLT COME ON 8 INCH BREAD IS THAT OK?");

            if (breadSize.equalsIgnoreCase("yes")) {
                System.out.println("\nOK, YOUR BREAD SIZE IS MEDIUM\n");
            } else {
                int userBreadSizeInput = getIntInput(displaySelectBreadSize());
                makeSandwich.chooseBreadSize(userBreadSizeInput);
            }
            Sandwich b = new Sandwich(userBreadType, userBreadSize, true);

            String meat = getStringInput("IS BACON OK?");

            if (meat.equalsIgnoreCase("yes")) {
                System.out.println("\nOK ADDING BACON.....\n");
            } else {
                int meatInput = getIntInput(displayMeats());
                makeSandwich.chooseMeatType(meatInput, b);
            }
            String topping = getStringInput("THE BLT COMES WITH LETTUCE AND TOMATO IS THAT OK?");

            if (topping.equalsIgnoreCase("yes")) {
                System.out.println("OK ADDING LETTUCE AND TOMATOES.....\n");
            } else {
                makeSandwich.addRegularToppingToSandwich(b);
            }
            String cheese = getStringInput("IS CHEDDAR CHEESE OK?");

            if (cheese.equalsIgnoreCase("yes")) {
                System.out.print("\nOK ADDING CHEDDER\n");
            } else {
                int cheeseInput = getIntInput(displayCheese());
                makeSandwich.chooseCheeseType(cheeseInput, b);
            }
            String sauce = getStringInput("IS RANCH OK?");
            if (sauce.equalsIgnoreCase("yes")) {
                b.addTopping(new Sauce(SaucesType.RANCH));
                System.out.println("\nOK ADDING RANCH....\n");
            } else {
                makeSandwich.addSauce(b);
            }
            order.addItem(b);
            System.out.println("\nSANDWICH ADDED\n");
        }
    }

    public void addPhilly() {
        MakingASandwich makeSandwich = new MakingASandwich();
        BreadType userBreadType = BreadType.WHITE;
        BreadSize userBreadSize = BreadSize.MEDIUM;

        whatComesOnPhilly();
        String changeSandwich = getStringInput("WOULD YOU LIKE TO KEEP THE SANDWICH THE SAME? (Enter yes or no)");

        if (changeSandwich.equalsIgnoreCase("yes")) {

            Sandwich b = new Sandwich(userBreadType, userBreadSize, true);
            b.addTopping(new Meat(userBreadSize, true, MeatType.STEAK));
            b.addTopping(new RegularTopping(ToppingType.PEPPERS));
            b.addTopping(new Cheese(userBreadSize, true, CheeseType.AMERICAN));
            b.addTopping(new Sauce(SaucesType.MAYO));
            order.addItem(b);

            System.out.println("\nSANDWICH ADDED\n");
        } else {
            // Ask about bread type
            String breadType = getStringInput("THE PHILLY COME WITH WHITE BREAD IS THAT OK? (Enter yes or no)");
            if (breadType.equalsIgnoreCase("yes")) {
                System.out.println("\nOK YOUR BREAD IS WHITE\n");
            } else if (breadType.equalsIgnoreCase("no")) {
                int userBreadTypeInput = getIntInput(displaySelectBreadType());
                makeSandwich.chooseBreadType(userBreadTypeInput);
            } else {
                System.out.println("Invalid choice. Defaulting to White Bread.");
            }

            // Ask about bread size
            String breadSize = getStringInput("THE PHILLY COMES ON 8 INCH BREAD IS THAT OK? (Enter yes or no)");
            if (breadSize.equalsIgnoreCase("yes")) {
                System.out.println("\nOK, YOUR BREAD SIZE IS MEDIUM\n");
            } else {
                int userBreadSizeInput = getIntInput(displaySelectBreadSize());
                makeSandwich.chooseBreadSize(userBreadSizeInput);
            }

            // Create sandwich
            Sandwich b = new Sandwich(userBreadType, userBreadSize, true);

            // Ask about meat choice
            String meat = getStringInput("IS STEAK OK? (Enter yes or no)");
            if (meat.equalsIgnoreCase("yes")) {
                System.out.println("\nOK ADDING STEAK.....\n");
            } else {
                int meatInput = getIntInput(displayMeats());
                makeSandwich.chooseMeatType(meatInput, b);
            }

            // Ask about topping (peppers)
            String topping = getStringInput("THE PHILLY COMES WITH PEPPERS IS THAT OK? (Enter yes or no)");
            if (!topping.equalsIgnoreCase("yes")) {
                makeSandwich.addRegularToppingToSandwich(b);
            } else {
                System.out.println("OK ADDING PEPPERS.....\n");
            }

            // Ask about cheese
            String cheese = getStringInput("IS AMERICAN CHEESE OK? (Enter yes or no)");
            if (cheese.equalsIgnoreCase("yes")) {
                System.out.println("\nOK ADDING AMERICAN\n");
            } else {
                int cheeseInput = getIntInput(displayCheese());
                makeSandwich.chooseCheeseType(cheeseInput, b);
            }

            // Ask about sauce
            String sauce = getStringInput("IS MAYO OK?");
            if (sauce.equalsIgnoreCase("yes")) {
                b.addTopping(new Sauce(SaucesType.MAYO));
                System.out.println("\nOK ADDING MAYO....\n");
            } else {
                makeSandwich.addSauce(b);
            }
            order.addItem(b);
            System.out.println("\nSANDWICH ADDED\n");
        }

    }
    public void checkout(Order o) {
        // shows the users order summary so they can see what they have before they check out
        orderSummary();
        for (Item item : o.items) {
            System.out.println(item.toStringForItems());
        }
        System.out.printf("""
        ===============================
           YOUR TOTAL IS: $%.2f
        ===============================
        
        """, o.getPrice());


        int checkoutInput = getIntInput(displayCheckout());
        try {
            if (checkoutInput == 0) {
                if(order.items.isEmpty()){
                    System.out.println("SORRY YOUR CART IS EMPTY");
                    }
                if (!order.items.isEmpty()) {
                    receipt.printReceiptToFile(o);
            }
        }
            if (checkoutInput == 1) {
                // option for user to cancel their order instead of checking out
                order.removeOrder(o);
                System.out.println("ORDER HAS BEEN REMOVED");
            }

        }catch (InputMismatchException e){
            System.out.println("please enter a valid number");
        }

        }

}


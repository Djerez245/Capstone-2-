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
    Order order = new Order();


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

            String moreToppingInput = user.getStringInput(moreToppings());

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
            int sauceType = user.getIntInput(displaySauces());
            if (sauceType == 6) {
                addingSauce = false;
            } else if (sauceType >= 0 && sauceType < SaucesType.values().length) {
                SaucesType selectedSauce = SaucesType.values()[sauceType];
                Sauce sauce = new Sauce(selectedSauce);
                s.addTopping(sauce);
                System.out.println("\n" + SaucesType.values()[sauceType] + " SELECTED\n");
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

    public void chooseMeatType(int meatTypeInput, Sandwich s) {

        // Adding meat with extra option
        if (meatTypeInput == 6) {
            System.out.println("NO MEAT SELECTED");
        } else if (meatTypeInput >= 0 && meatTypeInput <= 5 && meatTypeInput < MeatType.values().length) {
            MeatType userMeatType = MeatType.values()[meatTypeInput];
            System.out.println("\n" + MeatType.values()[meatTypeInput] + " SELECTED\n");
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
            System.out.println("\n" + CheeseType.values()[cheeseInput] + " SELECTED\n");
            String extraCheeseString = user.getStringInput(askForExtraCheese());
            boolean extraCheese = extraCheeseString.equalsIgnoreCase("yes");
            Cheese c = new Cheese(s.getSandwichSize(), extraCheese, userCheeseType);
            s.addTopping(c);
        } else {
            System.out.println("Invalid cheese selection. Defaulting to CHEDDAR.");
            userCheeseType = CheeseType.CHEDDAR;
        }
    }


    public void addPhilly() {
        String changeSandwich = user.getStringInput("WOULD YOU LIKE TO KEEP THE SANDWICH THE SAME?");

        if (changeSandwich.equalsIgnoreCase("yes")) {
            BreadType userBreadType = BreadType.WHITE;
            BreadSize userBreadSize = BreadSize.MEDIUM;
            Sandwich b = new Sandwich(userBreadType, userBreadSize, true);
            b.addTopping(new Meat(userBreadSize, true, MeatType.STEAK));
            b.addTopping(new RegularTopping(ToppingType.PEPPERS));
            b.addTopping(new Cheese(userBreadSize, true, CheeseType.AMERICAN));
            b.addTopping(new Sauce(SaucesType.MAYO));
            order.addItem(b);

            System.out.println("\nSANDWICH ADDED\n");
        } else {
            String breadType = user.getStringInput("THE PHILLY COME WITH WHITE BREAD IS THAT OK?");

            if (breadType.equalsIgnoreCase("yes")) {
                System.out.println("\nOK YOUR BREAD IS WHITE\n");
            }
            if (breadType.equalsIgnoreCase("no")) {
                int userBreadTypeInput = user.getIntInput(displaySelectBreadType());
                chooseBreadType(userBreadTypeInput);
            } else {
                System.out.println("Invalid choice. Defaulting to White Bread.");
            }
            String breadSize = user.getStringInput("THE PHILLY COME ON 8 INCH BREAD IS THAT OK?");

            if (breadSize.equalsIgnoreCase("yes")) {
                System.out.println("\nOK, YOUR BREAD SIZE IS MEDIUM\n");
            }
            if (breadSize.equalsIgnoreCase("no")) {
                int userBreadSizeInput = user.getIntInput(displaySelectBreadSize());
                chooseBreadSize(userBreadSizeInput);
            } else {
                System.out.println("Invalid choice. Defaulting to MEDIUM.");
            }
            Sandwich b = new Sandwich(userBreadType, userBreadSize, true);

            String meat = user.getStringInput("IS STEAK OK?");

            if (meat.equalsIgnoreCase("yes")) {
                System.out.println("\nOK ADDING STEAK.....\n");
            }
            if (meat.equalsIgnoreCase("no")) {
                int meatInput = user.getIntInput(displayMeats());
                chooseMeatType(meatInput, b);
            }
            String topping = user.getStringInput("THE PHILLY COMES WITH PEPPERS IS THAT OK?");

            if (topping.equalsIgnoreCase("yes")) {
                System.out.println("OK ADDING PEPPERS.....\n");
            } else {
                addRegularToppingToSandwich(b);
            }
            String cheese = user.getStringInput("IS AMERICAN CHEESE OK?");

            if (cheese.equalsIgnoreCase("yes")) {
                System.out.println("\nOK ADDING AMERICAN\n");
            }
            if (cheese.equalsIgnoreCase("no")) {
                int cheeseInput = user.getIntInput(displayCheese());
                chooseCheeseType(cheeseInput, b);
            }
            String sauce = user.getStringInput("IS MAYO OK?");
            if (sauce.equalsIgnoreCase("yes")) {
                b.addTopping(new Sauce(SaucesType.RANCH));
                System.out.println("\nOK ADDING MAYO....\n");
            }
            if (sauce.equalsIgnoreCase("no")) {
                addSauce(b);
            }
            order.addItem(b);
            System.out.println("\nSANDWICH ADDED\n");
        }
    }

}

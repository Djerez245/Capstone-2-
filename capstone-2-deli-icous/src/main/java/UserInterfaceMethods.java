import java.util.Scanner;

public class UserInterfaceMethods {

    Scanner scanner = new Scanner(System.in);
    Sandwich sandwich;
    PremiumToppings premiumToppings;
    Topping topping;
    Meat meat;
    Cheese cheese;
    Drink drink;
    Order order;
    Chips chips;



    public void addSandwich(){
        DisplayScreens.displaySelectBreadType();
        int breadTypeInput = scanner.nextInt();
        scanner.nextLine();
        DisplayScreens.displaySelectBreadSize();
        int breadSizeInput = scanner.nextInt();
        scanner.nextLine();
        DisplayScreens.displayMeats();
        int meatInput = scanner.nextInt();
        scanner.nextLine();
        DisplayScreens.askForExtraMeat();
        String extraMeat = scanner.nextLine();
        DisplayScreens.displayCheese();
        int cheeseInput = scanner.nextInt();
        scanner.nextLine();
        DisplayScreens.askForExtraCheese();
        String extraCheese = scanner.nextLine();
        for (Topping t : sandwich.topping){
            DisplayScreens.whatToppings();
            int toppingInput = scanner.nextInt();
            scanner.nextLine();
            if (toppingInput == sandwich.toppingType.ordinal()){
                sandwich.addTopping(t);
            }
        }
        DisplayScreens.displaySauces();
        int sauceType = scanner.nextInt();
        scanner.nextLine();
        DisplayScreens.toastedOrNo();
        String toasted = scanner.nextLine();

        if (breadTypeInput == sandwich.breadType.ordinal()){
          sandwich.breadType = BreadType.values()[breadTypeInput];
        }
        if (breadSizeInput == sandwich.sandwichSize.ordinal()){
            sandwich.sandwichSize = BreadSize.values()[breadSizeInput];
        }
        if (toasted.equalsIgnoreCase("yes")){
            sandwich.isToasted = true;
        }
        if (toasted.equalsIgnoreCase("no")){
            sandwich.isToasted = false;
        }
        Sandwich s = new Sandwich(sandwich.getBreadType(), sandwich.getSandwichSize(), sandwich.isToasted);
        order.addSandwich(s);

        //TODO: figure out toppings

        if (meatInput == meat.meatType.ordinal()){
            meat.meatType = MeatType.values()[meatInput];
        }
        if (extraMeat.equalsIgnoreCase("yes")){
            premiumToppings.extraTopping = true;
        }
        if (extraMeat.equalsIgnoreCase("no")){
            premiumToppings.extraTopping = false;
        }
        if (cheeseInput == cheese.cheeseType.ordinal()){
            cheese.cheeseType = CheeseType.values()[cheeseInput];
        }
        if (extraCheese.equalsIgnoreCase("yes")){
            premiumToppings.extraTopping = true;
        }
        if (extraCheese.equalsIgnoreCase("no")){
            premiumToppings.extraTopping = false;
        }
    }

    public void addDrink(){
        DisplayScreens.WhatDrinkSize();
        int drinkSizeInput = scanner.nextInt();
        scanner.nextLine();
        DisplayScreens.drinkType();
        int drinkTypeInput = scanner.nextInt();
        scanner.nextLine();
        if (drinkSizeInput == drink.drinkSize.ordinal()){
            drink.drinkSize = DrinkSize.values()[drinkSizeInput];
        }
        if (drinkTypeInput == drink.drinkType.ordinal()){
            drink.drinkType = DrinkType.values()[drinkTypeInput];
        }
        Drink d = new Drink(drink.getDrinkType(), drink.getDrinkSize());
        order.addDrink(d);
    }

    public void addChips() {
        for (Chips c : order.chips) {
            DisplayScreens.typeOfChips();
            int chipsInput = scanner.nextInt();
            scanner.nextLine();
            if (chipsInput == chips.chipsType.ordinal()){
                chips.chipsType = ChipsType.values()[chipsInput];
            }
            Chips ch = new Chips(chips.getChipsType());
            order.addChip(ch);
            DisplayScreens.moreChips();
            String moreChips = scanner.nextLine();
            if (moreChips.equalsIgnoreCase("no")){
                break;
            }

        }
    }



}

import java.util.Scanner;

public class UserInterfaceMethods extends DisplayScreens {

    Scanner scanner = new Scanner(System.in);
    Sandwich sandwich;
    PremiumToppings premiumToppings;
    Topping topping;
    Meat meat;
    Cheese cheese;
    Order order;
    Chips chips;
    Sauce sauce;

    public int getIntInput(String displayScreen) {
        System.out.println(displayScreen);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }


    public void addSandwich() {
        int breadTypeInput = getIntInput(displaySelectBreadType());
        int breadSizeInput = getIntInput(displaySelectBreadSize());
        int meatInput = getIntInput(displayMeats());
        askForExtraMeat();
        String extraMeat = scanner.nextLine();
        int cheeseInput = getIntInput(displayCheese());
        askForExtraCheese();
        String extraCheese = scanner.nextLine();
        for (Topping t : sandwich.topping) {
            int toppingInput = getIntInput(whatToppings());
            if (toppingInput == sandwich.toppingType.ordinal()) {
                sandwich.addTopping(t);
            }
        }
        int sauceType = getIntInput(displaySauces());

        toastedOrNo();
        String toasted = scanner.nextLine();

        sandwich.breadType = BreadType.values()[breadTypeInput];

        sandwich.sandwichSize = BreadSize.values()[breadSizeInput];

        if (toasted.equalsIgnoreCase("yes")) {
            sandwich.isToasted = true;
        }
        if (toasted.equalsIgnoreCase("no")) {
            sandwich.isToasted = false;
        }
        Sandwich s = new Sandwich(sandwich.getBreadType(), sandwich.getSandwichSize(), sandwich.topping, sandwich.isToasted);
        order.addSandwich(s);

        // adding toppings

        meat.meatType = MeatType.values()[meatInput];

        if (extraMeat.equalsIgnoreCase("yes")) {
            premiumToppings.extraTopping = true;
        }
        if (extraMeat.equalsIgnoreCase("no")) {
            premiumToppings.extraTopping = false;
        }
        Meat m = new Meat(premiumToppings.getBreadSize(), premiumToppings.isExtraTopping(), meat.getMeatType());
        sandwich.addTopping(meat);

        cheese.cheeseType = CheeseType.values()[cheeseInput];

        if (extraCheese.equalsIgnoreCase("yes")) {
            premiumToppings.extraTopping = true;
        }
        if (extraCheese.equalsIgnoreCase("no")) {
            premiumToppings.extraTopping = false;
        }
        Cheese c = new Cheese(premiumToppings.getBreadSize(), premiumToppings.isExtraTopping(), cheese.getCheeseType());

        SaucesType selectedSauce = SaucesType.values()[sauceType];
        Sauce sauce = new Sauce(selectedSauce);
        sandwich.addTopping(sauce);
    }

    public void addDrink() {
        try {
            for (Drink dr : order.drinks) {

                int drinkSizeInput = getIntInput(whatDrinkSize());
                int drinkTypeInput = getIntInput(drinkType());

                DrinkSize selectedDrinkSize = DrinkSize.values()[drinkSizeInput];
                DrinkType selectedDrinkType = DrinkType.values()[drinkTypeInput];
                Drink d = new Drink(selectedDrinkType, selectedDrinkSize);
                order.addDrink(d);
                if (drinkSizeInput == 0) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("IM SORRY I COULD NOT ADD YOUR DRINK!");
            throw new RuntimeException(e);
        }
    }

    public void addChips() {
        for (Chips c : order.chips) {
            int chipsInput = getIntInput(typeOfChips());
            chips.chipsType = ChipsType.values()[chipsInput];

            Chips ch = new Chips(chips.getChipsType());
            order.addChip(ch);
            moreChips();
            String moreChips = scanner.nextLine();
            if (moreChips.equalsIgnoreCase("no")) {
                break;
            }

        }
    }


}

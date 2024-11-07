import java.util.Scanner;

public class UserInterfaceMethods {

    Scanner scanner = new Scanner(System.in);
    Sandwich sandwich;
    PremiumToppings premiumToppings;
    Topping topping;
    Meat meat;
    Cheese cheese;



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
}

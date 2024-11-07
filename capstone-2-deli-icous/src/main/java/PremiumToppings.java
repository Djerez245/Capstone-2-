import java.util.ArrayList;

public class PremiumToppings extends Sandwich implements Priceable {
    protected Meat meat;
    protected Cheese cheese;

    public PremiumToppings(double price, String customerName, Sandwich sandwich, BreadSize breadSize, Chips chips, Drink drink,
                           DrinkSize drinkSize, Bread bread, BreadSize sandwichSize, ArrayList<Topping> toppings, Meat meat, Cheese cheese) {
        super(price, customerName, sandwich, breadSize, chips, drink, drinkSize, bread, sandwichSize, toppings);
        this.meat = meat;
        this.cheese = cheese;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}

import javax.print.attribute.standard.Sides;
import java.util.ArrayList;

public class Sandwich extends Order {
    protected Bread bread;
    protected BreadSize sandwichSize;
    protected ArrayList<Topping> toppings;
    protected Sauces sauces;

    public Sandwich(double price, String customerName, Sandwich sandwich, BreadSize breadSize, Chips chips, Sides sides, Drink drink,
                    DrinkSize drinkSize, Bread bread, BreadSize sandwichSize, ArrayList<Topping> toppings, Sauces sauces) {
        super(price, customerName, sandwich, breadSize, chips, sides, drink, drinkSize);
        this.bread = bread;
        this.sandwichSize = sandwichSize;
        this.toppings = toppings;
        this.sauces = sauces;
    }
}

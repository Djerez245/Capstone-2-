import java.util.ArrayList;

public class Sandwich extends Deli {
    protected String sandwichName;
    protected ArrayList<Topping> toppings;

    public Sandwich(double price, String sandwichName, ArrayList<Topping> toppings, Bread bread, Topping topping, Sauces sauces) {
        super(price);
        this.sandwichName = sandwichName;
        this.toppings = toppings;
        this.bread = bread;
        this.topping = topping;
        this.sauces = sauces;
    }

    Bread bread;
    Topping topping;
    Sauces sauces;



}

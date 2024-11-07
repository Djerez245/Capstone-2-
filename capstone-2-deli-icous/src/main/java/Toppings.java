import java.util.ArrayList;

public class Toppings extends Sandwich implements Priceable {

    PremiumTopping premiumTopping;

    public Toppings(double price, String sandwichName, ArrayList<Topping> toppings, Bread bread, Topping topping, Sauces sauces
                    , PremiumTopping premiumTopping) {
        super(price, sandwichName, toppings, bread, topping, sauces);
        this.premiumTopping = premiumTopping;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}


public abstract class PremiumToppings extends Topping implements Priceable {
    BreadSize breadSize;
    boolean extraTopping;
    double toppingPrice;

    public PremiumToppings(BreadSize breadSize, boolean extraTopping) {
        this.breadSize = breadSize;
        this.extraTopping = extraTopping;
    }
}
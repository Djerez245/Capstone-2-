
public class Order extends customer implements Priceable{

    protected Sandwich sandwich;
    protected BreadSize breadSize;
    protected Chips chips;
    protected Sides sides;
    protected Drink drink;
    protected DrinkSize drinkSize;

    public Order(double price, String customerName, Sandwich sandwich, BreadSize breadSize, Chips chips, Sides sides,
                 Drink drink, DrinkSize drinkSize) {
        super(price, customerName);
        this.sandwich = sandwich;
        this.breadSize = breadSize;
        this.chips = chips;
        this.sides = sides;
        this.drink = drink;
        this.drinkSize = drinkSize;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }
}

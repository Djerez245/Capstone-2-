public class Order extends Deli{

    Sandwich sandwich;
    BreadSize breadSize;
    Chips chips;
    Drink drink;
    DrinkSize drinkSize;

    public Order(double price, Sandwich sandwich, BreadSize breadSize, Chips chips, Drink drink, DrinkSize drinkSize) {
        super(price);
        this.sandwich = sandwich;
        this.breadSize = breadSize;
        this.chips = chips;
        this.drink = drink;
        this.drinkSize = drinkSize;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public BreadSize getBreadSize() {
        return breadSize;
    }

    public Chips getChips() {
        return chips;
    }

    public Drink getDrink() {
        return drink;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }
}

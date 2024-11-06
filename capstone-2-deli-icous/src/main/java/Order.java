public class Order {

    Sandwich sandwich;
    BreadSize breadSize;
    Chips chips;
    Drink drink;
    DrinkSize drinkSize;

    public Order(Sandwich sandwich, BreadSize breadSize, Chips chips, Drink drink, DrinkSize drinkSize) {
        this.sandwich = sandwich;
        this.breadSize = breadSize;
        this.chips = chips;
        this.drink = drink;
        this.drinkSize = drinkSize;
    }
}

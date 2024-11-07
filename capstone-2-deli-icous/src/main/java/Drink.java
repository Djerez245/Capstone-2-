public class Drink implements Priceable{
    private DrinkSize drinkSize;
    private double DrinkPrice;

    public Drink(DrinkSize drinkSize, double price) {
        this.drinkSize = drinkSize;
        this.DrinkPrice = price;
    }

    @Override
    public double getPrice() {
        if (DrinkSize.SMALL == drinkSize){
            DrinkPrice = 2.00;
        }if (DrinkSize.MEDIUM == drinkSize){
            DrinkPrice = 2.5;
        }
        if (DrinkSize.LARGE == drinkSize){
            DrinkPrice = 3.00;
        }

        return DrinkPrice;
    }
}

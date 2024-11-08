public class Drink implements Priceable{
    protected DrinkSize drinkSize;
    protected double DrinkPrice;
    protected DrinkType drinkType;

    public Drink(DrinkType drinkType, DrinkSize drinkSize) {
        this.drinkType = drinkType;
        this.drinkSize = drinkSize;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    public DrinkType getDrinkType() {
        return drinkType;
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

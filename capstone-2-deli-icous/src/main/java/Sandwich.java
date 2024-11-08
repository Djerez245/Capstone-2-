import java.util.ArrayList;

public class Sandwich implements Priceable{
    protected BreadType breadType;
    protected BreadSize sandwichSize;
    protected ArrayList<Topping> topping;
    protected boolean isToasted;
    protected double sandwichPrice;
    protected ToppingType toppingType;

    public Sandwich(BreadType breadType, BreadSize sandwichSize, ArrayList<Topping> topping, boolean isToasted) {
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
        this.topping = topping;
        this.isToasted = isToasted;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public BreadSize getSandwichSize() {
        return sandwichSize;
    }

    public ArrayList<Topping> getTopping() {
        return topping;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public double getSandwichPrice() {
        return sandwichPrice;
    }

    @Override
    public double getPrice() {
        if (BreadSize.SMALL == sandwichSize){
            sandwichPrice = 5.5;
            }
        if (BreadSize.MEDIUM == sandwichSize){
            sandwichPrice = 7.00;
        }
        if (BreadSize.LARGE == sandwichSize){
            sandwichPrice = 8.5;
        }
        return sandwichPrice;
    }

    public void addTopping(Topping toppings){
        topping.add(toppings);
    }
}

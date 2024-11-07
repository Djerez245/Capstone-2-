import java.util.ArrayList;

public class Sandwich implements Priceable{
    protected Bread bread;
    protected BreadSize sandwichSize;
    protected ArrayList<Topping> topping;
    protected boolean isToasted;
    protected double sandwichPrice;

    public Sandwich(Bread bread, BreadSize sandwichSize, boolean isToasted) {
        this.bread = bread;
        this.sandwichSize = sandwichSize;
        this.topping = new ArrayList<>();
        this.isToasted = isToasted;
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
}

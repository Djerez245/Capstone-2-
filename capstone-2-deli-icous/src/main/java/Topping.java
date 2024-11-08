public abstract class Topping {
    ToppingType toppingType;

    public Topping(ToppingType toppingType) {
        this.toppingType = toppingType;
    }

    public ToppingType getToppingType() {
        return toppingType;
    }
}

public class Chips implements Priceable {
    private double price;

    public Chips(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        price = 1.50;
        return price;
    }
}

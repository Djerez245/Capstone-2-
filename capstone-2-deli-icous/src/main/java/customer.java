public class customer extends Deli{
    protected String customerName;

    public customer(double price, String customerName) {
        super(price);
        this.customerName = customerName;
    }
}

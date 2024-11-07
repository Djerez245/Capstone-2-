import java.util.ArrayList;

public class Customer {
    protected String customerName;
    protected ArrayList<Order> orders;

    public Customer(String customerName, ArrayList<Order> orders) {
        this.customerName = customerName;
        this.orders = orders;
    }

    public void addOrder(Order order){
        orders.add(order);
    }
}

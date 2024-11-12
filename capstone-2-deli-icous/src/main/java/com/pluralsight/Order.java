package com.pluralsight;

import java.util.ArrayList;

public class Order implements Priceable{

    protected ArrayList<Sandwich> sandwiches;
    protected ArrayList<Drink> drinks;
    protected ArrayList<Chips> chips;
    protected ArrayList<Order> orders;
    private double price;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.price = 0.0;
    }

    @Override
    public double getPrice() {
        for (Drink drink : drinks){
            price += drink.getPrice();
        }
        for (Sandwich s: sandwiches){
            price += s.getPrice();
        }
        for (Chips c : chips){
            price += c.getPrice();
        }
        return price;
    }

    public void addSandwich(Sandwich sandwich){
       sandwiches.add(sandwich);
    }
    public void addDrink(Drink drink){
        drinks.add(drink);
    }
    public void addChip(Chips chip){
        chips.add(chip);
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public void removeOrder(Order order){
        orders.clear();
    }


    public String toStringForCsv(){
       return "%s\n";
    }
}

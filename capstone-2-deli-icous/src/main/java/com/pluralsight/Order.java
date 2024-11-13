package com.pluralsight;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Order implements Priceable{

    Sandwich sandwich;
    Chips chip;
    Drink drink;

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
    public void addOrder(Order order){orders.add(order);
    }
    public void removeOrder(Order order){
        orders.clear();
    }

    public String toStringForCsv() {
        // Used Streams to print out ArrayList
        String sandwichesStream = sandwiches.stream().map(Sandwich::toString).collect(Collectors.joining(","));
        String sandwichPricesStream = sandwiches.stream().map(sandwich -> String.valueOf(sandwich.getPrice())).collect(Collectors.joining(","));
        String chipsStream = chips.stream().map(Chips::toString).collect(Collectors.joining(","));
        String chipsPricesStream = chips.stream().map(chips -> String.valueOf(chip.getPrice())).collect(Collectors.joining(","));
        String drinksStream = drinks.stream().map(Drink::toString).collect(Collectors.joining(","));
        String drinkPricesStream = drinks.stream().map(drinks -> String.valueOf(drink.getPrice())).collect(Collectors.joining(","));

        return String.format("%s:   %s\n%s  %s\n%s:  %s", sandwichesStream, sandwichPricesStream, chipsStream, chipsPricesStream, drinksStream, drinkPricesStream);
    }

}

package com.pluralsight;

import com.pluralsight.interfaces.Item;
import com.pluralsight.interfaces.Priceable;

import java.util.ArrayList;

public class Order implements Priceable {

    protected ArrayList<Item> items;
    private double price;

    public Order() {
        this.items = new ArrayList<>();
    }

    @Override
    public double getPrice() {
        for (Item orderItem : items) {
            price += orderItem.getPrice();
        }
        return price;
    }

    public void addItem(Item item){
        items.add(item);
    }
    public void removeOrder(Order order){
        items.clear();
    }


}

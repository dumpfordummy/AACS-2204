package com.example.javafx_login.classes;

import java.util.HashMap;
import java.util.Map;

public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(){
        quantity++;
    }

    public void subQuantity(){
        quantity--;
    }
}

package com.example.javafx_login.classes;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private static List<Item> cart = new ArrayList<>();

    public ShoppingCart(Item item) {
        cart.add(item);
    }

    public static List<Item> getCart() {
        return cart;
    }

    public static void setCart(List<Item> cart) {
        ShoppingCart.cart = cart;
    }

    public static void addToCart(Item items) {
        cart.add(items);
    }


    public List<Item> getItem() {
        return cart;
    }

    public void setItem(Item item) {
        cart.add(item);
    }
}

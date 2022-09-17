package com.example.javafx_login.classes;

import java.util.ArrayList;

public class ShoppingCart {
    private static ArrayList<Item> cart = new ArrayList<>();

    private ShoppingCart() {
    }

    public static ArrayList<Item> getCart() {
        return cart;
    }

    public static void setCart(ArrayList<Item> cart) {
        ShoppingCart.cart = cart;
    }

    public static void addToCart(Item items) {
        cart.add(items);
    }

    public static void popCart(int index) {
        cart.remove(index);
    }
}

package com.example.javafx_login.classes;

import java.util.ArrayList;

public class ShoppingCart {
    private static ArrayList<Item> itemList = new ArrayList<>();

    private ShoppingCart() {
    }

    public static ArrayList<Item> getItemList() {
        return itemList;
    }

    public static void setItemList(ArrayList<Item> cart) {
        ShoppingCart.itemList = cart;
    }

    public static void addItemList(Item items) {
        itemList.add(items);
    }

    public static void removeItemAtIndex(int index) {
        itemList.remove(index);
    }
}

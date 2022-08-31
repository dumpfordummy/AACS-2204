package com.example.javafx_login.classes;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    static List<Item> itemList = new ArrayList<>();

    public ShoppingCart(Item item) {
        itemList.add(item);
    }

    public List<Item> getItem() {
        return itemList;
    }

    public void setItem(Item item) {
        itemList.add(item);
    }
}

package com.example.javafx_login.classes;

public class Item {
    private int quantity;
    private String barCode;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void addQuantity(){
        quantity++;
    }

    public void subQuantity(){
        quantity--;
    }
}

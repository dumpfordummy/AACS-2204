package com.example.javafx_login.classes;

public class Payment {
    private String voucherCode;
    private double paymentFromUser;
    private double subtotal;

    public Payment(String voucherCode, double paymentFromUser, double subtotal) {
        this.voucherCode = voucherCode;
        this.paymentFromUser = paymentFromUser;
        this.subtotal = subtotal;
    }
}

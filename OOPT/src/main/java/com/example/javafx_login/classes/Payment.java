package com.example.javafx_login.classes;

public class Payment {
    private String voucherCode;
    private double paymentFromUser;
    private double subtotal;
    private double discountAmount;

    public Payment(String voucherCode, double paymentFromUser, double subtotal, double discountAmount) {
        this.voucherCode = voucherCode;
        this.paymentFromUser = paymentFromUser;
        this.subtotal = subtotal;
        this.discountAmount = discountAmount;
    }
}

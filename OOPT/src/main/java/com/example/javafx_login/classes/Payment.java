package com.example.javafx_login.classes;

public class Payment {
    private String voucherCode;
    private double discountAmount;
    private double paymentFromUser;
    private double subtotal;
    public Payment(String voucherCode, double discountAmount, double paymentFromUser, double subtotal) {
        this.voucherCode = voucherCode;
        this.discountAmount = discountAmount;
        this.paymentFromUser = paymentFromUser;
        this.subtotal = subtotal;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getPaymentFromUser() {
        return paymentFromUser;
    }

    public void setPaymentFromUser(double paymentFromUser) {
        this.paymentFromUser = paymentFromUser;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}

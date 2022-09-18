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

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
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

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }
}

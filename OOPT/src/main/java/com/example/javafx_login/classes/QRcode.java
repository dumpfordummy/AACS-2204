package com.example.javafx_login.classes;

public class QRcode extends Payment{
    public QRcode(String voucherCode, double paymentFromUser, double subtotal, double discountAmount) {
        super(voucherCode, paymentFromUser, subtotal, discountAmount);
    }
}

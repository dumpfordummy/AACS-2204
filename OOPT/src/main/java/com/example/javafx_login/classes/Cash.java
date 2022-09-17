package com.example.javafx_login.classes;

public class Cash extends Payment{
    private int changeRM100Qty;
    private int changeRM50Qty;
    private int changeRM20Qty;
    private int changeRM10Qty;
    private int changeRM5Qty;
    private int changeRM1Qty;
    private int change50SenQty;
    private int change20SenQty;
    private int change10SenQty;
    private int change5SenQty;
    private double totalChangeRM100;
    private double totalChangeRM50;
    private double totalChangeRM20;
    private double totalChangeRM10;
    private double totalChangeRM5;
    private double totalChangeRM1;
    private double totalChange50Sen;
    private double totalChange20Sen;
    private double totalChange10Sen;
    private double totalChange5Sen;
    private double totalChange;

    public Cash(String voucherCode, double paymentFromUser, double subtotal) {
        super(voucherCode, paymentFromUser, subtotal);
    }
}

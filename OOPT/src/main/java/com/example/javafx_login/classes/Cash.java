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

    public Cash(String voucherCode, double paymentFromUser, double subtotal, double discountAmount) {
        super(voucherCode, paymentFromUser, subtotal, discountAmount);
        calculateChange(paymentFromUser, subtotal, discountAmount);
    }

    public void calculateChange(double paymentFromUser, double subtotal, double discountAmount){
        totalChange = paymentFromUser + discountAmount - subtotal;
        if (totalChange/100 >= 1){
            do {
                totalChange -= 100;
                changeRM100Qty++;
                totalChangeRM100 += 100;
            }while (totalChange/100 >= 1);
        }

        if (totalChange/50 >= 1){
            do {
                totalChange -= 50;
                changeRM50Qty++;
                totalChangeRM50 += 50;
            }while (totalChange/50 >= 1);
        }

        if (totalChange/20 >= 1){
            do {
                totalChange -= 20;
                changeRM20Qty++;
                totalChangeRM20 += 200;
            }while (totalChange/20 >= 1);
        }

        if (totalChange/10 >= 1){
            do {
                totalChange -= 10;
                changeRM10Qty++;
                totalChangeRM10 += 10;
            }while (totalChange/10 >= 1);
        }

        if (totalChange/5 >= 1){
            do {
                totalChange -= 5;
                changeRM5Qty++;
                totalChangeRM5 += 5;
            }while (totalChange/5 >= 1);
        }

        if (totalChange >= 1){
            do {
                totalChange -= 1;
                changeRM1Qty++;
                totalChangeRM1 += 1;
            }while (totalChange >= 1);
        }

        if (totalChange/0.5 >= 1){
            do {
                totalChange -= 0.5;
                change50SenQty++;
                totalChange50Sen += 0.5;
            }while (totalChange/0.5 >= 1);
        }

        if (totalChange/0.2 >= 1){
            do {
                totalChange -= 0.2;
                change20SenQty++;
                totalChange20Sen += 0.2;
            }while (totalChange/0.2 >= 1);
        }

        if (totalChange/0.1 >= 1){
            do {
                totalChange -= 0.1;
                change10SenQty++;
                totalChange10Sen += 0.1;
            }while (totalChange/0.1 >= 1);
        }

        if (totalChange/0.05 >= 1){
            do {
                totalChange -= 0.05;
                change5SenQty++;
                totalChange5Sen += 0.05;
            }while (totalChange/0.05 >= 1);
        }
    }

    public int getChangeRM100Qty() {
        return changeRM100Qty;
    }

    public void setChangeRM100Qty(int changeRM100Qty) {
        this.changeRM100Qty = changeRM100Qty;
    }

    public int getChangeRM50Qty() {
        return changeRM50Qty;
    }

    public void setChangeRM50Qty(int changeRM50Qty) {
        this.changeRM50Qty = changeRM50Qty;
    }

    public int getChangeRM20Qty() {
        return changeRM20Qty;
    }

    public void setChangeRM20Qty(int changeRM20Qty) {
        this.changeRM20Qty = changeRM20Qty;
    }

    public int getChangeRM10Qty() {
        return changeRM10Qty;
    }

    public void setChangeRM10Qty(int changeRM10Qty) {
        this.changeRM10Qty = changeRM10Qty;
    }

    public int getChangeRM5Qty() {
        return changeRM5Qty;
    }

    public void setChangeRM5Qty(int changeRM5Qty) {
        this.changeRM5Qty = changeRM5Qty;
    }

    public int getChangeRM1Qty() {
        return changeRM1Qty;
    }

    public void setChangeRM1Qty(int changeRM1Qty) {
        this.changeRM1Qty = changeRM1Qty;
    }

    public int getChange50SenQty() {
        return change50SenQty;
    }

    public void setChange50SenQty(int change50SenQty) {
        this.change50SenQty = change50SenQty;
    }

    public int getChange20SenQty() {
        return change20SenQty;
    }

    public void setChange20SenQty(int change20SenQty) {
        this.change20SenQty = change20SenQty;
    }

    public int getChange10SenQty() {
        return change10SenQty;
    }

    public void setChange10SenQty(int change10SenQty) {
        this.change10SenQty = change10SenQty;
    }

    public int getChange5SenQty() {
        return change5SenQty;
    }

    public void setChange5SenQty(int change5SenQty) {
        this.change5SenQty = change5SenQty;
    }

    public double getTotalChangeRM100() {
        return totalChangeRM100;
    }

    public void setTotalChangeRM100(double totalChangeRM100) {
        this.totalChangeRM100 = totalChangeRM100;
    }

    public double getTotalChangeRM50() {
        return totalChangeRM50;
    }

    public void setTotalChangeRM50(double totalChangeRM50) {
        this.totalChangeRM50 = totalChangeRM50;
    }

    public double getTotalChangeRM20() {
        return totalChangeRM20;
    }

    public void setTotalChangeRM20(double totalChangeRM20) {
        this.totalChangeRM20 = totalChangeRM20;
    }

    public double getTotalChangeRM10() {
        return totalChangeRM10;
    }

    public void setTotalChangeRM10(double totalChangeRM10) {
        this.totalChangeRM10 = totalChangeRM10;
    }

    public double getTotalChangeRM5() {
        return totalChangeRM5;
    }

    public void setTotalChangeRM5(double totalChangeRM5) {
        this.totalChangeRM5 = totalChangeRM5;
    }

    public double getTotalChangeRM1() {
        return totalChangeRM1;
    }

    public void setTotalChangeRM1(double totalChangeRM1) {
        this.totalChangeRM1 = totalChangeRM1;
    }

    public double getTotalChange50Sen() {
        return totalChange50Sen;
    }

    public void setTotalChange50Sen(double totalChange50Sen) {
        this.totalChange50Sen = totalChange50Sen;
    }

    public double getTotalChange20Sen() {
        return totalChange20Sen;
    }

    public void setTotalChange20Sen(double totalChange20Sen) {
        this.totalChange20Sen = totalChange20Sen;
    }

    public double getTotalChange10Sen() {
        return totalChange10Sen;
    }

    public void setTotalChange10Sen(double totalChange10Sen) {
        this.totalChange10Sen = totalChange10Sen;
    }

    public double getTotalChange5Sen() {
        return totalChange5Sen;
    }

    public void setTotalChange5Sen(double totalChange5Sen) {
        this.totalChange5Sen = totalChange5Sen;
    }

    public double getTotalChange() {
        return totalChange;
    }

    public void setTotalChange(double totalChange) {
        this.totalChange = totalChange;
    }
}

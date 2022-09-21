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
    private int change1SenQty;
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
    private double totalChange1Sen;
    private double totalChangeLeft;

    public Cash(String voucherCode, double paymentFromUser, double subtotal, double discountAmount) {
        super(voucherCode, paymentFromUser, subtotal, discountAmount);
        calculateChange(paymentFromUser, subtotal, discountAmount);
    }

    public void calculateChange(double paymentFromUser, double subtotal, double discountAmount){
        totalChangeLeft = paymentFromUser + discountAmount - subtotal;
        if (totalChangeLeft / 100 >= 1){
            changeRM100Qty = (int) (totalChangeLeft / 100);
            totalChangeRM100 = changeRM100Qty * 100;
            totalChangeLeft -= totalChangeRM100;
        }

        if (totalChangeLeft / 50 >= 1){
            changeRM50Qty = (int) (totalChangeLeft / 50);
            totalChangeRM50 = changeRM50Qty * 50;
            totalChangeLeft -= totalChangeRM50;
        }

        if (totalChangeLeft / 20 >= 1){
            changeRM20Qty = (int) (totalChangeLeft / 20);
            totalChangeRM20 = changeRM20Qty * 20;
            totalChangeLeft -= totalChangeRM20;
        }

        if (totalChangeLeft / 10 >= 1){
            changeRM10Qty = (int) (totalChangeLeft / 10);
            totalChangeRM10 = changeRM10Qty * 10;
            totalChangeLeft -= totalChangeRM10;
        }

        if (totalChangeLeft / 5 >= 1){
            changeRM5Qty = (int) (totalChangeLeft / 5);
            totalChangeRM5 = changeRM5Qty * 5;
            totalChangeLeft -= totalChangeRM5;
        }

        if (totalChangeLeft >= 1){
            changeRM1Qty = (int) totalChangeLeft;
            totalChangeRM1 = changeRM1Qty;
            totalChangeLeft -= totalChangeRM1;
        }

        if (totalChangeLeft / 0.5 >= 1){
            change50SenQty = (int) (totalChangeLeft / 0.5);
            totalChange50Sen = change50SenQty * 0.5;
            totalChangeLeft -= totalChange50Sen;
        }

        if (totalChangeLeft / 0.2 >= 1){
            change20SenQty = (int) (totalChangeLeft / 0.2);
            totalChange20Sen = change20SenQty * 0.2;
            totalChangeLeft -= totalChange20Sen;
        }

        if (totalChangeLeft / 0.1 >= 1){
            change10SenQty = (int) (totalChangeLeft / 0.1);
            totalChange10Sen = change10SenQty * 0.1;
            totalChangeLeft -= totalChange10Sen;
        }

        if (totalChangeLeft / 0.05 >= 1){
            change5SenQty = (int) (totalChangeLeft / 0.05);
            totalChange5Sen = change5SenQty * 0.05;
            totalChangeLeft -= totalChange5Sen;
        }

        totalChangeLeft = Math.round(totalChangeLeft * 100)/100.00;
        if (totalChangeLeft /0.01 >= 1){
            change1SenQty = (int) (totalChangeLeft /0.01);
            totalChange1Sen = change1SenQty * 0.01;
            totalChangeLeft -= totalChange1Sen;
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

    public int getChange1SenQty() {
        return change1SenQty;
    }

    public void setChange1SenQty(int change1SenQty) {
        this.change1SenQty = change1SenQty;
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
    public double getTotalChange1Sen() {
        return totalChange1Sen;
    }

    public void setTotalChange1Sen(double totalChange1Sen) {
        this.totalChange1Sen = totalChange1Sen;
    }

    public double getTotalChangeLeft() {
        return totalChangeLeft;
    }

    public void setTotalChangeLeft(double totalChangeLeft) {
        this.totalChangeLeft = totalChangeLeft;
    }

    public static boolean isPaymentAmountFormatInvalid(String paymentAmount){
        int countDecimalPoint = 0;
        int countDecimalPlace = 0;
        for(int i = 0; i < paymentAmount.length(); i++){
            if (countDecimalPoint == 1){
                countDecimalPlace++;
            }
            if (paymentAmount.charAt(i) == '.'){
                countDecimalPoint++;
            }
            if (paymentAmount.charAt(i) != '0' && paymentAmount.charAt(i) != '1' && paymentAmount.charAt(i) != '2' && paymentAmount.charAt(i) != '3' && paymentAmount.charAt(i) != '4' && paymentAmount.charAt(i) != '5' && paymentAmount.charAt(i) != '6' && paymentAmount.charAt(i) != '7' && paymentAmount.charAt(i) != '8' && paymentAmount.charAt(i) != '9' && paymentAmount.charAt(i) != '.'){
                return true;
            }
        }

        if (countDecimalPoint != 0 && countDecimalPoint != 1){
            return true;
        }

        if (countDecimalPoint == 1 && countDecimalPlace != 2){
            return true;
        }

        return false;
    }
}

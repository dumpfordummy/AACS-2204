package com.example.javafx_login.classes;

import java.util.HashMap;

public class Cash extends Payment{
    private HashMap<String, Integer> changeQty = new HashMap<>();
    private HashMap<String, Double> totalChange = new HashMap<>();
    private static double[] typeOfCash = new double[]{100, 50, 20, 10, 5, 1, 0.5, 0.2, 0.1, 0.05, 0.01};

    public HashMap<String, Integer> getChangeQty() {
        return changeQty;
    }

    public void setChangeQty(HashMap<String, Integer> changeQty) {
        this.changeQty = changeQty;
    }

    public HashMap<String, Double> getTotalChange() {
        return totalChange;
    }

    public void setTotalChange(HashMap<String, Double> totalChange) {
        this.totalChange = totalChange;
    }

    public static double[] getTypeOfCash() {
        return typeOfCash;
    }

    public static void setTypeOfCash(double[] typeOfCash) {
        Cash.typeOfCash = typeOfCash;
    }

    public Cash(String voucherCode, double discountAmount, double paymentFromUser, double subtotal) {
        super(voucherCode, discountAmount, paymentFromUser, subtotal);
        calculateChange(discountAmount, paymentFromUser, subtotal);
    }

    public void calculateChange(double discountAmount, double paymentFromUser, double subtotal){
        double totalChangeLeft = paymentFromUser + discountAmount - subtotal;

        for (double cash : typeOfCash) {
            changeQty.put("RM" + cash, (int) (totalChangeLeft / cash));
            totalChange.put("RM" + cash, changeQty.get("RM" + cash) * cash);
            totalChangeLeft -= totalChange.get("RM" + cash);
            totalChangeLeft = Math.round(totalChangeLeft * 100) / 100.0; //Prevent Floating Point Precision
        }
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

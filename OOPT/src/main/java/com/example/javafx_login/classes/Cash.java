package com.example.javafx_login.classes;

import java.util.HashMap;

public class Cash extends Payment{
    private HashMap<String, Integer> changeQty = new HashMap<>();
    private HashMap<String, Double> totalChange = new HashMap<>();
    private static double[] typeOfCash = new double[]{100, 50, 20, 10, 5, 1, 0.5, 0.2, 0.1, 0.05, 0.01};


    public static double[] getTypeOfCash() {
        return typeOfCash;
    }

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

    public static void setTypeOfCash(double[] typeOfCash) {
        Cash.typeOfCash = typeOfCash;
    }

    public Cash(String voucherCode, double paymentFromUser, double subtotal, double discountAmount) {
        super(voucherCode, paymentFromUser, subtotal, discountAmount);
        calculateChange(paymentFromUser, subtotal, discountAmount);
    }

    public void calculateChange(double paymentFromUser, double subtotal, double discountAmount){
        double totalChangeLeft = paymentFromUser + discountAmount - subtotal;

        for (int i = 0; i < typeOfCash.length; i++){
            changeQty.put("RM" + typeOfCash[i], (int) (totalChangeLeft / typeOfCash[i]));
            totalChange.put("RM" + typeOfCash[i], changeQty.get("RM" + typeOfCash[i]) * typeOfCash[i]);
            totalChangeLeft -= totalChange.get("RM" + typeOfCash[i]);
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

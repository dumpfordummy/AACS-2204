package com.example.javafx_login.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Purchase {
    private static List<Payment> paymentList = new ArrayList<>();
    private static String[] voucherCodes = {"(Please Choose)", "RM5VOUCHER", "RM10VOUCHER", "RM20VOUCHER"};
    private static double[] voucherCodeDiscounts = {0, 5, 10, 20};
    private static String[] paymentMethods = {"(Please Choose)", "Cash", "Card", "QR Code"};

    public static List<Payment> getPaymentList() {
        return paymentList;
    }

    public static void setPaymentList(List<Payment> paymentList) {
        Purchase.paymentList = paymentList;
    }

    public static String[] getVoucherCodes() {
        return voucherCodes;
    }

    public static void setVoucherCodes(String[] voucherCodes) {
        Purchase.voucherCodes = voucherCodes;
    }

    public static double[] getVoucherCodeDiscounts() {
        return voucherCodeDiscounts;
    }

    public static void setVoucherCodeDiscounts(double[] voucherCodeDiscounts) {
        Purchase.voucherCodeDiscounts = voucherCodeDiscounts;
    }

    public static String[] getPaymentMethods() {
        return paymentMethods;
    }

    public static void setPaymentMethods(String[] paymentMethods) {
        Purchase.paymentMethods = paymentMethods;
    }

    public static void makePayment(String voucherCode, double discountAmount, String paymentMethod, double paymentFromUser, double subtotal, String cardNum) {
        if (Objects.equals(paymentMethod, "Cash")){
            paymentList.add(new Cash(voucherCode, discountAmount, paymentFromUser, subtotal));
        }
        else if (Objects.equals(paymentMethod, "Card")){
            paymentList.add(new Card(voucherCode, discountAmount, paymentFromUser, subtotal, cardNum));
        }
        else if (Objects.equals(paymentMethod, "QR Code")){
            paymentList.add(new QRCode(voucherCode, discountAmount, paymentFromUser, subtotal));
        }
        else
            return;
    }
    public static Cash getCashPayment(){
        return (Cash) paymentList.get(paymentList.size() - 1);
    }
    public static Card getCardPayment(){
        return (Card) paymentList.get(paymentList.size() - 1);
    }
    public static QRCode getQRCodePayment(){
        return (QRCode) paymentList.get(paymentList.size() - 1);
    }
}

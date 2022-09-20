package com.example.javafx_login.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Purchase {
    private static List<Payment> paymentList = new ArrayList<>();
    private static String[] paymentMethods = {"(Please Choose)", "Cash", "Card", "QR Code"};

    public static String[] getPaymentMethods() {
        return paymentMethods;
    }

    public static void setPaymentMethods(String[] paymentMethods) {
        Purchase.paymentMethods = paymentMethods;
    }

    private static String[] voucherCodes = {"(Please Choose)", "RM5VOUCHER", "RM10VOUCHER", "RM20VOUCHER"};

    public static String[] getVoucherCodes() {
        return voucherCodes;
    }

    public static void setVoucherCodes(String[] voucherCodes) {
        Purchase.voucherCodes = voucherCodes;
    }

    public Purchase() {

    }

    public static List<Payment> getPaymentList() {
        return paymentList;
    }

    public static void setPaymentList(List<Payment> paymentList) {
        Purchase.paymentList = paymentList;
    }

    public static void makePayment(String voucherCode, String paymentMethod, double paymentFromUser, double subtotal, double discountAmount) {
        if (Objects.equals(paymentMethod, "Cash")){
            paymentList.add(new Cash(voucherCode, paymentFromUser, subtotal, discountAmount));
        }
        else if (Objects.equals(paymentMethod, "Card")){
            paymentList.add(new Card(voucherCode, paymentFromUser, subtotal, discountAmount));
        }
        else if (Objects.equals(paymentMethod, "QR Code")){
            paymentList.add(new QRcode(voucherCode, paymentFromUser, subtotal, discountAmount));
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

    public static QRcode getQRCodePayment(){
        return (QRcode) paymentList.get(paymentList.size() - 1);
    }
}

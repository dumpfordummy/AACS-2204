package com.example.javafx_login.classes;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private static List<Payment> paymentList = new ArrayList<>();

    public Purchase() {

    }

    public static List<Payment> getPaymentList() {
        return paymentList;
    }

    public static void setPaymentList(List<Payment> paymentList) {
        Purchase.paymentList = paymentList;
    }

    public static void makePayment(String voucherCode, String paymentMethod, double paymentFromUser, double subtotal) {
        if (paymentMethod == "Cash"){
            paymentList.add(new Cash(voucherCode, paymentFromUser, subtotal));
        }
        else if (paymentMethod == "Card"){
            paymentList.add(new Card(voucherCode, paymentFromUser, subtotal));
        }
        else if (paymentMethod == "QR Code"){
            paymentList.add(new QRcode(voucherCode, paymentFromUser, subtotal));
        }

    }
}

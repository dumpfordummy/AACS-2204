package com.example.javafx_login.classes;

import com.example.javafx_login.api.LoginApi;

public class QRCode extends Payment{
    public QRCode(String voucherCode, double discountAmount, double paymentFromUser, double subtotal) {
        super(voucherCode, discountAmount, paymentFromUser, subtotal);
    }

    public static void resetIsQrScanned(){
        LoginApi.setIsQRScanned(false);
    }

    public static boolean getIsQrScanned(){
        return LoginApi.getIsQRScanned();
    }

}

package com.example.javafx_login.classes;

public class Card extends Payment{
    private String cardNum;
    private static boolean isCardInserted = false;
    public Card(String voucherCode, double discountAmount, double paymentFromUser, double subtotal, String cardNum) {
        super(voucherCode, discountAmount, paymentFromUser, subtotal);
        this.cardNum = cardNum;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public static boolean getIsCardInserted() {
        return isCardInserted;
    }

    public static void setIsCardInserted(boolean isCardInserted) {
        Card.isCardInserted = isCardInserted;
    }

    public static boolean isCardNumFormatInvalid(String cardNum){
        if (cardNum.length() != 8){
            return true;
        }
        for(int i = 0; i < cardNum.length(); i++){
            if (cardNum.charAt(i) != '0' && cardNum.charAt(i) != '1' && cardNum.charAt(i) != '2' && cardNum.charAt(i) != '3' && cardNum.charAt(i) != '4' && cardNum.charAt(i) != '5' && cardNum.charAt(i) != '6' && cardNum.charAt(i) != '7' && cardNum.charAt(i) != '8' && cardNum.charAt(i) != '9'){
                return true;
            }
        }
        return false;
    }

    public static boolean isCardPINFormatInvalid(String cardPIN){
        if (cardPIN.length() != 6){
            return true;
        }
        for(int i = 0; i < cardPIN.length(); i++){
            if (cardPIN.charAt(i) != '0' && cardPIN.charAt(i) != '1' && cardPIN.charAt(i) != '2' && cardPIN.charAt(i) != '3' && cardPIN.charAt(i) != '4' && cardPIN.charAt(i) != '5' && cardPIN.charAt(i) != '6' && cardPIN.charAt(i) != '7' && cardPIN.charAt(i) != '8' && cardPIN.charAt(i) != '9'){
                return true;
            }
        }
        return false;
    }

}

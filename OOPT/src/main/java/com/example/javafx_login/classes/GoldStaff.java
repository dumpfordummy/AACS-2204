package com.example.javafx_login.classes;

public class GoldStaff extends SalesPerson{
    public GoldStaff(String name, String loginPassword, int ID, double grossSale, int getItemSold) {
        super(name, loginPassword, ID, grossSale, getItemSold);
        setBasicSalary(2500);
        setCommissionRate(0.15);
        setBonus(getItemSold() * 15);
        setTotalPay(getBasicSalary() + getBonus() + (getGrossSale() * getCommissionRate()));
    }


}
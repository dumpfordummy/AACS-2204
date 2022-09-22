package com.example.javafx_login.classes;

public class SilverStaff extends SalesPerson {
    public SilverStaff(String name, String loginPassword, int ID, double grossSale, int getItemSold) {
        super(name, loginPassword, ID, grossSale, getItemSold);
        setBasicSalary(1800);
        setCommissionRate(0.1);
        setBonus(getItemSold() * 10);
        setTotalPay(getBasicSalary() + getBonus() + (getGrossSale() * getCommissionRate()));
    }


}

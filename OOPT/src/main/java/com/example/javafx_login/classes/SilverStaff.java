package com.example.javafx_login.classes;

public class SilverStaff extends SalesPerson {
    public SilverStaff(String name, String loginPassword, int ID, double grossSale, int getItemSold,double bonus) {
        super(name, loginPassword, ID, grossSale, getItemSold);
        setBasicSalary(1800);
        setCommissionRate(0.05);
        setBonus(10);
        setBonus(getItemSold() * getBonus());
        setTotalPay(getBasicSalary() + getBonus() + (getGrossSale() * getCommissionRate()));
    }


}

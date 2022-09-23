package com.example.javafx_login.classes;

public class GoldStaff extends SalesPerson{
    public GoldStaff(String name, String loginPassword, int ID, double grossSale, int getItemSold,double bonus) {
        super(name, loginPassword, ID, grossSale, getItemSold);
        setBasicSalary(2500);
        setCommissionRate(0.10);
        setBonus(15);
        setBonus(getItemSold() * getBonus());
        setTotalPay(getBasicSalary() + getBonus() + (getGrossSale() * getCommissionRate()));
    }


}
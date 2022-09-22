package com.example.javafx_login.classes;

public class SilverStaff extends SalesPerson {
    public SilverStaff(String name, String loginPassword, String userType, int ID, double basicSalary, double grossSale, double commissionRate, double bonus) {
        super(name, loginPassword, userType, ID, basicSalary, grossSale, commissionRate, bonus);
        setBasicSalary(1800);
        setCommissionRate(0.1);
        setBonus(getItemSold() * 20);
        setTotalPay(getBasicSalary() + getBonus() + (getGrossSale() * getCommissionRate()));
    }
}

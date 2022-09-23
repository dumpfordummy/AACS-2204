package com.example.javafx_login.classes;
import com.example.javafx_login.controller.MainController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SalesPerson {
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    private String loginUserName = "PuaJJ", loginPassword;
    private int ID=2108105, itemSold=0;
    private double basicSalary, grossSale, commissionRate, bonus, totalPay;

    public SalesPerson(String name, String loginPassword, int ID, double grossSale, int itemSold) {
        this.loginUserName = name;
        this.loginPassword = loginPassword;
        this.ID = ID;
        this.grossSale = grossSale;
        this.itemSold = itemSold;
    }
    public SalesPerson(){}
    //getter and setter start
    public String getLoginUserName() {
        return loginUserName;
    }
    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName;
    }
    public String getLoginPassword() {
        return loginPassword;
    }
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public double getBasicSalary() {
        return basicSalary;
    }
    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }
    public double getGrossSale() {
        return grossSale;
    }
    public void setGrossSale(double grossSale) {
        this.grossSale = grossSale;
    }
    public double getCommissionRate() {
        return commissionRate;
    }
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public int getItemSold() {
        return itemSold;
    }

    public void setItemSold(int itemSold) {
        this.itemSold = itemSold;
    }

    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }
    //getter and setter end

    public String paySlipString() {
        return "Date and time: "+ timeFormat.format(now)+
                "\n\nBasic Salary: RM " + getBasicSalary() +
                "\nCommission Earned: RM " + getCommissionRate() * getGrossSale() +
                "\nBonus Earned: RM " + getBonus()+
                "\n\nTotal Pay: RM "+ getTotalPay();
    }
}
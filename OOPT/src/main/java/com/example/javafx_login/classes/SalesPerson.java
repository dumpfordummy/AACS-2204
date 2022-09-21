package com.example.javafx_login.classes;
import com.example.javafx_login.controller.MainController;

import java.util.ArrayList;
import java.util.List;

public class SalesPerson {
    //poly for staff type
    private static String loginUserName = "PuaJJ", loginPassword, userType="Bronze";
    private static int ID=2108105, itemSold=0;
    private static double basicSalary, grossSale, commissionRate;

    public SalesPerson(String name, String loginPassword, String userType, int ID, double basicSalary, double grossSale, double commissionRate) {
        this.loginUserName = name;
        this.loginPassword = loginPassword;
        this.ID = ID;
        this.userType=userType;
        this.basicSalary=basicSalary;
        this.grossSale=grossSale;
        this.commissionRate=commissionRate;
    }
    public SalesPerson(){}
    //getter and setter start
    public static String getLoginUserName() {
        return loginUserName;
    }
    public static void setLoginUserName(String loginUserName) {
        SalesPerson.loginUserName = loginUserName;
    }
    public static String getLoginPassword() {
        return loginPassword;
    }
    public static void setLoginPassword(String loginPassword) {
        SalesPerson.loginPassword = loginPassword;
    }
    public static int getID() {
        return ID;
    }
    public static void setID(int ID) {
        SalesPerson.ID = ID;
    }
    public static String getUserType() {
        return userType;
    }
    public static void setUserType(String userType) {
        SalesPerson.userType = userType;
    }
    public static double getBasicSalary() {
        return basicSalary;
    }
    public static void setBasicSalary(double basicSalary) {
        SalesPerson.basicSalary = basicSalary;
    }
    public static double getGrossSale() {
        return grossSale;
    }
    public static void setGrossSale(double grossSale) {
        SalesPerson.grossSale = grossSale;
    }
    public static double getCommissionRate() {
        return commissionRate;
    }
    public static void setCommissionRate(double commissionRate) {
        SalesPerson.commissionRate = commissionRate;
    }

    public static int getItemSold() {
        return itemSold;
    }

    public static void setItemSold(int itemSold) {
        SalesPerson.itemSold = itemSold;
    }

//getter and setter end

}
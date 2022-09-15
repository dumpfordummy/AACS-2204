package com.example.javafx_login.classes;
import java.util.ArrayList;
import java.util.List;

public class SalesPerson {
    //use point collected to determine role

    private static List<Item> totalSold = new ArrayList<>();
    private static String loginUserName = "PuaJJ", loginPassword;
    private static int ID=2108105, yearJoined=2018;
    private static double basicSalary, grossSale, commissionRate;

    public SalesPerson(String name, String loginPassword, int ID, int yearJoined,double basicSalary, double grossSale, double commissionRate) {
        this.loginUserName = name;
        this.loginPassword = loginPassword;
        this.ID = ID;
        this.yearJoined=yearJoined;
        this.basicSalary=basicSalary;
        this.grossSale=grossSale;
        this.commissionRate=commissionRate;
    }
    //getter and setter start

    public static List<Item> getTotalSold() {
        return totalSold;
    }

    public static void setTotalSold(List<Item> totalSold) {
        SalesPerson.totalSold = totalSold;
    }

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
    public static int getYearJoined() {
        return yearJoined;
    }
    public static void setYearJoined(int yearJoined) {
        SalesPerson.yearJoined = yearJoined;
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
    //getter and setter end

    public String toString(){
        return "Staff Name: "+getLoginUserName()+
                "Staff Since: "+getYearJoined()+
                "Basic Salary: RM "+getBasicSalary()+
                "Gross Sales: RM "+getGrossSale();
    }

    public double calculateSalary(){
        return(getBasicSalary()+getGrossSale()+getCommissionRate());
    }
}
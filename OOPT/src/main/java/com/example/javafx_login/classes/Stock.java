package com.example.javafx_login.classes;

import java.io.*;

abstract public class Stock {
    //Variables
    private static int totalProducts;

    static File file = new File("stock.txt");

    //Getters
    public static int getTotalProducts() {
        return totalProducts;
    }

    //Methods
    //appending/add file data
    public static void addStock(String name, int quantity, double price) {
        if (!file.exists()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("stock.txt"));
                writer.write("Product Name | Stock Quantity | Price (RM)\n");
                writer.write("===========================================\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Unable to create file!");
                e.printStackTrace();
            }
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("stock.txt", true));
            writer.write(name + " | " + quantity + " | " + price + "\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to open file!");
            e.printStackTrace();

        } finally {
            totalProducts++;
        }
    }

    public static void updateStock(String name, int quantity){
        String[] selectedProductDetails;
        try {
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("temp.txt"));
            BufferedReader reader = new BufferedReader(new FileReader("stock.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(name)) {
                    selectedProductDetails = line.split(" \\| ", 0);
                    writer1.write(name + " | " + quantity + " | " + selectedProductDetails[2] + "\n");
                }
                else {
                    writer1.write(line);
                    writer1.write("\n");
                }
            }
            writer1.close();
            reader.close();

            File oldfile = new File("stock.txt");
            oldfile.delete();
            File newfile = new File("temp.txt");
            newfile.renameTo(new File("stock.txt"));

        } catch (IOException e){
            System.out.println("Unable to update file!");
            e.printStackTrace();
        }

    }

    //display all products(regardless availability)
    public static void getAllProducts(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("stock.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                //while condition will reinitiate reader.readLine() to read next line
                System.out.println(line);
            }
            reader.close();
        }

        catch (IOException e){
            System.out.println("Unable to read file!");
            e.printStackTrace();
        }
    }

    //check product availability
    public static boolean isProductAvailable (String itemName){
        String[] selectedProductDetails = new String[3];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("stock.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                if(line.contains(itemName)) {
                    selectedProductDetails = line.split(" \\| ", 0);
                }
            }
            reader.close();
        }

        catch (IOException e){
            System.out.println("Unable to read file!");
            e.printStackTrace();
        }

        return !selectedProductDetails[1].equals("0");
    }

    public static int getProductStockQuantity (String itemName){
        String[] selectedProductDetails = new String[3];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("stock.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                if(line.contains(itemName)) {
                    selectedProductDetails = line.split(" \\| ", 0);
                }
            }
            reader.close();
        }

        catch (IOException e){
            System.out.println("Unable to read file!");
            e.printStackTrace();
        }

        Integer integer = Integer.valueOf(selectedProductDetails[1]);
        return integer;
    }

    //display the details of the selected product
    public static void displayProductDetails (String name) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("stock.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.contains(name))
                    System.out.println(line);
            }
            reader.close();
        }

        catch (IOException e){
            System.out.println("Unable to read file!");
            e.printStackTrace();
        }
    }
}

package com.example.javafx_login.classes;

import java.io.*;

public class Stock {
    //Variables
    private static int totalProducts;

    //Getters
    public static int getTotalProducts() {
        return totalProducts;
    }

    static File file = new File("stock.txt");

    //Methods
    //appending/add file data
    public static void addStock(String name, String serialNum, int quantity, double price) {
        if (!file.exists()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("stock.txt"));
                writer.write("Product Name | Serial Number | Stock Quantity | Price (RM)\n");
                writer.write("==========================================================\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Unable to create file!");
                e.printStackTrace();
            }
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("stock.txt", true));
            writer.write(name + " | " + serialNum + " | " + quantity + " | " + price + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Unable to open file!");
            e.printStackTrace();
        } finally {
            totalProducts++;
        }
    }

    //display all products(regardless availability)
    public static void getAllProducts() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("stock.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                //while condition will reinitiate reader.readLine() to read next line
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Unable to read file!");
            e.printStackTrace();
        }
    }

    //check product availability
    public static boolean isProductAvailable(String itemName) {
        String[] selectedProductDetails = new String[4];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("stock.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains(itemName)) {
                    selectedProductDetails = line.split(" \\| ", 0);
                }
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Unable to read file!");
            e.printStackTrace();
        }

        return !selectedProductDetails[2].equals("0");
    }

    //display the details of the selected product
    public static void displayProductDetails(String itemName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("stock.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(itemName))
                    System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Unable to read file!");
            e.printStackTrace();
        }
    }

}

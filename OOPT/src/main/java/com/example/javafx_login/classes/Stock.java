package com.example.javafx_login.classes;

import java.io.*;

public abstract class Stock {
    //Variables
    private static int totalItems;

    private final static String txtPath = "txtFile/stock.txt";

    private static File file = new File("txtFile/stock.txt");

    //Getters
    public static int getTotalItems() {
        return totalItems;
    }

    //Methods
    //appending/add file data
    public static void addStock(String name, int quantity, double price) {
        if (!file.exists()) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(txtPath));
                writer.write("Product Name | Stock Quantity | Price (RM)\n");
                writer.write("===========================================\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Unable to create file!");
                e.printStackTrace();
            }
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(txtPath, true));
            writer.write(name + " | " + quantity + " | " + price + "\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to open file!");
            e.printStackTrace();

        } finally {
            totalItems++;
        }
    }

    public static void updateStock(String name, int quantity){
        String[] selectedItemDetails;
        try {
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("txtFile/temp.txt"));
            BufferedReader reader = new BufferedReader(new FileReader(txtPath));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(name)) {
                    selectedItemDetails = line.split(" \\| ", 0);
                    writer1.write(name + " | " + quantity + " | " + selectedItemDetails[2] + "\n");
                }
                else {
                    writer1.write(line);
                    writer1.write("\n");
                }
            }
            writer1.close();
            reader.close();

            File oldfile = new File(txtPath);
            oldfile.delete();
            File newfile = new File("txtFile/temp.txt");
            newfile.renameTo(new File(txtPath));

        } catch (IOException e){
            System.out.println("Unable to update file!");
            e.printStackTrace();
        }

    }

    //display all products(regardless availability)
    public static void getAllItems(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(txtPath));
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
    public static boolean isItemAvailable(String itemName){
        String[] selectedProductDetails = new String[3];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(txtPath));
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

    public static int getItemStockQuantity(String itemName){
        String[] selectedItemDetails = new String[3];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(txtPath));
            String line;

            while ((line = reader.readLine()) != null) {
                if(line.contains(itemName)) {
                    selectedItemDetails = line.split(" \\| ", 0);
                }
            }
            reader.close();
        }

        catch (IOException e){
            System.out.println("Unable to read file!");
            e.printStackTrace();
        }

        Integer integer = Integer.valueOf(selectedItemDetails[1]);
        return integer;
    }

    //display the details of the selected product
    public static void displayItemsDetails(String name) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(txtPath));
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

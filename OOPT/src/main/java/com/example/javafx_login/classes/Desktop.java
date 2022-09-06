package com.example.javafx_login.classes;

import java.util.HashMap;

public class Desktop extends Item {
    private static HashMap<String, Integer> desktopMap = new HashMap<>();

    public static HashMap<String, Integer> getDesktopMap() {
        return desktopMap;
    }

    public static void setDesktopMap(String key, int value) {
        Desktop.desktopMap.put(key, value);
    }

    public Desktop(String name) {
        super(name);
    }

    public double getPrice() {
        return 2000.00;
    }
}

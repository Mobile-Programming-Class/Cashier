package com.allam.cashier.myerrorhandler;

public class MyDouble {
    public static double myParseDouble (String input) {
        if (input.equals("")) {
            return 0.0;
        } else {
            return Double.parseDouble(input);
        }
    }
}

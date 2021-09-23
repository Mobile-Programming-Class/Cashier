package com.allam.cashier;

public class CartItem {
    public String name;
    public String item;
    public String numberOfItems;
    public String price;
    public String total;

    public CartItem(String name, String item, String numberOfItems, String price, String total) {
        this.name = name;
        this.item = item;
        this.numberOfItems = numberOfItems;
        this.price = price;
        this.total = total;
    }
}
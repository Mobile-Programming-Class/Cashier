package com.allam.cashier.model;

import androidx.annotation.Nullable;

public class Cart {
    String customerName, itemLabel, numberOfItems, price, moneyPaid;
    double dNumberOfItems, dPrice, dMoneyPaid, dTotal, dChanges;

    public Cart (String customerName,
                 String itemLabel,
                 String numberOfItems,
                 String price,
                 String moneyPaid,
                 double dNumberOfItems,
                 double dPrice,
                 double dMoneyPaid,
                 double dTotal,
                 double dChanges) {
        this.customerName = customerName;
        this.itemLabel = itemLabel;
        this.numberOfItems = numberOfItems;
        this.price = price;
        this.moneyPaid = moneyPaid;
        this.dNumberOfItems = dNumberOfItems;
        this.dPrice = dPrice;
        this.dMoneyPaid = dMoneyPaid;
        this.dTotal = dTotal;
        this.dChanges = dChanges;
    }

    @Nullable
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(@Nullable String customerName) {
        this.customerName = customerName;
    }

    @Nullable
    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(@Nullable String itemLabel) {
        this.itemLabel = itemLabel;
    }

    @Nullable
    public String getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(@Nullable String numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @Nullable
    public String getPrice() {
        return price;
    }

    public void setPrice(@Nullable String price) {
        this.price = price;
    }

    @Nullable
    public String getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(@Nullable String moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    @Nullable
    public double getdNumberOfItems() {
        return dNumberOfItems;
    }

    public void setdNumberOfItems(@Nullable double dNumberOfItems) {
        this.dNumberOfItems = dNumberOfItems;
    }

    @Nullable
    public double getdPrice() {
        return dPrice;
    }

    public void setdPrice(@Nullable double dPrice) {
        this.dPrice = dPrice;
    }

    @Nullable
    public double getdMoneyPaid() {
        return dMoneyPaid;
    }

    public void setdMoneyPaid(@Nullable double dMoneyPaid) {
        this.dMoneyPaid = dMoneyPaid;
    }

    @Nullable
    public double getdTotal() {
        return dTotal;
    }

    public void setdTotal(@Nullable double dTotal) {
        this.dTotal = dTotal;
    }

    @Nullable
    public double getdChanges() {
        return dChanges;
    }

    public void setdChanges(@Nullable double dChanges) {
        this.dChanges = dChanges;
    }
}

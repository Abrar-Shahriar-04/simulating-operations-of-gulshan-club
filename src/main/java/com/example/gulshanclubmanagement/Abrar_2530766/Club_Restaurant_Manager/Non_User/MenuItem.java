package com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Non_User;

import java.io.Serializable;

public class MenuItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String itemName;
    private double price;
    private String stockStatus;

    public MenuItem() {
    }

    public MenuItem(String itemName, double price, String stockStatus) {
        this.itemName = itemName;
        this.price = price;
        this.stockStatus = stockStatus;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }
}
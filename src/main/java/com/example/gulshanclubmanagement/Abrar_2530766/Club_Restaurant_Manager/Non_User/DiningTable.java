package com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Non_User;

import java.io.Serializable;

public class DiningTable implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tableName;
    private int guestCount;
    private String status;

    public DiningTable() {
    }

    public DiningTable(String tableName, int guestCount, String status) {
        this.tableName = tableName;
        this.guestCount = guestCount;
        this.status = status;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
package com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Non_User;

import java.io.Serializable;

public class RestaurantEmployee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String staffId;
    private String fullName;
    private String phoneNumber;
    private String role;

    public RestaurantEmployee() {
    }

    public RestaurantEmployee(String staffId, String fullName, String phoneNumber, String role) {
        this.staffId = staffId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import java.io.Serializable;
import java.time.LocalDate;

public class ParkingFee implements Serializable {
    private final int hourlyRate;
    private String vehicleNumber;
    private int hours;
    private float amount;
    private LocalDate date;

    public int getHourlyRate() {
        return hourlyRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ParkingFee(String vehicleNumber, int hours, float amount, LocalDate date) {
        this.hourlyRate = 30;
        this.vehicleNumber = vehicleNumber;
        this.hours = hours;
        this.amount = amount;
        this.date = date;
    }

    public void calculateFee(){
        return;
    }






}

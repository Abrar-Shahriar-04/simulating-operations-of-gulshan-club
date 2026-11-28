package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import java.io.Serializable;
import java.time.LocalDate;

public class ParkingFee implements Serializable {
    private static final int hourlyRate=30;
    private String vehicleNumber;
    private float hours;
    private float parkingFee ;
    private LocalDate date;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public float getHours() {
        return hours;
    }

    public void setHours(float hours) {
        this.hours = hours;
    }

    public float getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(float parkingFee) {
        this.parkingFee = parkingFee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ParkingFee(String vehicleNumber, float hours, float parkingFee, LocalDate date) {
        this.vehicleNumber = vehicleNumber;
        this.hours = hours;
        this.parkingFee = parkingFee;
        this.date = date;
    }

}

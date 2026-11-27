package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import java.io.Serializable;
import java.time.LocalDateTime;

public class VehicleRecord implements Serializable {
    private final String vehicleNumber;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private String status;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public VehicleRecord(String vehicleNumber, LocalDateTime entryTime, LocalDateTime exitTime, String status) {
        this.vehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.status = status;
    }

    @Override
    public String toString() {
        return "VehicleRecord{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", status='" + status + '\'' +
                '}';
    }
}

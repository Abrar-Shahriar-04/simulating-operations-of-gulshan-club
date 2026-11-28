package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User;

public class ValetVehicle {

    private String memberId;
    private String licensePlate;
    private String keyTagNumber;
    private String timeIn;
    private String status;

    public ValetVehicle() {
    }

    public ValetVehicle(String memberId, String licensePlate, String keyTagNumber, String timeIn, String status) {
        this.memberId = memberId;
        this.licensePlate = licensePlate;
        this.keyTagNumber = keyTagNumber;
        this.timeIn = timeIn;
        this.status = status;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getKeyTagNumber() {
        return keyTagNumber;
    }

    public void setKeyTagNumber(String keyTagNumber) {
        this.keyTagNumber = keyTagNumber;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
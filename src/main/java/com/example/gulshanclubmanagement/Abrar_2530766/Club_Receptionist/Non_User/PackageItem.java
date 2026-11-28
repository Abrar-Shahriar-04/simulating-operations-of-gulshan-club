package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User;

public class PackageItem {

    private String memberId;
    private String courierName;
    private String trackingNumber;
    private String date;
    private String status;

    public PackageItem() {
    }

    public PackageItem(String memberId, String courierName, String trackingNumber, String date, String status) {
        this.memberId = memberId;
        this.courierName = courierName;
        this.trackingNumber = trackingNumber;
        this.date = date;
        this.status = status;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

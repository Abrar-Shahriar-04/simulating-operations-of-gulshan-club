package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User;

public class TaxiRequest {

    private String memberId;
    private String destination;
    private String preferredTime;
    private String cabServiceName;
    private String status;

    public TaxiRequest() {
    }

    public TaxiRequest(String memberId, String destination, String preferredTime, String cabServiceName, String status) {
        this.memberId = memberId;
        this.destination = destination;
        this.preferredTime = preferredTime;
        this.cabServiceName = cabServiceName;
        this.status = status;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPreferredTime() {
        return preferredTime;
    }

    public void setPreferredTime(String preferredTime) {
        this.preferredTime = preferredTime;
    }

    public String getCabServiceName() {
        return cabServiceName;
    }

    public void setCabServiceName(String cabServiceName) {
        this.cabServiceName = cabServiceName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

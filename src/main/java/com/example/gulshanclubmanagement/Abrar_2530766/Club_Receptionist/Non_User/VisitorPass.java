package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User;

public class VisitorPass {

    private String passId;
    private String visitorName;
    private String phoneNumber;
    private String hostMember;
    private String purpose;
    private String status;

    public VisitorPass() {
    }

    public VisitorPass(String passId, String visitorName, String phoneNumber, String hostMember, String purpose, String status) {
        this.passId = passId;
        this.visitorName = visitorName;
        this.phoneNumber = phoneNumber;
        this.hostMember = hostMember;
        this.purpose = purpose;
        this.status = status;
    }

    public String getPassId() {
        return passId;
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHostMember() {
        return hostMember;
    }

    public void setHostMember(String hostMember) {
        this.hostMember = hostMember;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VisitorPass{" +
                "passId='" + passId + '\'' +
                ", visitorName='" + visitorName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hostMember='" + hostMember + '\'' +
                ", purpose='" + purpose + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User;

public class MobilityRental {

    private String equipmentType;
    private String borrowerName;
    private String memberId;
    private String timeOut;
    private String status;

    public MobilityRental() {
    }

    public MobilityRental(String equipmentType, String borrowerName, String memberId, String timeOut, String status) {
        this.equipmentType = equipmentType;
        this.borrowerName = borrowerName;
        this.memberId = memberId;
        this.timeOut = timeOut;
        this.status = status;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

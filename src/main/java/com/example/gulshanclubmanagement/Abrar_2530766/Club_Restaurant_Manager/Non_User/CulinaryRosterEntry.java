package com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Non_User;

import java.io.Serializable;

public class CulinaryRosterEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    private String staffName;
    private String diningStation;
    private String shiftSchedule;

    public CulinaryRosterEntry() {
    }

    public CulinaryRosterEntry(String staffName, String diningStation, String shiftSchedule) {
        this.staffName = staffName;
        this.diningStation = diningStation;
        this.shiftSchedule = shiftSchedule;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getDiningStation() {
        return diningStation;
    }

    public void setDiningStation(String diningStation) {
        this.diningStation = diningStation;
    }

    public String getShiftSchedule() {
        return shiftSchedule;
    }

    public void setShiftSchedule(String shiftSchedule) {
        this.shiftSchedule = shiftSchedule;
    }
}
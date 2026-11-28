package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User;

public class FacilitySchedule {

    private String facilityName;
    private String openingHours;
    private String closingHours;

    public FacilitySchedule() {
    }

    public FacilitySchedule(String facilityName, String openingHours, String closingHours) {
        this.facilityName = facilityName;
        this.openingHours = openingHours;
        this.closingHours = closingHours;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getClosingHours() {
        return closingHours;
    }

    public void setClosingHours(String closingHours) {
        this.closingHours = closingHours;
    }
}

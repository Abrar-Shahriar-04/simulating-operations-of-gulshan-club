package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User;

public class LostPropertyItem {

    private String description;
    private String locationFound;
    private String date;
    private String finderName;
    private String status;

    public LostPropertyItem() {
    }

    public LostPropertyItem(String description, String locationFound, String date, String finderName, String status) {
        this.description = description;
        this.locationFound = locationFound;
        this.date = date;
        this.finderName = finderName;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocationFound() {
        return locationFound;
    }

    public void setLocationFound(String locationFound) {
        this.locationFound = locationFound;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFinderName() {
        return finderName;
    }

    public void setFinderName(String finderName) {
        this.finderName = finderName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LostPropertyItem{" +
                "description='" + description + '\'' +
                ", locationFound='" + locationFound + '\'' +
                ", date='" + date + '\'' +
                ", finderName='" + finderName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

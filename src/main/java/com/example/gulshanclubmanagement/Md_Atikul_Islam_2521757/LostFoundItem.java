package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import java.io.Serializable;
import java.time.LocalDate;

public class LostFoundItem implements Serializable {
    private String Item;
    private String locationFound;
    private String finderName;
    private LocalDate dateFound;
    private String status;
    private String ClaimedBy;

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getLocationFound() {
        return locationFound;
    }

    public void setLocationFound(String locationFound) {
        this.locationFound = locationFound;
    }

    public String getFinderName() {
        return finderName;
    }

    public void setFinderName(String finderName) {
        this.finderName = finderName;
    }

    public LocalDate getDateFound() {
        return dateFound;
    }

    public void setDateFound(LocalDate dateFound) {
        this.dateFound = dateFound;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClaimedBy() {
        return ClaimedBy;
    }

    public void setClaimedBy(String claimedBy) {
        ClaimedBy = claimedBy;
    }

    public LostFoundItem(String item, String locationFound, String finderName, LocalDate dateFound, String status, String claimedBy) {
        Item = item;
        this.locationFound = locationFound;
        this.finderName = finderName;
        this.dateFound = dateFound;
        this.status = status;
        ClaimedBy = claimedBy;
    }

    @Override
    public String toString() {
        return "LostFoundItem{" +
                "Item='" + Item + '\'' +
                ", locationFound='" + locationFound + '\'' +
                ", finderName='" + finderName + '\'' +
                ", dateFound=" + dateFound +
                ", status='" + status + '\'' +
                ", ClaimedBy='" + ClaimedBy + '\'' +
                '}';
    }
}

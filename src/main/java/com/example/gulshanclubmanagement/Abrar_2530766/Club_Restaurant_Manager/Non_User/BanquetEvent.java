package com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Non_User;

import java.io.Serializable;

public class BanquetEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String eventName;
    private String theme;
    private int targetAttendees;
    private String assignedHall;

    public BanquetEvent() {
    }

    public BanquetEvent(String eventName, String theme, int targetAttendees, String assignedHall) {
        this.eventName = eventName;
        this.theme = theme;
        this.targetAttendees = targetAttendees;
        this.assignedHall = assignedHall;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getTargetAttendees() {
        return targetAttendees;
    }

    public void setTargetAttendees(int targetAttendees) {
        this.targetAttendees = targetAttendees;
    }

    public String getAssignedHall() {
        return assignedHall;
    }

    public void setAssignedHall(String assignedHall) {
        this.assignedHall = assignedHall;
    }
}
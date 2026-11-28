package com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Non_User;

import java.io.Serializable;

public class PrivateDiningReservation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String memberId;
    private String date;
    private String timeSlot;
    private int guestCount;

    public PrivateDiningReservation() {
    }

    public PrivateDiningReservation(String memberId, String date, String timeSlot, int guestCount) {
        this.memberId = memberId;
        this.date = date;
        this.timeSlot = timeSlot;
        this.guestCount = guestCount;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }
}
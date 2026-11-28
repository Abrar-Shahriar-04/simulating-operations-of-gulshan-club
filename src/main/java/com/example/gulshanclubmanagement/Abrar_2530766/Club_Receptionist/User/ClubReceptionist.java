package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.User;

public class ClubReceptionist {

    private String name;
    private String staffId;
    private String username;
    private String password;

    public ClubReceptionist() {
    }

    public ClubReceptionist(String name, String staffId, String username, String password) {
        this.name = name;
        this.staffId = staffId;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ClubReceptionist{" +
                "name='" + name + '\'' +
                ", staffId='" + staffId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

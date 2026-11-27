package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import java.io.Serializable;

public abstract class User implements Serializable {
    protected String userID;
    protected String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

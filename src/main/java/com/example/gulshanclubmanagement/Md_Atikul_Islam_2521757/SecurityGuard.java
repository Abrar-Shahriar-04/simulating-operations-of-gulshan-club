package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import java.io.Serializable;

public class SecurityGuard extends User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SecurityGuard(String userID, String password, String name) {
        super(userID, password);
        this.name = name;
    }

    @Override
    public String toString() {
        return "SecurityGuard{" +
                "name='" + name + '\'' +
                ", userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



}


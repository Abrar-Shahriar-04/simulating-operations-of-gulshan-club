package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import java.io.Serializable;

public class LibraryAssistant extends User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LibraryAssistant(String userID, String password, String name) {
        super(userID, password);
        this.name = name;
    }

    @Override
    public String toString() {
        return "LibraryAssistant{" +
                "name='" + name + '\'' +
                ", userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

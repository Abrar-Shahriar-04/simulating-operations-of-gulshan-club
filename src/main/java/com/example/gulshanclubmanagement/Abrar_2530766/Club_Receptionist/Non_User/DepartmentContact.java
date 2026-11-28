package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User;

public class DepartmentContact {

    private String departmentName;
    private String extensionNumber;
    private String emergencyHotline;

    public DepartmentContact() {
    }

    public DepartmentContact(String departmentName, String extensionNumber, String emergencyHotline) {
        this.departmentName = departmentName;
        this.extensionNumber = extensionNumber;
        this.emergencyHotline = emergencyHotline;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(String extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

    public String getEmergencyHotline() {
        return emergencyHotline;
    }

    public void setEmergencyHotline(String emergencyHotline) {
        this.emergencyHotline = emergencyHotline;
    }
}

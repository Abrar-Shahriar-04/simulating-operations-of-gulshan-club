package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ContractorEntry implements Serializable {
    private final String name;
    private String company;
    private String contactNumber;
    private String workPurpose;
    private LocalDateTime entryTime;

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getWorkPurpose() {
        return workPurpose;
    }

    public void setWorkPurpose(String workPurpose) {
        this.workPurpose = workPurpose;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public ContractorEntry(String name, String company, String contactNumber, String workPurpose, LocalDateTime entryTime) {
        this.name = name;
        this.company = company;
        this.contactNumber = contactNumber;
        this.workPurpose = workPurpose;
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return "ContractorEntry{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", workPurpose='" + workPurpose + '\'' +
                ", entryTime=" + entryTime +
                '}';
    }
}

package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SecurityIncident implements Serializable {
    private String incidentType;
    private String location;
    private String description;
    private LocalDate date;
    private String reportedBy;

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public SecurityIncident(String incidentType, String location, String description, LocalDate date, String reportedBy) {
        this.incidentType = incidentType;
        this.location = location;
        this.description = description;
        this.date = date;
        this.reportedBy = reportedBy;
    }

    @Override
    public String toString() {
        return "SecurityIncident{" +
                "incidentType='" + incidentType + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", reportedBy='" + reportedBy + '\'' +
                '}';
    }
}

package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SecurityIncident implements Serializable {
    private String incidentType;
    private String location;
    private String description;
    private LocalDateTime date;
    private String recordedBy;

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getRecordedBy() {
        return recordedBy;
    }

    public void setRecordedBy(String recordedBy) {
        this.recordedBy = recordedBy;
    }

    public SecurityIncident(String incidentType, String location, String description, LocalDateTime date, String recordedBy) {
        this.incidentType = incidentType;
        this.location = location;
        this.description = description;
        this.date = date;
        this.recordedBy = recordedBy;
    }

    @Override
    public String toString() {
        return "SecurityIncident{" +
                "incidentType='" + incidentType + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", recordedBy='" + recordedBy + '\'' +
                '}';
    }
}

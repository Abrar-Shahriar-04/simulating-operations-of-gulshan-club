package com.example.gulshanclubmanagement.Md_Atikul_Islam_2521757;

import java.io.Serializable;
import java.time.LocalDate;

public class CCTVCamera implements Serializable {
    private int cameraNo;
    private String status;
    private LocalDate lastChecked;

    public int getCameraNo() {
        return cameraNo;
    }

    public void setCameraNo(int cameraNo) {
        this.cameraNo = cameraNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(LocalDate lastChecked) {
        this.lastChecked = lastChecked;
    }

    public CCTVCamera(int cameraNo, String status, LocalDate lastChecked) {
        this.cameraNo = cameraNo;
        this.status = status;
        this.lastChecked = lastChecked;
    }

    @Override
    public String toString() {
        return "CCTVCamera{" +
                "cameraNo=" + cameraNo +
                ", status='" + status + '\'' +
                ", lastChecked=" + lastChecked +
                '}';
    }
}

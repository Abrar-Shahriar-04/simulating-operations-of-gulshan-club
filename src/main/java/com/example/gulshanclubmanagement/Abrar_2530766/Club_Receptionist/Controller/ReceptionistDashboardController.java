package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ReceptionistDashboardController {

    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/gulshanclubmanagement/Abrar_2530766/Club_Receptionist/" + fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openVisitorPass(ActionEvent event) {
        switchScene(event, "visitor_pass.fxml");
    }

    public void openPackageDesk(ActionEvent event) {
        switchScene(event, "package_desk.fxml");
    }

    public void openLostProperty(ActionEvent event) {
        switchScene(event, "lost_property.fxml");
    }

    public void openValetParking(ActionEvent event) {
        switchScene(event, "valet_parking.fxml");
    }

    public void openFacilitySchedule(ActionEvent event) {
        switchScene(event, "facility_schedule.fxml");
    }

    public void openPhoneDirectory(ActionEvent event) {
        switchScene(event, "phone_directory.fxml");
    }

    public void openTaxiDesk(ActionEvent event) {
        switchScene(event, "taxi_desk.fxml");
    }

    public void openMobilityRental(ActionEvent event) {
        switchScene(event, "mobility_rental.fxml");
    }

    public void logout(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/gulshanclubmanagement/hello-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
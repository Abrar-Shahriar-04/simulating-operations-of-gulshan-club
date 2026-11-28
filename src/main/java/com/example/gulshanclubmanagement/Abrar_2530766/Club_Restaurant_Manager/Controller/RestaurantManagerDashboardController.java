package com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RestaurantManagerDashboardController {

    private void switchScene(ActionEvent event, String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/gulshanclubmanagement/Abrar_2530766/Club_Restaurant_Manager/" + fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openTableLayout(ActionEvent event) {
        switchScene(event, "table_layout.fxml");
    }

    public void openPdrReservations(ActionEvent event) {
        switchScene(event, "pdr_reservations.fxml");
    }

    public void openBanquetEvents(ActionEvent event) {
        switchScene(event, "banquet_events.fxml");
    }

    public void openMenuPricing(ActionEvent event) {
        switchScene(event, "menu_pricing.fxml");
    }

    public void openMenuStock(ActionEvent event) {
        switchScene(event, "menu_stock.fxml");
    }

    public void openCulinaryRoster(ActionEvent event) {
        switchScene(event, "culinary_roster.fxml");
    }

    public void openManageStaff(ActionEvent event) {
        switchScene(event, "manage_staff.fxml");
    }

    public void openStaffDirectory(ActionEvent event) {
        switchScene(event, "staff_directory.fxml");
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
package com.example.gulshanclubmanagement;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
        roleComboBox.setItems(FXCollections.observableArrayList("Club Receptionist", "Club Restaurant Manager"));
    }

    public void handleLogin(ActionEvent event) {
        String role = roleComboBox.getValue();

        if (role == null) {
            errorLabel.setText("Please select a role.");
            return;
        }

        if ("Club Receptionist".equals(role)) {
            switchScene(event, "/com/example/gulshanclubmanagement/Abrar_2530766/Club_Receptionist/receptionist_dashboard.fxml");
        } else if ("Club Restaurant Manager".equals(role)) {
            switchScene(event, "/com/example/gulshanclubmanagement/Abrar_2530766/Club_Restaurant_Manager/restaurant_manager_dashboard.fxml");
        }
    }

    private void switchScene(ActionEvent event, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
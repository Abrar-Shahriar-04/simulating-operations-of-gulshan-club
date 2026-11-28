package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User.FacilitySchedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class FacilityScheduleController {

    @FXML
    private TableView<FacilitySchedule> scheduleTable;

    @FXML
    private TableColumn<FacilitySchedule, String> colFacility;

    @FXML
    private TableColumn<FacilitySchedule, String> colOpening;

    @FXML
    private TableColumn<FacilitySchedule, String> colClosing;

    @FXML
    public void initialize() {
        colFacility.setCellValueFactory(new PropertyValueFactory<>("facilityName"));
        colOpening.setCellValueFactory(new PropertyValueFactory<>("openingHours"));
        colClosing.setCellValueFactory(new PropertyValueFactory<>("closingHours"));

        ObservableList<FacilitySchedule> list = FXCollections.observableArrayList(
                new FacilitySchedule("Dining Hall", "07:30 AM", "11:00 PM"),
                new FacilitySchedule("Gym", "06:00 AM", "10:00 PM"),
                new FacilitySchedule("Swimming Pool", "06:30 AM", "09:00 PM"),
                new FacilitySchedule("Library", "09:00 AM", "08:00 PM"),
                new FacilitySchedule("Banquet Rooms", "10:00 AM", "11:30 PM")
        );
        scheduleTable.setItems(list);
    }

    public void backToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/gulshanclubmanagement/Abrar_2530766/Club_Receptionist/receptionist_dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User.ValetVehicle;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ValetParkingController {

    @FXML
    private TextField memberIdField;

    @FXML
    private TextField licensePlateField;

    @FXML
    private TextField keyTagField;

    @FXML
    private TextField timeInField;

    @FXML
    private TextField searchTagField;

    @FXML
    private TableView<ValetVehicle> valetTable;

    @FXML
    private TableColumn<ValetVehicle, String> colMemberId;

    @FXML
    private TableColumn<ValetVehicle, String> colLicense;

    @FXML
    private TableColumn<ValetVehicle, String> colTag;

    @FXML
    private TableColumn<ValetVehicle, String> colTimeIn;

    @FXML
    private TableColumn<ValetVehicle, String> colStatus;

    private static final ObservableList<ValetVehicle> valetList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colLicense.setCellValueFactory(new PropertyValueFactory<>("licensePlate"));
        colTag.setCellValueFactory(new PropertyValueFactory<>("keyTagNumber"));
        colTimeIn.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        valetTable.setItems(valetList);
    }

    public void registerVehicle(ActionEvent event) {
        String memberId = memberIdField.getText();
        String license = licensePlateField.getText();
        String tag = keyTagField.getText();
        String timeIn = timeInField.getText();

        if (license.isEmpty() || tag.isEmpty()) {
            return;
        }

        ValetVehicle car = new ValetVehicle(memberId, license, tag, timeIn, "Parked");
        valetList.add(car);

        memberIdField.clear();
        licensePlateField.clear();
        keyTagField.clear();
        timeInField.clear();
    }

    public void processKeyHandback(ActionEvent event) {
        ValetVehicle selected = valetTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Returned");
            valetTable.refresh();
        }
    }

    public void searchByTag(ActionEvent event) {
        String tagKey = searchTagField.getText().trim().toLowerCase();
        if (tagKey.isEmpty()) {
            valetTable.setItems(valetList);
            return;
        }
        ObservableList<ValetVehicle> matched = FXCollections.observableArrayList();
        for (ValetVehicle car : valetList) {
            if (car.getKeyTagNumber() != null && car.getKeyTagNumber().toLowerCase().contains(tagKey)) {
                matched.add(car);
            }
        }
        valetTable.setItems(matched);
    }

    public void showAllCars(ActionEvent event) {
        valetTable.setItems(valetList);
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
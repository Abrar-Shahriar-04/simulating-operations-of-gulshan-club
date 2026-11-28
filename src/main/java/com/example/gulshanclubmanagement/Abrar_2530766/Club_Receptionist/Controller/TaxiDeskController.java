package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User.TaxiRequest;
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

public class TaxiDeskController {

    @FXML
    private TextField memberIdField;

    @FXML
    private TextField destinationField;

    @FXML
    private TextField timeField;

    @FXML
    private TextField cabServiceField;

    @FXML
    private TableView<TaxiRequest> taxiTable;

    @FXML
    private TableColumn<TaxiRequest, String> colMemberId;

    @FXML
    private TableColumn<TaxiRequest, String> colDestination;

    @FXML
    private TableColumn<TaxiRequest, String> colTime;

    @FXML
    private TableColumn<TaxiRequest, String> colCabService;

    @FXML
    private TableColumn<TaxiRequest, String> colStatus;

    private static final ObservableList<TaxiRequest> taxiList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("preferredTime"));
        colCabService.setCellValueFactory(new PropertyValueFactory<>("cabServiceName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        taxiTable.setItems(taxiList);
    }

    public void addTaxiRequest(ActionEvent event) {
        String memberId = memberIdField.getText();
        String destination = destinationField.getText();
        String time = timeField.getText();
        String cabService = cabServiceField.getText();

        if (memberId.isEmpty() || destination.isEmpty()) {
            return;
        }

        TaxiRequest req = new TaxiRequest(memberId, destination, time, cabService, "Active");
        taxiList.add(req);

        memberIdField.clear();
        destinationField.clear();
        timeField.clear();
        cabServiceField.clear();
    }

    public void completeRide(ActionEvent event) {
        TaxiRequest selected = taxiTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Completed");
            taxiTable.refresh();
        }
    }

    public void cancelRide(ActionEvent event) {
        TaxiRequest selected = taxiTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Cancelled");
            taxiTable.refresh();
        }
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
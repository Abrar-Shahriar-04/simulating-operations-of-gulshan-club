package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User.PackageItem;
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

public class PackageDeskController {

    @FXML
    private TextField memberIdField;

    @FXML
    private TextField courierField;

    @FXML
    private TextField trackingField;

    @FXML
    private TextField dateField;

    @FXML
    private TextField searchMemberField;

    @FXML
    private TableView<PackageItem> packageTable;

    @FXML
    private TableColumn<PackageItem, String> colMemberId;

    @FXML
    private TableColumn<PackageItem, String> colCourier;

    @FXML
    private TableColumn<PackageItem, String> colTracking;

    @FXML
    private TableColumn<PackageItem, String> colDate;

    @FXML
    private TableColumn<PackageItem, String> colStatus;

    private static final ObservableList<PackageItem> packageList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        colCourier.setCellValueFactory(new PropertyValueFactory<>("courierName"));
        colTracking.setCellValueFactory(new PropertyValueFactory<>("trackingNumber"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        packageTable.setItems(packageList);
    }

    public void logPackage(ActionEvent event) {
        String memberId = memberIdField.getText();
        String courier = courierField.getText();
        String tracking = trackingField.getText();
        String date = dateField.getText();

        if (memberId.isEmpty() || tracking.isEmpty()) {
            return;
        }

        PackageItem item = new PackageItem(memberId, courier, tracking, date, "Pending");
        packageList.add(item);

        memberIdField.clear();
        courierField.clear();
        trackingField.clear();
        dateField.clear();
    }

    public void markPickedUp(ActionEvent event) {
        PackageItem selected = packageTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Picked Up");
            packageTable.refresh();
        }
    }

    public void showPendingOnly(ActionEvent event) {
        ObservableList<PackageItem> pending = FXCollections.observableArrayList();
        for (PackageItem item : packageList) {
            if ("Pending".equalsIgnoreCase(item.getStatus())) {
                pending.add(item);
            }
        }
        packageTable.setItems(pending);
    }

    public void searchByMemberId(ActionEvent event) {
        String key = searchMemberField.getText().trim().toLowerCase();
        if (key.isEmpty()) {
            packageTable.setItems(packageList);
            return;
        }
        ObservableList<PackageItem> matched = FXCollections.observableArrayList();
        for (PackageItem item : packageList) {
            if (item.getMemberId() != null && item.getMemberId().toLowerCase().contains(key)) {
                matched.add(item);
            }
        }
        packageTable.setItems(matched);
    }

    public void showAllPackages(ActionEvent event) {
        packageTable.setItems(packageList);
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
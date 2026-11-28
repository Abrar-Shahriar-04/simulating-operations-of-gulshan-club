package com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Receptionist.Non_User.LostPropertyItem;
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

public class LostPropertyController {

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField locationField;

    @FXML
    private TextField dateField;

    @FXML
    private TextField finderField;

    @FXML
    private TextField searchKeywordField;

    @FXML
    private TableView<LostPropertyItem> lostTable;

    @FXML
    private TableColumn<LostPropertyItem, String> colDesc;

    @FXML
    private TableColumn<LostPropertyItem, String> colLocation;

    @FXML
    private TableColumn<LostPropertyItem, String> colDate;

    @FXML
    private TableColumn<LostPropertyItem, String> colFinder;

    @FXML
    private TableColumn<LostPropertyItem, String> colStatus;

    private static final ObservableList<LostPropertyItem> lostList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("locationFound"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colFinder.setCellValueFactory(new PropertyValueFactory<>("finderName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        lostTable.setItems(lostList);
    }

    public void recordItem(ActionEvent event) {
        String desc = descriptionField.getText();
        String location = locationField.getText();
        String date = dateField.getText();
        String finder = finderField.getText();

        if (desc.isEmpty()) {
            return;
        }

        LostPropertyItem item = new LostPropertyItem(desc, location, date, finder, "Unclaimed");
        lostList.add(item);

        descriptionField.clear();
        locationField.clear();
        dateField.clear();
        finderField.clear();
    }

    public void markClaimed(ActionEvent event) {
        LostPropertyItem selected = lostTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Claimed / Returned");
            lostTable.refresh();
        }
    }

    public void showUnclaimed(ActionEvent event) {
        ObservableList<LostPropertyItem> unclaimed = FXCollections.observableArrayList();
        for (LostPropertyItem item : lostList) {
            if ("Unclaimed".equalsIgnoreCase(item.getStatus())) {
                unclaimed.add(item);
            }
        }
        lostTable.setItems(unclaimed);
    }

    public void searchItems(ActionEvent event) {
        String key = searchKeywordField.getText().trim().toLowerCase();
        if (key.isEmpty()) {
            lostTable.setItems(lostList);
            return;
        }
        ObservableList<LostPropertyItem> matched = FXCollections.observableArrayList();
        for (LostPropertyItem item : lostList) {
            boolean matchDesc = item.getDescription() != null && item.getDescription().toLowerCase().contains(key);
            boolean matchLoc = item.getLocationFound() != null && item.getLocationFound().toLowerCase().contains(key);
            boolean matchFinder = item.getFinderName() != null && item.getFinderName().toLowerCase().contains(key);
            if (matchDesc || matchLoc || matchFinder) {
                matched.add(item);
            }
        }
        lostTable.setItems(matched);
    }

    public void showAllItems(ActionEvent event) {
        lostTable.setItems(lostList);
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
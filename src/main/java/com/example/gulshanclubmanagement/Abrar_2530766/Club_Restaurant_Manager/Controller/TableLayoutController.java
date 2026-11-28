package com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Controller;

import com.example.gulshanclubmanagement.Abrar_2530766.Club_Restaurant_Manager.Non_User.DiningTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TableLayoutController {

    @FXML
    private TableView<DiningTable> tableView;

    @FXML
    private TableColumn<DiningTable, String> colTableName;

    @FXML
    private TableColumn<DiningTable, Integer> colGuests;

    @FXML
    private TableColumn<DiningTable, String> colStatus;

    @FXML
    private TextField guestCountField;

    @FXML
    private Label infoLabel;

    private final ObservableList<DiningTable> tableList = FXCollections.observableArrayList();
    private final String fileName = "dining_tables.bin";

    @FXML
    public void initialize() {
        colTableName.setCellValueFactory(new PropertyValueFactory<>("tableName"));
        colGuests.setCellValueFactory(new PropertyValueFactory<>("guestCount"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableView.setItems(tableList);
        loadFromFile();
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        tableList.clear();
        File file = new File(fileName);
        if (!file.exists()) {
            for (int i = 1; i <= 15; i++) {
                tableList.add(new DiningTable("Table " + i, 0, "Free"));
            }
            saveToFile();
            return;
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<DiningTable> savedList = (ArrayList<DiningTable>) ois.readObject();
            tableList.addAll(savedList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    private void saveToFile() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(new ArrayList<>(tableList));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    public void toggleTableStatus(ActionEvent event) {
        DiningTable selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            return;
        }

        int guests = 0;
        if (!guestCountField.getText().trim().isEmpty()) {
            try {
                guests = Integer.parseInt(guestCountField.getText().trim());
            } catch (NumberFormatException e) {
                return;
            }
        }

        if ("Free".equalsIgnoreCase(selected.getStatus())) {
            selected.setStatus("Occupied");
            selected.setGuestCount(guests > 0 ? guests : 2);
        } else {
            selected.setStatus("Free");
            selected.setGuestCount(0);
        }

        infoLabel.setText("Selected: " + selected.getTableName() + " | Guests: " + selected.getGuestCount() + " | " + selected.getStatus());
        guestCountField.clear();
        tableView.refresh();
        saveToFile();
    }

    public void backToDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/gulshanclubmanagement/Abrar_2530766/Club_Restaurant_Manager/restaurant_manager_dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}